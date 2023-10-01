package com.example.idnp_01;
import java.text.BreakIterator;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private ArrayList<Postulante> arrayPostulantes = new ArrayList<>();
    private EditText apellidoPaternoEditText;
    private EditText apellidoMaternoEditText;
    private EditText nombresEditText;
    private EditText fechaNacimientoEditText;
    private EditText colegioProcedenciaEditText;
    private EditText carreraPostulaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button guardarButton = findViewById(R.id.buttonGuardar);

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 System.out.println("Click Guardar");
                apellidoPaternoEditText = findViewById(R.id.ApellidoPaternoEdit);
                String apellidoPaterno = apellidoPaternoEditText.getText().toString();

                apellidoMaternoEditText = findViewById(R.id.ApellidoMaternoEdit);
                String apellidoMaterno = apellidoMaternoEditText.getText().toString();

                nombresEditText = findViewById(R.id.NombresEdit);
                String nombres = nombresEditText.getText().toString();

                fechaNacimientoEditText = findViewById(R.id.editTextFecha);
                String fechaNacimiento = fechaNacimientoEditText.getText().toString();

                colegioProcedenciaEditText = findViewById(R.id.ColegioProcedenciaEdit);
                String colegioProcedencia = colegioProcedenciaEditText.getText().toString();

                carreraPostulaEditText = findViewById(R.id.CarreraPostulaEdit);
                String escuelaPostula = carreraPostulaEditText.getText().toString();



                Postulante nuevoPostulante = new Postulante(apellidoPaterno, apellidoMaterno, nombres, fechaNacimiento, colegioProcedencia, escuelaPostula);


                arrayPostulantes.add(nuevoPostulante);
                Log.d("Postulante", "Apellido Paterno: " + apellidoPaterno);
                Log.d("Postulante", "Apellido Materno: " + apellidoMaterno);
                Log.d("Postulante", "Nombres: " + nombres);
                Log.d("Postulante", "Fecha de Nacimiento: " + fechaNacimiento);
                Log.d("Postulante", "Colegio de Procedencia: " + colegioProcedencia);
                Log.d("Postulante", "Carrera a la que Postula: " + escuelaPostula);

                apellidoPaternoEditText.setText("");
                apellidoMaternoEditText.setText("");
                nombresEditText.setText("");
                fechaNacimientoEditText.setText("");
                colegioProcedenciaEditText.setText("");
                carreraPostulaEditText.setText("");
            }
        });

        Button listarButton = findViewById(R.id.buttonListar);

        listarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i=0; i<arrayPostulantes.size(); i++){
                    Postulante postulante = arrayPostulantes.get(i);
                    String apellidoPaterno = postulante.getApellidoPaterno();
                    String apellidoMaterno = postulante.getApellidoMaterno();
                    String nombres = postulante.getNombres();
                    String fechaNacimiento = postulante.getFechaNacimiento();
                    String colegioProcedencia = postulante.getColegioProcedencia();
                    String carrera = postulante.getCarrera();

                    Log.d("Postulante", "*********************************");
                    Log.d("Postulante", "Apellido Paterno: " + apellidoPaterno);
                    Log.d("Postulante", "Apellido Materno: " + apellidoMaterno);
                    Log.d("Postulante", "Nombres: " + nombres);
                    Log.d("Postulante", "Fecha de Nacimiento: " + fechaNacimiento);
                    Log.d("Postulante", "Colegio de Procedencia: " + colegioProcedencia);
                    Log.d("Postulante", "Carrera a la que Postula: " + carrera);
                }


            }});
    }
}