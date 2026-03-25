package com.azahartech.eventdev.util;

import com.azahartech.eventdev.modelo.Niveles;

import java.io.*;
import java.time.LocalDateTime;

public class UtilidadLog {
    private static final String RUTA_LOG = "datos/auditoria.log";

    private static void asegurarDirectorio() {
        File archivo = new File(RUTA_LOG);
        File directorio = archivo.getParentFile();

        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs();
        }
    }

    public static void registrar(String mensaje) {
        asegurarDirectorio();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_LOG, true))) {

            LocalDateTime ahora = LocalDateTime.now();
            String fecha = ahora.toString().substring(0, 10);
            String hora = ahora.toString().substring(11, 19);
            writer.write("[" + fecha + " " + hora + "] " + mensaje.toUpperCase() + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void registrar(Niveles nivel, String mensaje) {
        asegurarDirectorio();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_LOG, true))) {

            LocalDateTime ahora = LocalDateTime.now();
            String fecha = ahora.toString().substring(0, 10);
            String hora = ahora.toString().substring(11, 19);

            String niv;
            switch (nivel) {
                case INFO -> {
                    niv = "[INFO] ";
                    break;
                }
                case WARN -> {
                    niv = "[WARN] ";
                    break;
                }
                case ERROR -> {
                    niv = "[ERROR] ";
                    break;
                }
                case null, default -> {
                    niv = "[] ";
                    break;
                }
            }

            writer.write("[" + fecha + " " + hora + "] " + niv + mensaje.toUpperCase() + "\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



