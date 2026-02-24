package com.azahartech.eventdev.vista;

import javax.swing.*;
import java.awt.*;


public class TarjetaEvento extends JPanel {

    public TarjetaEvento(String titulo, String fecha, String precio) {
        setLayout(new BorderLayout(5, 5));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JTextArea areaTextArea = new JTextArea("Descripcion: " +
                                                "\nFecha: " + fecha);
        areaTextArea.setBackground(Color.WHITE);
        this.add(areaTextArea, BorderLayout.CENTER);

        JButton comprarButton =new JButton("Comprar - " + precio);

        this.add(comprarButton, BorderLayout.SOUTH);

        JLabel tituloLabel = new JLabel(titulo);
        Font font = new Font("Arial", Font.BOLD, 18);
        tituloLabel.setFont(font);
        tituloLabel.setBackground(Color.WHITE);
        this.add(tituloLabel, BorderLayout.NORTH);





    }
}
