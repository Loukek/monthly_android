package com.example.monthly_project;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    CheckBox mouseBox;
    CheckBox keyboardBox;
    CheckBox kameraBox;
    EditText nameInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(getApplicationContext());


        spinner1 = findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        ArrayList<Komputer> komputers = dbHelper.readKomputery();
        ArrayList<String> komputerNames = new ArrayList<>();
        ArrayList<Bitmap> komputerBitmaps = new ArrayList<>();

        for(Komputer pc : komputers){
            komputerNames.add(pc.getName());
            komputerBitmaps.add(pc.getBitmap());
        }
        MyAdapter myAdapter1 = new MyAdapter(getApplicationContext(), komputerBitmaps, komputerNames);
        spinner1.setAdapter(myAdapter1);


        spinner2 = findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(this);
        ArrayList<Myszka> myszkas = dbHelper.readMyszki();
        ArrayList<String> myszkiNames = new ArrayList<>();
        ArrayList<Bitmap> myszkiBitmaps = new ArrayList<>();

        for(Myszka mouse : myszkas){
            myszkiNames.add(mouse.getName());
            myszkiBitmaps.add(mouse.getBitmap());
        }

        MyAdapter myAdapter2 = new MyAdapter(getApplicationContext(), myszkiBitmaps, myszkiNames);
        spinner2.setAdapter(myAdapter2);


        spinner3 = findViewById(R.id.spinner3);
        spinner3.setOnItemSelectedListener(this);
        ArrayList<Klawiatura> klawiaturas = dbHelper.readKlawiatury();
        ArrayList<String> klawiaturyNames = new ArrayList<>();
        ArrayList<Bitmap> klawiaturyBitmaps = new ArrayList<>();

        for(Klawiatura keyboard : klawiaturas){
            klawiaturyNames.add(keyboard.getName());
            klawiaturyBitmaps.add(keyboard.getBitmap());
        }

        MyAdapter myAdapter3 = new MyAdapter(getApplicationContext(), klawiaturyBitmaps, klawiaturyNames);
        spinner3.setAdapter(myAdapter3);


        spinner4 = findViewById(R.id.spinner4);
        spinner4.setOnItemSelectedListener(this);
        ArrayList<Kamera> kameras = dbHelper.readKamery();
        ArrayList<String> kameryNames = new ArrayList<>();
        ArrayList<Bitmap> kameryBitmaps = new ArrayList<>();

        for(Kamera kam : kameras){
            kameryNames.add(kam.getName());
            kameryBitmaps.add(kam.getBitmap());
        }

        MyAdapter myAdapter4 = new MyAdapter(getApplicationContext(), kameryBitmaps, kameryNames);
        spinner4.setAdapter(myAdapter4);

        mouseBox = findViewById(R.id.myszki_title);
        keyboardBox = findViewById(R.id.klawiatury_title);
        kameraBox = findViewById(R.id.kamery_title);
        nameInput = findViewById(R.id.name_input);
        final int[] mouseBoxState = {0};
        final int[] keyboardBoxState = {0};
        final int[] kameraBoxState = {0};

        mouseBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mouseBoxState[0] == 0){
                    mouseBoxState[0] = 1;
                }else {
                    mouseBoxState[0] = 0;
                }
                Toast.makeText(getApplicationContext(), String.valueOf(mouseBoxState[0]), Toast.LENGTH_SHORT).show();
            }
        });

        keyboardBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (keyboardBoxState[0] == 0){
                    keyboardBoxState[0] = 1;
                }else {
                    keyboardBoxState[0] = 0;
                }
                Toast.makeText(getApplicationContext(), String.valueOf(keyboardBoxState[0]), Toast.LENGTH_SHORT).show();
            }
        });

        kameraBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kameraBoxState[0] == 0){
                    kameraBoxState[0] = 1;
                }else {
                    kameraBoxState[0] = 0;
                }
                Toast.makeText(getApplicationContext(), String.valueOf(kameraBoxState[0]), Toast.LENGTH_SHORT).show();
            }
        });

        Button orderButton = findViewById(R.id.order_button);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int state_pc = spinner1.getSelectedItemPosition() + 1;
                int state_mouse = spinner2.getSelectedItemPosition() + 1;
                int state_keyboard = spinner3.getSelectedItemPosition() + 1;
                int state_kamera = spinner4.getSelectedItemPosition() + 1;
                String name = (nameInput.getText()).toString();
                Double suma;

                if(mouseBoxState[0] == 0 && keyboardBoxState[0] == 0 && kameraBoxState[0] == 0){
                    suma = dbHelper.getCenaSuma(state_pc, 4, 4, 4);
                    state_mouse = 4;
                    state_keyboard = 4;
                    state_kamera = 4;
                }else if(mouseBoxState[0] == 1 && keyboardBoxState[0] == 0 && kameraBoxState[0] == 0){
                    suma = dbHelper.getCenaSuma(state_pc, state_mouse, 4, 4);
                    state_keyboard = 4;
                    state_kamera = 4;
                }else if(mouseBoxState[0] == 0 && keyboardBoxState[0] == 1 && kameraBoxState[0] == 0){
                    suma = dbHelper.getCenaSuma(state_pc, 4, state_keyboard, 4);
                    state_mouse = 4;
                    state_kamera = 4;
                }else if(mouseBoxState[0] == 0 && keyboardBoxState[0] == 0 && kameraBoxState[0] == 1){
                    suma = dbHelper.getCenaSuma(state_pc, state_mouse, 4, state_kamera);
                    state_keyboard = 4;
                }else if(mouseBoxState[0] == 1 && keyboardBoxState[0] == 1 && kameraBoxState[0] == 0){
                    suma = dbHelper.getCenaSuma(state_pc, state_mouse, state_keyboard, 4);
                    state_kamera = 4;
                }else if(mouseBoxState[0] == 0 && keyboardBoxState[0] == 1 && kameraBoxState[0] == 1){
                    suma = dbHelper.getCenaSuma(state_pc, 4, state_keyboard, state_kamera);
                    state_mouse = 4;
                }else{
                    suma = dbHelper.getCenaSuma(state_pc, state_mouse, state_keyboard, state_kamera);
                }

                dbHelper.insertOrder(state_pc, state_mouse, state_keyboard, state_kamera, suma, name);

                Toast.makeText(getApplicationContext(), "Pomyślnie złożono zamówienie.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.info_item:
                Intent intent1 = new Intent(MainActivity.this, Informacje.class);
                startActivity(intent1);
                return true;
            case R.id.orders_item:
                Intent intent2 = new Intent(MainActivity.this, Zamowienia.class);
                startActivity(intent2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}