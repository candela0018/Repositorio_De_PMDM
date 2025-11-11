package com.example.practica_5_listas;

public class Videogames {

    private String title;
    private String image;

    private String precio;

    public Videogames(String title, String image, String precio) {
        this.title = title;
        this.image = image;
        this.precio = precio;
    }

    public static Videogames get(int position) {
        return null;
    }

    public String getTitle () {

        return title;
    }

    public String getImage() {

        return image;
    }

    public String getPrecio() {
        return precio;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public void setPrecio (String precio) {
        this.precio = precio;
    }
}
