package com.example.practica_5_listas;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorVideojuegos extends RecyclerView.Adapter<AdaptadorVideojuegos.VideojuegosViewHolder> {



    public static class VideojuegosViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageVideogames;
        TextView tEjemplo1, tEjemplo2;

        private Context context;

        VideojuegosViewHolder(View itemView, Context context) {
            super(itemView);

            tEjemplo1 = itemView.findViewById(R.id.tEjemplo1);
            tEjemplo2 = itemView.findViewById(R.id.tEjemplo2);
            imageVideogames = itemView.findViewById(R.id.imageView);
        }

        public void BindVideojuegos (Videogames videogames) {

            tEjemplo1.setText(videogames.getTitle());
            tEjemplo2.setText(videogames.getTitle());
            imageVideogames.setImageResource(
                    context.getResources()
                            .getIdentifier(videogames.getImage(),
                                    "drawable",
                                    ".com.example.listas"));



        }
    }



    private ArrayList<Videogames> elementos;
    private Context context;



    public AdaptadorVideojuegos(Context context, ArrayList<Videogames> elementos) {
        this.context = context;
        this.elementos = elementos;
    }

    public void add(ArrayList<Videogames> datos) {
        elementos.clear();
        elementos.addAll(datos);
    }

    public void refrescar() {
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideojuegosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.videogames, parent, false);
        return new VideojuegosViewHolder(v, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull VideojuegosViewHolder holder, int position) {
        holder.BindVideojuegos(this.videogames[position]);


        String image = Videogames.get(position).getImage();
        Uri uri = Uri.parse("android.resource://" + context.getPackageName() + "/drawable/" + image);
        holder.imageVideogames.setImageURI(uri);

    }



    @Override
    public int getItemCount() {
        return elementos.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    private Videogames[] videogames;
    public  AdaptadorVideojuegos(Videogames[] videogames) {

        this.videogames = videogames;


    }
}
