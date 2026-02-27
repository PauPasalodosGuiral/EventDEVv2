package com.azahartech.eventdev.vista;

import javax.swing.*;
import javax.swing.tree.VariableHeightLayoutCache;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VistaLogin extends JFrame {
    private JTextField emailField;
    private JPasswordField contrasenyaField;
    private JButton loginButton;
    private JButton registroButton;
    private JButton salirButton;

    public VistaLogin() {
        this.setTitle("Acceso a EventDEV");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initUI();
        this.initListeners();

    }

    private void initUI() {
        Container lienzo = this.getContentPane();
        lienzo.setLayout(new BorderLayout(10, 10));
        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridLayout(2,2));
        pnlFormulario.setVisible(true);

        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPassword = new JLabel("Contraseña:");
        this.emailField = new JTextField();
        this.contrasenyaField = new JPasswordField();

        pnlFormulario.add(lblEmail);
        pnlFormulario.add(emailField);
        pnlFormulario.add(lblPassword);
        pnlFormulario.add(contrasenyaField);

        lienzo.add(pnlFormulario);
        //Titulo
        JLabel lblTitulo = new JLabel("Bienvenido a EventDEV");
        Font font = new Font("Arial", Font.BOLD, 18);
        lblTitulo.setFont(font);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lienzo.add(lblTitulo, BorderLayout.NORTH);

        //botonera
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER));

        this.loginButton = new JButton("Iniciar Sesión");
        this.registroButton = new JButton("Registrarse");
        this.salirButton = new JButton("Salir");

        pnlBotones.add(salirButton);
        pnlBotones.add(loginButton);
        pnlBotones.add(registroButton);
        lienzo.add(pnlBotones, BorderLayout.SOUTH);
    }

    private void initListeners() {
        salirButton.addActionListener(e -> {
            int confirmar = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que quieres cerrar la aplicación?",
                    "Confirmar salida",
                    JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        loginButton.addActionListener(e ->  {
            intentarLogin();
        });

        contrasenyaField.addActionListener(e -> intentarLogin());
        loginButton.addActionListener(e -> intentarLogin());


        registroButton.addActionListener(e -> {
                new VistaRegistro().setVisible(true);
            dispose();
        });

    }
    private  void intentarLogin() {
        String email = emailField.getText();
        String contransenya = new
                String(contrasenyaField.getPassword());
        if (email.equals("admin") && contransenya.equals("1234")) {
            /*
            JOptionPane.showMessageDialog(this,
                    "¡Bienvenido al sistema, Admin!",
                    "Acceso concedido",
                    JOptionPane.INFORMATION_MESSAGE);
                    */
            this.dispose();
            new VistaDashboard(email).setVisible(true);

        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
            contrasenyaField.setText("");
            contrasenyaField.requestFocus();
        }
    }

}
