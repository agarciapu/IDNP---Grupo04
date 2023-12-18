package com.example.idnp_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Activity_PostulanteRegistro extends AppCompatActivity {
    private ArrayList<Postulante> arrayPostulantes = new ArrayList<>();
    private EditText dniEditText;
    private EditText apellidosEditText;
    private EditText nombresEditText;
    private EditText fechaNacimientoEditText;
    private EditText colegioProcedenciaEditText;
    private EditText carreraPostulaEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_registro);
        ImageButton guardarButton = findViewById(R.id.buttonGuardar);

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Click Guardar");
                dniEditText = findViewById(R.id.DniEdit);
                String dni = dniEditText.getText().toString();

                apellidosEditText = findViewById(R.id.ApellidosEdit);
                String apellidos = apellidosEditText.getText().toString();

                nombresEditText = findViewById(R.id.NombresEdit);
                String nombres = nombresEditText.getText().toString();

                fechaNacimientoEditText = findViewById(R.id.editTextFecha);
                String fechaNacimiento = fechaNacimientoEditText.getText().toString();

                colegioProcedenciaEditText = findViewById(R.id.ColegioProcedenciaEdit);
                String colegioProcedencia = colegioProcedenciaEditText.getText().toString();

                carreraPostulaEditText = findViewById(R.id.CarreraPostulaEdit);
                String escuelaPostula = carreraPostulaEditText.getText().toString();

                dniEditText.setText("");
                apellidosEditText.setText("");
                nombresEditText.setText("");
                fechaNacimientoEditText.setText("");
                colegioProcedenciaEditText.setText("");
                carreraPostulaEditText.setText("");

                // Guardar en el "app-specific storage"
                String datos = dni + "," + apellidos + "," + nombres + "," + fechaNacimiento + "," + colegioProcedencia + "," + escuelaPostula + "\n";
                Helper.guardarRegistro(Activity_PostulanteRegistro.this, "registro_postulante2.txt", datos);

                String datosGuardados = Helper.leerRegistro(Activity_PostulanteRegistro.this, "registro_postulante2.txt");
                // Guardar en el "app-specific storage"
               // guardarDatosEnAlmacenamientoInterno(dni, apellidos, nombres, fechaNacimiento, colegioProcedencia, escuelaPostula);

                // Enviar datos a través de Intent
                Intent intent = new Intent(Activity_PostulanteRegistro.this, Activity_Menu.class);
                Postulante nuevoPostulante = new Postulante(dni, apellidos, nombres, fechaNacimiento, colegioProcedencia, escuelaPostula);


                intent.putExtra("postulante", nuevoPostulante);

                startActivity(intent);
            }
        });


    }
    private void guardarDatosEnAlmacenamientoInterno(String dni, String apellidos, String nombres, String fechaNacimiento, String colegioProcedencia, String escuelaPostula) {
        try {

            FileOutputStream fileOutputStream = openFileOutput("datos_postulante.txt", Context.MODE_APPEND);

            // Construir una cadena con los datos del postulante
            String datos = dni + "," + apellidos + "," + nombres + "," + fechaNacimiento + "," + colegioProcedencia + "," + escuelaPostula + "\n";

            // Escribir los datos en el archivo
            fileOutputStream.write(datos.getBytes());

            // Cerrar el flujo de salida
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}