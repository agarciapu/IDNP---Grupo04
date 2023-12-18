package com.example.idnp_01;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static void guardarRegistro(Context context, String filename, String data) {
        try (FileOutputStream fileOutputStream = context.openFileOutput(filename, Context.MODE_APPEND)) {
            fileOutputStream.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String leerRegistro(Context context, String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fileInputStream = context.openFileInput(filename);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
    public static List<Postulante> obtenerRegistros(Context context, String filename) {
        List<Postulante> registros = new ArrayList<>();
        try (FileInputStream fileInputStream = context.openFileInput(filename);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Dividir la línea en partes y construir un objeto Postulante
                String[] partes = line.split(",");
                Postulante postulante = new Postulante(
                        partes[0],  // DNI
                        partes[1],  // Apellidos
                        partes[2],  // Nombres
                        partes[3],  // Fecha de nacimiento
                        partes[4],  // Colegio de procedencia
                        partes[5]   // Carrera
                );
                registros.add(postulante);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return registros;
    }
}
