package com.azahartech.eventdev.vista;

import com.azahartech.eventdev.modelo.Concierto;
import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.servicio.ServicioEvento;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class VistaDashboard extends JFrame {

    private JMenuItem cerrarSesionMenuItem;
    private JMenuItem salirMenuItem;
    private JButton salirButton;
    private JMenuItem nuevoEventoMenuItem;
    private JButton verDetallesButton;

    public VistaDashboard(String nombreUsuario) {
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

    DefaultTableModel eventosTableModel = new DefaultTableModel(columnas, 0){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    ServicioEvento servicioEvento = new ServicioEvento();
    for (int i = 0; i < 50; i++) {
        servicioEvento.registrarEvento(new Concierto(
                "CON" + i, LocalDate.now().plusDays(i), null, 100+i*10, null, null, 0, null
        ));
    }
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

    JTable eventosTable = new JTable(eventosTableModel);
    
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

        verDetallesButton.addActionListener(e -> {
            //
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

}


