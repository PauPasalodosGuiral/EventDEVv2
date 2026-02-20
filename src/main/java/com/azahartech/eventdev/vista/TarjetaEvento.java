package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;


public class TarjetaEvento extends JPanel {

    public TarjetaEvento(String titulo, String fecha, String precio) {
        setLayout(new BorderLayout());

        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JTextArea areaTextArea = new JTextArea("Descripcion: " +
                                                "\nFecha: " + fecha);
        this.add(areaTextArea, BorderLayout.CENTER);

        JButton comprarButton =new JButton("Comprar - " + precio);
        this.add(comprarButton, BorderLayout.SOUTH);

        JLabel tituloLabel = new JLabel(titulo);
        //tituloLabel.setFont(Font.BOLD,);





    }
}
