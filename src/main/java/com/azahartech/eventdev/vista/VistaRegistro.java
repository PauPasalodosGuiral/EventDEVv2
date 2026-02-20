package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;

public class VistaRegistro extends JFrame{
    public VistaRegistro(){
        this.setTitle("Acceso a EventDEV");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane();
        initUI();
    }

    private void initUI() {
        Container lienzo = this.getContentPane();
        lienzo.setLayout(new BorderLayout(10, 10));

        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridLayout(5,2));
        pnlFormulario.setVisible(true);

        JLabel lblNombre = new JLabel("Nombre Completo:");
        JTextField txtNombre = new JTextField();
        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword = new JPasswordField();
        JLabel lblPasswordRepetir = new JLabel("Repetir Contraseña:");
        JPasswordField txtPasswordRepetir = new JPasswordField();
        JLabel lblEdad = new JLabel("Edad:");
        JTextField txtEdad = new JTextField();

        pnlFormulario.add(lblNombre);
        pnlFormulario.add(txtNombre);
        pnlFormulario.add(lblEmail);
        pnlFormulario.add(txtEmail);
        pnlFormulario.add(lblPassword);
        pnlFormulario.add(txtPassword);
        pnlFormulario.add(lblPasswordRepetir);
        pnlFormulario.add(txtPasswordRepetir);
        pnlFormulario.add(lblEdad);
        pnlFormulario.add(txtEdad);

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


}
