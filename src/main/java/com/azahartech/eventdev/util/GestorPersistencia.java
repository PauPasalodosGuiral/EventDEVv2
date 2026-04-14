package com.azahartech.eventdev.util;

import java.io.*;
import java.util.ArrayList;
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

    public <T> List<T> cargarDatos(String rutaArchivo) {
        File archivo = new File(rutaArchivo);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (FileInputStream fis = new FileInputStream(archivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            Object objetoLeido = ois.readObject();
            return (List<T>) objetoLeido;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
