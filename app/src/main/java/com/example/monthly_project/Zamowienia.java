package com.example.monthly_project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Zamowienia extends AppCompatActivity {

    ListView l1;
    OrderAdapter orderAdapter;
    ArrayList<ZamowienieModel> arrayList;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zamowienia);

        dbHelper = new DBHelper(getApplicationContext());

        l1 = findViewById(R.id.orderListView);
        arrayList = new ArrayList<>();
        loadDataInListView();
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Zamowienia.this, ZamowienieDetail.class);
                intent.putExtra("id", String.valueOf(position+1));

                startActivity(intent);
            }
        });


    }

    private void loadDataInListView(){
        arrayList = dbHelper.readZamowienia();
        orderAdapter = new OrderAdapter(this, arrayList);
        l1.setAdapter(orderAdapter);
        orderAdapter.notifyDataSetChanged();
    }
}