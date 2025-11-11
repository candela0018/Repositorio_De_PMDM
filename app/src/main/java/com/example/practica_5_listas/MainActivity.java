package com.example.practica_5_listas;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView listaEjemplo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Ligo los elementos gráficos
        listaEjemplo = findViewById(R.id.listaEjemplo);

        //Creamos 20 elementos de la lista
        ArrayList<Videogames> elementos = new ArrayList<>();

        for (int i = 0; i < 20; i++) {

            Videogames[] videogames = new Videogames[1];
            videogames[0] = new Videogames("Videjuego1", "foto_videojuego1", "10$");
            AdaptadorVideojuegos adaptadorVideojuegos = new AdaptadorVideojuegos(videogames);

        }

        //Con el tamaño del recyclerView no cambiará
        listaEjemplo.setHasFixedSize(true);

        //Ceo un layoutManager para el recyclerView
        LinearLayoutManager llm = new LinearLayoutManager(this);
        //Creo un layoutManager llm = new GridLayoutManager(this, 3);
        listaEjemplo.setLayoutManager(llm);

        //Creamos el adaptador
        AdaptadorVideojuegos adaptadorVideojuegos = new AdaptadorVideojuegos(this, elementos);
        //Indicamos que el adaptador de la lista en el que hemos creado
        listaEjemplo.setAdapter(adaptadorVideojuegos);
        adaptadorVideojuegos.refrescar();


    }
}