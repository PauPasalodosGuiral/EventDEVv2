package com.azahartech.eventdev.vista;

import javax.swing.*;
import javax.swing.tree.VariableHeightLayoutCache;
import java.awt.*;

public class VistaLogin extends JFrame {

    public VistaLogin() {
        this.setTitle("Acceso a EventDEV");
        this.setSize(400, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.initUI();

    }

    private void initUI() {
        Container lienzo = this.getContentPane();
        lienzo.setLayout(new BorderLayout(10, 10));
        JPanel pnlFormulario = new JPanel();
        pnlFormulario.setLayout(new GridLayout(2,2));
        pnlFormulario.setVisible(true);

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();
        JLabel lblPassword = new JLabel("Contraseña:");
        JPasswordField txtPassword = new JPasswordField();

        pnlFormulario.add(lblEmail);
        pnlFormulario.add(txtEmail);
        pnlFormulario.add(lblPassword);
        pnlFormulario.add(txtPassword);

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

        JButton btnLogin = new JButton("Iniciar Sesión");
        JButton btnRegistro = new JButton("Registrarse");
        pnlBotones.add(btnLogin);
        pnlBotones.add(btnRegistro);
        lienzo.add(pnlBotones, BorderLayout.SOUTH);

    }
}
