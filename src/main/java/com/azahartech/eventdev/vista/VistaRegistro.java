package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaRegistro extends JFrame{

    private JTextField nombreField;
    private JTextField emailField;
    private JPasswordField contrasenyaField;
    private JPasswordField repetirContasenyaField;
    private JTextField edadField;
    private JButton loginButton;
    private JButton registroButton;

    public VistaRegistro(){
        this.setTitle("Acceso a EventDEV");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane();
        initUI();
        initListeners();
    }

    private void initUI() {
        Container lienzo = this.getContentPane();
        lienzo.setLayout(new BorderLayout(10, 10));

        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridLayout(5,2));
        pnlFormulario.setVisible(true);

        this.nombreField = new JTextField();
        this.emailField = new JTextField();
        this.contrasenyaField = new JPasswordField();
        this.repetirContasenyaField = new JPasswordField();
        this.edadField = new JTextField();

        JLabel lblNombre = new JLabel("Nombre Completo:");
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPassword = new JLabel("Contraseña:");
        JLabel lblPasswordRepetir = new JLabel("Repetir Contraseña:");
        JLabel lblEdad = new JLabel("Edad:");

        pnlFormulario.add(lblNombre);
        pnlFormulario.add(nombreField);
        pnlFormulario.add(lblEmail);
        pnlFormulario.add(emailField);
        pnlFormulario.add(lblPassword);
        pnlFormulario.add(contrasenyaField);
        pnlFormulario.add(lblPasswordRepetir);
        pnlFormulario.add(repetirContasenyaField );
        pnlFormulario.add(lblEdad);
        pnlFormulario.add(edadField);

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

        JButton btnLogin = new JButton("Guardar");
        JButton btnRegistro = new JButton("Cancelar");
        pnlBotones.add(btnLogin);
        pnlBotones.add(btnRegistro);
        lienzo.add(pnlBotones, BorderLayout.SOUTH);
    }
    private void initListeners(){
        registroButton.addActionListener(e ->  {
            //seguir malañana
        });
    }



}
