package com.example.monthly_project;

public class ZamowienieModel {
    private int id;
    private String date;
    private int komputer_id;
    private int myszka_id;
    private int klawiatura_id;
    private int kamera_id;
    private double cena_suma;
    private String name;

    public int getId(){
        return id;
    }

    public ZamowienieModel(int id, String date, int komputer_id, int myszka_id, int klawiatura_id, int kamera_id, double cena_suma, String name){
        this.id = id;
        this.date = date;
        this.komputer_id = komputer_id;
        this.myszka_id = myszka_id;
        this.klawiatura_id = klawiatura_id;
        this.kamera_id = kamera_id;
        this.cena_suma = cena_suma;
        this.name = name;
    }

    public ZamowienieModel(){};

    public String getDate() {
        return date;
    }

    public int getKomputer_id() {
        return komputer_id;
    }

    public int getMyszka_id() {
        return myszka_id;
    }

    public int getKlawiatura_id() {
        return klawiatura_id;
    }

    public int getKamera_id() {
        return kamera_id;
    }

    public double getCena_suma() {
        return cena_suma;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ZamowienieModel{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", komputer_id=" + komputer_id +
                ", myszka_id=" + myszka_id +
                ", klawiatura_id=" + klawiatura_id +
                ", kamera_id=" + kamera_id +
                ", cena_suma=" + cena_suma +
                ", name='" + name + '\'' +
                '}';
    }
}
