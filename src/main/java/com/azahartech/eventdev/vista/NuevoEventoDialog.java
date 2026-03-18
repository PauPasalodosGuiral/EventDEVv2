package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class NuevoEventoDialog extends JDialog {

    private JTextField campoNombre;
    private JTextField campoFecha;
    private JTextField campoPrecio;

    private JButton btnGuardar;
    private JButton btnCancelar;

    public NuevoEventoDialog(JFrame padre, boolean modal) {
        super(padre, "Nuevo evento", modal);
        setLocationRelativeTo(padre);
        setSize(480, 240);
        initUI();
        initListeners();
    }

    private void initUI() {

        JPanel panelPrincipal = new JPanel(new GridLayout(4, 2, 10, 10));

        panelPrincipal.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panelPrincipal.add(campoNombre);

        panelPrincipal.add(new JLabel("Fecha (YYYY-MM-DD):"));
        campoFecha = new JTextField();
        panelPrincipal.add(campoFecha);

        panelPrincipal.add(new JLabel("Precio:"));
        campoPrecio = new JTextField();
        panelPrincipal.add(campoPrecio);


        panelPrincipal.add(new JLabel());
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        btnGuardar  = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        panelPrincipal.add(panelBotones);

        setContentPane(panelPrincipal);
    }

    private void initListeners() {
        btnCancelar.addActionListener(e ->
                this.dispose()
        );

        btnGuardar.addActionListener(e -> {

        });
    }


}