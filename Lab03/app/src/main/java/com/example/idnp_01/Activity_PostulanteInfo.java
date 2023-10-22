package com.example.idnp_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;
import java.util.ArrayList;

public class Activity_PostulanteInfo extends AppCompatActivity {
    private EditText dniEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postulante_info);

        dniEditText = findViewById(R.id.DniEdit);
        Button buscarButton = findViewById(R.id.buttonBuscar);
        final TextView textViewParrafo = findViewById(R.id.textViewParrafo);

        Intent intent = getIntent();
        ArrayList<Postulante> arrayPostulantes_recibido = (ArrayList<Postulante>) intent.getSerializableExtra("arrayPostulantes");


        buscarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dniEditText = findViewById(R.id.DniEdit);
                String dni = dniEditText.getText().toString();
                for (Postulante postulante : arrayPostulantes_recibido) {
                    if (postulante.getDni().equals(dni)) {

                        String textoLargo = "Nombre: " + postulante.getNombres() + "\n" +
                                "Apellidos: " + postulante.getApellidos() + "\n" +
                                "DNI: " + postulante.getDni() + "\n";
                        textViewParrafo.setText(textoLargo);
                        return;
                    }
                }

                textViewParrafo.setText("No se encontró ningún Postulante con el DNI: " + dni);
            }
        });
    }
}