package com.example.practica_5_login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button; // Importar Button
import android.widget.TextView;
import android.widget.Toast; // Importar Toast (opcional)

import androidx.appcompat.app.AppCompatActivity;

public class SegundaPantalla extends AppCompatActivity {

    private TextView etCorreoUsuario;
    private Button btnSegundaPantalla; // Referencia para el botón

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        etCorreoUsuario = findViewById(R.id.etCorreoUsuario);
        btnSegundaPantalla = findViewById(R.id.btnSegundaPantalla);

        // Recuperar el correo enviado desde MainActivity
        Intent intent = getIntent();
        String correo = intent.getStringExtra("correousuario");

        if(correo != null){
            etCorreoUsuario.setText(correo);
        } else {
            etCorreoUsuario.setText("No se recibió correo");
        }

        //Acción del botón Desconectar
        btnSegundaPantalla.setOnClickListener(v -> {

            finish(); //Cierra la actividad actual para regresar a la primera pantalla

            // Opcional: Puedes enviar el correo de vuelta a la MainActivity si quieres que se mantenga en el login
            /*
            Intent returnIntent = new Intent();
            returnIntent.putExtra("correousuario", correo);
            setResult(RESULT_OK, returnIntent);
            finish();
            */
        });
    }
}
