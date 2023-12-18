package com.example.idnp_01;
import java.text.BreakIterator;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText usuarioEditText;
    private EditText contraseniaEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton ingresarButton = findViewById(R.id.buttonIngresar);
        ingresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usuarioEditText = findViewById(R.id.idUsuario);
                String usuario = usuarioEditText.getText().toString();

                contraseniaEditText = findViewById(R.id.idContrasenia);
                String contrasenia = contraseniaEditText.getText().toString();

                if(usuario.equals("73321272") && contrasenia.equals("1234")){
                    Intent intent = new Intent(MainActivity.this, Activity_Menu.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }

            }});

    }
}


