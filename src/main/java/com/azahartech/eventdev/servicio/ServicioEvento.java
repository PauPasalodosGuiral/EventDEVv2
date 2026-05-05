package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.ListaEventosWrapper;
import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.util.GestorPersistencia;
import com.azahartech.eventdev.util.UtilidadLog;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Clase ServicioEvento
 */
public class ServicioEvento {
    private RepositorioGenerico<Evento> repo = new RepositorioGenerico<>();
    private HashMap<String, Evento> mapaEventos = new HashMap<>();
    private static final String FICHERO_DATOS = "datos/eventos.dat";

    public ServicioEvento() {
        //GestorPersistencia gestorPersistencia = new GestorPersistencia();
        //this.repo.cargar(gestorPersistencia.cargarDatos(FICHERO_DATOS));
    }


    /**
     * Añadir un evento
     * @param nuevoEvento
     */
    public void registrarEvento(Evento nuevoEvento) {
        repo.guardar(nuevoEvento);
        mapaEventos.put(nuevoEvento.getId(), nuevoEvento);
    }

    /**
     * Buscar un evento por id
     * @param idABuscar
     * @return
     */
    public Evento buscarEventoPorId(String idABuscar) {
        return mapaEventos.get(idABuscar);
    }

    /**
     * Buscar un evento por precio mas alto
     * @return
     */
    public Evento buscarEventoMasCaro() {
        List<Evento> eventos = repo.listar();
        if (eventos.isEmpty()) return null;

        Evento masCaro = eventos.get(0);

        for (int i = 1; i < eventos.size(); i++) {
            if (eventos.get(i).getPrecio() > masCaro.getPrecio()) {
                masCaro = eventos.get(i);
            }
        }
        return masCaro;
    }

    /**
     * Mostrar catalogo
     */
    public void mostrarTodoElCatalogo() {
        mapaEventos.values().forEach(Evento::mostrarInformacion);
    }

    /**
     * Eliminar eventos pasados
     */
    public void eliminarEventosPasados() {
        Iterator<Evento> iterador = repo.listar().iterator();
        while (iterador.hasNext()) {
            Evento e = iterador.next();
            if (e.getFecha().isBefore(LocalDate.now())) {
                mapaEventos.remove(e.getId());
                System.out.println("Evento caducado eliminado: "+ e.getNombre());
                iterador.remove();
            }
        }
    }
    /**
     * Contar eventos gratuitos
     * @return
     */
    public long contarEventosGratuitos() {
        long numero = mapaEventos.values().stream()
                .filter(e -> e.getPrecio() == 0)
                .count();
        UtilidadLog.registrar("RESPONSE: Hay " + numero + " Eventos Gratuitos");
        return numero;
    }

    /**
     * Contar eventos por aforo
     * @param aforoMinimo
     * @return
     */
    public long contarEventosPorAforo(int aforoMinimo) {
        return mapaEventos.values().stream()
                .filter(e -> e.getRecinto().getAforoMaximo() >= aforoMinimo)
                .count();
    }

    /**
     * Cierre de eventos
     * @param sc
     */
    public void procesarCierreEventos(Scanner sc) {
        for (Evento e : mapaEventos.values()) {
            if (e.getEstado() == EstadoEvento.ACTIVO) {
                System.out.println("Cerrando: " + e.getNombre());

                if (e instanceof Partido p) {
                    System.out.print("Introduce resultado (ej. 2-1): ");
                    p.setResultadoMarcador(sc.nextLine());
                } else if (e instanceof Concierto c) {
                    System.out.print("Introduce lista de canciones: ");
                }
                e.finalizarEvento();
            }
        }
    }

    /**
     * Lista todos los eventos guardado en la Lista
     * @return
     */
    public List<Evento> listarTodosLosEventos(){
        return repo.listar();
    }


    public void importarEventosDesdeCSV(String rutaArchivo) {
        File file = new File(rutaArchivo);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String linea;
            int numeroLinea = 0;

            reader.readLine();
            numeroLinea++;

            while ((linea = reader.readLine()) != null) {
                numeroLinea++;

                try {
                    String[] datos = linea.split(";");

                    String nombreStr = datos[0];
                    LocalDate fechaStr = LocalDate.parse(datos[2]);
                    double precioStr = Double.parseDouble(datos[4]);

                    Concierto concierto = new Concierto(nombreStr, fechaStr, new Recinto(null, null, 0), precioStr, TipoEvento.CONCIERTO, null, 0, null);

                    mapaEventos.put(concierto.getId(), concierto);
                    repo.guardar(concierto);

                    System.out.println("Importado: " + nombreStr);



                } catch (Exception e) {
                    System.err.println("Error en línea " + numeroLinea + ": formato inválido");
                    UtilidadLog.registrar("ERROR: Fallo al importar línea del CSV: " + e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: Archivo no encontrado");
        } catch (IOException e) {
            System.err.println("ERROR: No se ha podido leer el archivo");
        }
    }

    public void guardar() {
        GestorPersistencia gestorPersistencia = new GestorPersistencia();
        gestorPersistencia.guardarDatos(repo.listar(), FICHERO_DATOS);
    }

    public void exportarCatalogoAXML(String rutaArchivo) {
        try {
            ListaEventosWrapper wrapper = new ListaEventosWrapper();
            wrapper.setLista(new ArrayList<>(repo.listar()));

            JAXBContext context  = JAXBContext.newInstance(ListaEventosWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(wrapper, new File(rutaArchivo));
        } catch (JAXBException e) {
            System.out.println("Error al importar: " + e.getMessage());
        }
    }

    public void importarCatalogoDesdeXML(String ruta) {
        try {
            File archivo = new File(ruta);
            JAXBContext contexto = JAXBContext.newInstance(ListaEventosWrapper.class);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            ListaEventosWrapper wrapper = (ListaEventosWrapper) unmarshaller.unmarshal(archivo);
            ArrayList<Evento> listaImportada = wrapper.getLista();

            for (Evento e : listaImportada) {
                repo.guardar(e);
            }
            System.out.println("Se han importado " + listaImportada.size() + " eventos.");
        } catch (JAXBException e) {
            System.out.println("Error al importar: " + e.getMessage());
        }
    }



    /**
     * Genera informe financiero
     */
    public void generarInformeFinanciero() {
        Collection<Evento> eventos = mapaEventos.values();
        for (Evento e : mapaEventos.values()) {
            System.out.println("ID: " + e.getId());
            System.out.println("Evento: " + e.getNombre());
            System.out.printf(" - Coste Operativo: %.2f€%n", e.calcularCosteOperativo());
            System.out.printf(" - Precio Sugerido: %.2f€%n", e.calcularPrecioVentaRecomendado());
            System.out.println("-----------------------------------");
        }
    }
}