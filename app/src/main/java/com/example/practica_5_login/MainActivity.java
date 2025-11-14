package com.example.practica_5_login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText tCorreo;
    private EditText tContraseña;
    private Button bContinuar;
    private Switch sRecordar;
    private TextView tvMensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        tCorreo = findViewById(R.id.etCorreo);
        tContraseña = findViewById(R.id.etContraseña);
        bContinuar = findViewById(R.id.bContinuar);
        sRecordar = findViewById(R.id.sRecordar);
        tvMensaje = findViewById(R.id.tvMensaje);

        //Listener del botón Continuar
        bContinuar.setOnClickListener(v -> {

            String correo = tCorreo.getText().toString();
            String contraseña = tContraseña.getText().toString();
            boolean recordar = sRecordar.isChecked();

            //Cuando el campo del correo y la contraseña sean lo mismo que en equals
            if (correo.equals("correo@correo.com") && contraseña.equals("123")) {


                Intent intent1 = new Intent(MainActivity.this, SegundaPantalla.class);
                intent1.putExtra("correousuario", correo);

                startActivity(intent1);

                if (recordar) {
                    tvMensaje.setText("Usuario y contraseña correctos" + "\n" + "Almacenados para siguientes accesos");
                } else {
                    tvMensaje.setText("Usuario y contraseña correctos");
                }
                tvMensaje.setTextColor(Color.GREEN);

            } else {
                tvMensaje.setText("Usuario y/o contraseña incorrectos");
                tvMensaje.setTextColor(Color.RED);
            }
        });
    }

    // Añade este nuevo método onResume()
    @Override
    protected void onResume() {
        super.onResume();


        tContraseña.setText(""); //Limpiar el campo de la contraseña cuando volvamos a la primera pantalla
        tvMensaje.setText(""); //Para que no salga el mensaje al volver a la primera pantalla



        Intent intent = getIntent();
        String correousuario = intent.getStringExtra("correousuario");

        if (correousuario != null && !correousuario.isEmpty()) {
            tCorreo.setText(correousuario);
        } else {

            tCorreo.setText(""); //Limpiar el campo del correo al volver a la primera pantalla
        }
    }
}
