package com.example.monthly_project;

import android.graphics.Bitmap;

public class Komputer {
    private int id;
    private String name;
    private String description;
    private double cena;
    private String base64zdjecie;
    private Bitmap bitmap;

    public int getId(){
        return id;
    }

    public Komputer(int id, String name, String description, double cena, String base64zdjecie, Bitmap bitmap){
        this.id = id;
        this.name = name;
        this.description = description;
        this.cena = cena;
        this.base64zdjecie = base64zdjecie;
        this.bitmap = bitmap;
    }

    public String getBase64zdjecie() {
        return base64zdjecie;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Komputer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cena=" + cena +
                '}';
    }
}
