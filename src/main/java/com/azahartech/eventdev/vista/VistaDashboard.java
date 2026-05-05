package com.azahartech.eventdev.vista;

import com.azahartech.eventdev.modelo.Concierto;
import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.servicio.ServicioEvento;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class VistaDashboard extends JFrame {

    private JMenuItem cerrarSesionMenuItem;
    private JMenuItem salirMenuItem;
    private JButton salirButton;
    private JMenuItem nuevoEventoMenuItem;
    private JMenuItem importarAXML;
    private JMenuItem exportarAXML;
    private JButton verDetallesButton;
    private JTable eventosTable;
    private static ServicioEvento servicioEvento;
    private DefaultTableModel eventosTableModel;

    public VistaDashboard(String nombreUsuario) {
        servicioEvento = new ServicioEvento();
        this.setTitle("Catalogo Eventos");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI(nombreUsuario);
        initListeners();
}

private void initUI(String nombreUsuario) {
        JPanel principalPanel = new JPanel(new BorderLayout());

        //lateral
        JPanel barraLateralPanel = new JPanel(new GridLayout(10, 1, 5, 5));
        barraLateralPanel.setBackground(Color.LIGHT_GRAY);

        JButton catalogoButton = new JButton("Catálogo");
        JButton entradasButton = new JButton("Mis Entradas");
        JButton perfilButton = new JButton("Perfil");
        this.salirButton = new JButton("Salir");
        barraLateralPanel.add(catalogoButton);
        barraLateralPanel.add(entradasButton);
        barraLateralPanel.add(perfilButton);
        barraLateralPanel.add(salirButton);


        principalPanel.add(barraLateralPanel, BorderLayout.WEST);

        //estado
        JPanel barraEstadoPanel = new JPanel( new FlowLayout(FlowLayout.LEFT));

        JLabel usuarioLabel = new JLabel("Usuario: " + nombreUsuario);
        barraEstadoPanel.setBackground(Color.LIGHT_GRAY);
        barraEstadoPanel.add(usuarioLabel);
        verDetallesButton = new JButton("Ver detalles");
        barraEstadoPanel.add(verDetallesButton);

        principalPanel.add(barraEstadoPanel, BorderLayout.SOUTH);

        principalPanel.setBackground(Color.WHITE);


        //central
    String[] columnas = {"ID", "Nombre", "Fecha", "Precio"};

    eventosTableModel = new DefaultTableModel(columnas, 0){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };


    for (int i = 0; i < 50; i++) {
        servicioEvento.registrarEvento(new Concierto(
                "CON" + i, LocalDate.now().plusDays(i), null, 100+i*10, null, null, 0, null
        ));
    }

    eventosTable = new JTable(eventosTableModel);
    
    JScrollPane tableScrollPane = new JScrollPane(eventosTable);
    tableScrollPane.getVerticalScrollBar().setUnitIncrement(20);
    SwingUtilities.invokeLater(() -> {
        tableScrollPane.getVerticalScrollBar().setValue(0);
    });

    principalPanel.add(tableScrollPane, BorderLayout.CENTER);

    /*
        JPanel pnlLista = new JPanel(new GridLayout(0, 1, 5,5));
        pnlLista.setBackground(Color.WHITE);
        pnlLista.setBorder(new EmptyBorder(10, 10, 10, 10));
    for (int i = 0; i < 20; i++) {
        pnlLista.add(new TarjetaEvento("Concierto " + i , "2026-10-10", "100"));
    }
        JScrollPane scrollPane = new JScrollPane(pnlLista);
    scrollPane.getVerticalScrollBar().setUnitIncrement(20);
    SwingUtilities.invokeLater(() -> {
        scrollPane.getVerticalScrollBar().setValue(0);
    });

        principalPanel.add(scrollPane, BorderLayout.CENTER);
        
        */

        JMenuBar principalMenuBar = new JMenuBar();
        JMenu archivoMenu = new JMenu("Archivo");
        cerrarSesionMenuItem = new JMenuItem("Cerrar Sesion");
        salirMenuItem = new JMenuItem("Salir");
        archivoMenu.add(cerrarSesionMenuItem);
        archivoMenu.add(salirMenuItem);

        principalMenuBar.add(archivoMenu);

        JMenu accionesMenu = new JMenu("Acciones");
        nuevoEventoMenuItem = new JMenuItem("Nuevo evento");
        accionesMenu.add(nuevoEventoMenuItem);
        principalMenuBar.add(accionesMenu);

        importarAXML = new JMenuItem("Importar a XML");
        accionesMenu.add(importarAXML);

        exportarAXML = new JMenuItem("Exportar a XML");
        accionesMenu.add(exportarAXML);


    principalPanel.add(principalMenuBar, BorderLayout.NORTH);




        this.add(principalPanel);
    }

    private void initListeners() {
        salirButton.addActionListener(e -> {
            cerrarSesion();
        });
        cerrarSesionMenuItem.addActionListener(e -> {
            cerrarSesion();
        });
        salirMenuItem.addActionListener(e -> {
            cerrarSesion();
        });

        nuevoEventoMenuItem.addActionListener(e -> {
            new NuevoEventoDialog(this, true, servicioEvento).setVisible(true);
            this.refrescarTabla();


        });

        verDetallesButton.addActionListener(e -> {
            int filaSeleccionada = eventosTable.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un evento.");
            } else {

                String nombreEvento = eventosTable.getValueAt(filaSeleccionada, 1).toString();
                String fechaEvento = eventosTable.getValueAt(filaSeleccionada, 2).toString();
                String precioEvento = eventosTable.getValueAt(filaSeleccionada, 3).toString();

                JOptionPane.showMessageDialog(this,
                                "Nombre: " + nombreEvento + "\n" +
                                "Fecha: " + fechaEvento + "\n" +
                                "Precio: " + precioEvento,
                        "Detalle del evento", JOptionPane.INFORMATION_MESSAGE
                );
            }
        });

        importarAXML.addActionListener( e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Seleccionar archivo XML para importar");
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos XML (*.xml)", "xml");
            fileChooser.setFileFilter(filtro);
            fileChooser.setAcceptAllFileFilterUsed(false);

            int resultado = fileChooser.showOpenDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                try {
                    servicioEvento.importarCatalogoDesdeXML(archivoSeleccionado.getAbsolutePath());

                    refrescarTabla();
                    JOptionPane.showMessageDialog(this, "Catálogo importado correctamente.", "Importación exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al importar:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exportarAXML.addActionListener( e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar catálogo como XML");
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos XML (*.xml)", "xml");
            fileChooser.setFileFilter(filtro);
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setSelectedFile(new File("catalogo.xml"));

            int resultado = fileChooser.showSaveDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = fileChooser.getSelectedFile();
                String ruta = archivo.getAbsolutePath();
                if (!ruta.toLowerCase().endsWith(".xml")) ruta += ".xml";
                try {
                    servicioEvento.exportarCatalogoAXML(ruta);
                    JOptionPane.showMessageDialog(this, "Catálogo exportado correctamente.", "Exportación exitosa", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error al exportar:\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }



    private void cerrarSesion() {
            int confirmar = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que quieres salir de la sesion",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                dispose();
                new VistaLogin().setVisible(true);
            }
    }

    private void refrescarTabla() {
        eventosTableModel.setRowCount(0);
        List<Evento> listaEventos = servicioEvento.listarTodosLosEventos();
        for (Evento evento : listaEventos) {
            Object[] fila = {
                    evento.getId(),
                    evento.getNombre(),
                    evento.getFecha(),
                    evento.getPrecio()
            };
            eventosTableModel.addRow(fila);
        }


    }
}


