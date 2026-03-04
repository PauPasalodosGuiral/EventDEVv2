package com.azahartech.eventdev.vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class VistaDashboard extends JFrame {

    private JButton salirButton;

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

        principalPanel.add(barraEstadoPanel, BorderLayout.SOUTH);

        principalPanel.setBackground(Color.WHITE);


        //central
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
        this.add(principalPanel);

    }

    private void initListeners() {
        salirButton.addActionListener(e -> {
            int confirmar = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que quieres salir de la sesion",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                dispose();
                new VistaLogin().setVisible(true);
            }
        });
    }
}


