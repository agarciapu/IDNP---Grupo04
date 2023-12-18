package com.example.idnp_01;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Obtener_txt extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.obtener_txt);

        // Obtener la información del Intent
        String contenido = getIntent().getStringExtra("contenidoArchivo");

        // Separar las líneas del contenido
        String[] lineas = contenido.split("\n");

        // Crear una lista para almacenar las líneas
        ArrayList<String> listaLineas = new ArrayList<>();
        for (String linea : lineas) {
            listaLineas.add(linea);
        }

        // Configurar el RecyclerView
        RecyclerView recyclerView = findViewById(R.id.txtTextView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listaLineas); // Ajusta el adaptador según tus necesidades
        recyclerView.setAdapter(adapter);
    }

}
