package com.azahartech.eventdev.vista;

import com.azahartech.eventdev.modelo.Concierto;
import com.azahartech.eventdev.modelo.Evento;
import com.azahartech.eventdev.modelo.TipoEvento;
import com.azahartech.eventdev.servicio.ServicioEvento;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class NuevoEventoDialog extends JDialog {

    private JTextField campoNombre;
    private JTextField campoFecha;
    private JTextField campoPrecio;

    private JButton btnGuardar;
    private JButton btnCancelar;
    private ServicioEvento servicioEvento;

    public NuevoEventoDialog(JFrame padre, boolean modal, ServicioEvento servicioEvento) {
        super(padre, "Nuevo evento", modal);
        this.servicioEvento = servicioEvento;
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
        campoFecha.setToolTipText("Formato: AAAA-MM-DD");
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
            guardarTextoNuevoEvento();
        });

        campoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent e) {
                try {
                    Double.parseDouble(campoPrecio.getText());
                    campoPrecio.setBackground(Color.WHITE);
                } catch (Exception ex) {
                    campoPrecio.setBackground(Color.PINK);
                }
            }
        });

    }

    private void guardarTextoNuevoEvento() {
        try {
            String nombre = campoNombre.getText();
            LocalDate fecha = LocalDate.parse(campoFecha.getText());
            double precio = Double.parseDouble(campoPrecio.getText());

            this.servicioEvento.registrarEvento(
                    new Concierto(nombre, fecha, null, precio, TipoEvento.CONCIERTO, null, 0, null));

            dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Datos inválidos. Revisa la fecha y el precio.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }



}