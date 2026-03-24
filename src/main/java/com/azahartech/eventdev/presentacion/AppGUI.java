package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.vista.VistaLogin;
import com.azahartech.eventdev.vista.VistaRegistro;

import javax.swing.*;

public class AppGUI {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName()
                );
            } catch (Exception e) {
                e.printStackTrace();
            }

            new VistaLogin().setVisible(true);
        });
    }
}
