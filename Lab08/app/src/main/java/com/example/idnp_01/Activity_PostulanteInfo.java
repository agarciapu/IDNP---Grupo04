package com.example.idnp_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
public class Activity_PostulanteInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        ImageButton buscarButton = findViewById(R.id.buttonBuscar);

        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Nombre del archivo que deseas leer (ajusta según tus necesidades)
                String nombreArchivo = "registro_postulante2.txt";

                // Intentar leer el contenido del archivo
                String contenido = leerContenidoArchivo(nombreArchivo);

                if (contenido != null) {
                    // Enviar la información a la otra actividad
                    Intent intent = new Intent(Activity_PostulanteInfo.this, Obtener_txt.class);
                    intent.putExtra("contenidoArchivo", contenido);
                    startActivity(intent);
                } else {
                    // El archivo no existe o hubo un error al leerlo
                    Toast.makeText(Activity_PostulanteInfo.this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private String leerContenidoArchivo(String nombreArchivo) {
        try {
            FileInputStream fis = openFileInput(nombreArchivo);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String linea;

            while ((linea = br.readLine()) != null) {
                sb.append(linea).append("\n");
            }

            br.close();
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}