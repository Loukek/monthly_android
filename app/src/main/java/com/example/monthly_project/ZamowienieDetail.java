package com.example.monthly_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ZamowienieDetail extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamowienie_detail);

        DetailAdapter detailAdapter;
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        Intent intent = this.getIntent();
        ArrayList<ZamowienieModel> arrayList = new ArrayList();
        ArrayList<Komputer> arrayListPC = new ArrayList<>();
        ArrayList<Myszka> arrayListMouse = new ArrayList<>();
        ArrayList<Klawiatura> arrayListKlawiatura = new ArrayList<>();
        ArrayList<Kamera> arrayListKamera = new ArrayList<>();
        ListView listView = findViewById(R.id.detail_listView);
        TextView data = findViewById(R.id.data_paster);
        TextView imie = findViewById(R.id.name_paster);
        int id;
        int list_size = 4;

        if(intent != null){
            String id_z = intent.getStringExtra("id");
            id = Integer.parseInt(id_z);

            ZamowienieModel zamowienieModel = DBHelper.readZamowienieDetail(id, getApplicationContext());
            arrayListPC = dbHelper.readKomputery();
            arrayListMouse = dbHelper.readMyszki();
            arrayListKlawiatura = dbHelper.readKlawiatury();
            arrayListKamera = dbHelper.readKamery();

            if(zamowienieModel.getMyszka_id() == 4){
                list_size -= 1;
            }else{
                list_size = list_size;
            }

            if(zamowienieModel.getKlawiatura_id() == 4){
                list_size -= 1;
            }else{
                list_size = list_size;
            }

            if(zamowienieModel.getKamera_id() == 4){
                list_size =- 1;
            }else{
                list_size = list_size;
            }

            data.setText(zamowienieModel.getDate());
            imie.setText(zamowienieModel.getName());

            detailAdapter = new DetailAdapter(this, list_size, zamowienieModel, arrayListPC, arrayListMouse, arrayListKlawiatura, arrayListKamera);
            listView.setAdapter(detailAdapter);
            detailAdapter.notifyDataSetChanged();
        }




    }

}