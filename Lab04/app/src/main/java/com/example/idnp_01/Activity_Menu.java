package com.example.idnp_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.idnp_01.Postulante;

import java.util.ArrayList;

public class Activity_Menu extends AppCompatActivity {
    private ArrayList<Postulante> arrayPostulantes = new ArrayList<>();
    private Postulante postulante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        Intent intent = getIntent();
        postulante = (Postulante) intent.getSerializableExtra("postulante");
        if (postulante != null) {
            arrayPostulantes.add(postulante);
        }

        Button infoButton = findViewById(R.id.buttonInfoPostulante);
        Button nuevoButton = findViewById(R.id.buttonNuevoPostulante);

        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, Activity_PostulanteInfo.class);
                intent.putExtra("arrayPostulantes", arrayPostulantes);
                startActivity(intent);
            }
        });

        nuevoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Menu.this, Activity_PostulanteRegistro.class);
                startActivity(intent);
            }
        });
    }
}
