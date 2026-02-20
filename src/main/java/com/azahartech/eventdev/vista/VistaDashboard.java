package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaDashboard extends JFrame {
    public VistaDashboard() {
        this.setTitle("Catalogo Eventos");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
}

private void initUI() {

        JPanel principalPanel = new JPanel(new BorderLayout());

        //lateral
        JPanel barraLateralPanel = new JPanel(new GridLayout(10, 1));
        barraLateralPanel.setBackground(Color.GRAY);

        JButton catalogoButton = new JButton("Catálogo");
        JButton entradasButton = new JButton("Mis Entradas");
        JButton perfilButton = new JButton("Perfil");
        JButton salirButton = new JButton("Salir");
        barraLateralPanel.add(catalogoButton);
        barraLateralPanel.add(entradasButton);
        barraLateralPanel.add(perfilButton);
        barraLateralPanel.add(salirButton);

        principalPanel.add(barraLateralPanel, BorderLayout.WEST);

        //estado
        JPanel barraEstadoPanel = new JPanel( new FlowLayout(FlowLayout.LEFT));

        JLabel usuarioLabel = new JLabel("Usuario: Invitado");
        barraEstadoPanel.add(usuarioLabel);

        principalPanel.add(barraEstadoPanel, BorderLayout.SOUTH);

        //central
        JPanel zonaCentralPanel = new JPanel();
        zonaCentralPanel.setBackground(Color.white);

        zonaCentralPanel = new TarjetaEvento("Concierto", "2026-10-10","100");
        principalPanel.add(zonaCentralPanel, BorderLayout.CENTER);

        this.add(principalPanel);
    }
}

