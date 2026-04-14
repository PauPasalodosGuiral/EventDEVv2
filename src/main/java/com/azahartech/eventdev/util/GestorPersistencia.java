package com.azahartech.eventdev.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class GestorPersistencia {
    public <T> void guardarDatos(List<T> datos, String rutaArchivo) {

        File archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            File backup = new File(rutaArchivo + ".bak");
            if (backup.exists()) backup.delete();
            archivo.renameTo(backup);
        }

        try (FileOutputStream fos = new FileOutputStream(archivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(datos);
            System.out.println("Datos guardados en " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error al guardar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
