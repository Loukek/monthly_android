package com.example.monthly_project;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailAdapter extends BaseAdapter {
    ZamowienieModel zamowienieModel;
    ArrayList<Komputer> arrayListPC;
    ArrayList<Myszka> arrayListMouse;
    ArrayList<Klawiatura> arrayListKlawiatura;
    ArrayList<Kamera> arrayListKamera;
    int list_size;
    Context context;



    public DetailAdapter(Context context, int list_size, ZamowienieModel zamowienieModel, ArrayList<Komputer> arrayListPC, ArrayList<Myszka> arrayListMouse, ArrayList<Klawiatura> arrayListKlawiatura, ArrayList<Kamera> arrayListKamera) {
        this.list_size = list_size;
        this.context = context;
        this.zamowienieModel = zamowienieModel;
        this.arrayListPC = arrayListPC;
        this.arrayListMouse = arrayListMouse;
        this.arrayListKlawiatura = arrayListKlawiatura;
        this.arrayListKamera = arrayListKamera;
    }

//    int id_pc = zamowienieModel.getKomputer_id();
//    int id_mouse = zamowienieModel.getMyszka_id();
//    int id_klawiatura = zamowienieModel.getKlawiatura_id();
//    int id_kamera = zamowienieModel.getkameraPosition();


    @Override
    public int getCount() {
        return list_size;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.detail_listview, null);
            TextView t1_id = (TextView)convertView.findViewById(R.id.id_detail);
            TextView t2_name = (TextView)convertView.findViewById(R.id.name_detail);
            TextView t3_price = (TextView)convertView.findViewById(R.id.price_detail);
            TextView t4_opis = (TextView)convertView.findViewById(R.id.opisPaster);



            Komputer komputerModel = arrayListPC.get(zamowienieModel.getKomputer_id());
            Myszka myszkaModel = arrayListMouse.get(zamowienieModel.getMyszka_id());
            Klawiatura klawiaturaModel = arrayListKlawiatura.get(zamowienieModel.getKlawiatura_id());
            Kamera kameraModel = arrayListKamera.get(zamowienieModel.getKamera_id());

            int myszkaPosition = zamowienieModel.getMyszka_id();
            int keyboardPosition = zamowienieModel.getKlawiatura_id();
            int kameraPosition = zamowienieModel.getKamera_id();

            double cena_suma = zamowienieModel.getCena_suma();




            if(myszkaPosition != 4 && keyboardPosition == 4 && kameraPosition == 4){
                if(position == 0){
                    t1_id.setText(String.valueOf(1));
                    t2_name.setText(String.valueOf(komputerModel.getName()));
                    t3_price.setText(String.valueOf(komputerModel.getCena()));
                    t4_opis.setText(komputerModel.getDescription());
                }else{
                    t1_id.setText(String.valueOf(2));
                    t2_name.setText(String.valueOf(myszkaModel.getName()));
                    t3_price.setText(String.valueOf(myszkaModel.getCena()));
                    t4_opis.setText(myszkaModel.getDescription());
                }
            }else if(myszkaPosition == 4 && keyboardPosition != 4 && kameraPosition == 4){
                if(position == 0){
                    t1_id.setText(String.valueOf(1));
                    t2_name.setText(String.valueOf(komputerModel.getName()));
                    t3_price.setText(String.valueOf(komputerModel.getCena()));
                    t4_opis.setText(komputerModel.getDescription());
                }else{
                    t1_id.setText(String.valueOf(2));
                    t2_name.setText(String.valueOf(klawiaturaModel.getName()));
                    t3_price.setText(String.valueOf(klawiaturaModel.getCena()));
                    t4_opis.setText(klawiaturaModel.getDescription());
                }
            }else if(myszkaPosition == 4 && keyboardPosition == 4 && kameraPosition != 4) {
                if(position == 0){
                    t1_id.setText(String.valueOf(1));
                    t2_name.setText(String.valueOf(komputerModel.getName()));
                    t3_price.setText(String.valueOf(komputerModel.getCena()));
                    t4_opis.setText(komputerModel.getDescription());
                }else{
                    t1_id.setText(String.valueOf(2));
                    t2_name.setText(String.valueOf(kameraModel.getName()));
                    t3_price.setText(String.valueOf(kameraModel.getCena()));
                    t4_opis.setText(kameraModel.getDescription());
                }
            }else if(myszkaPosition != 4 && keyboardPosition != 4 && kameraPosition == 4){
                if(position == 0){
                    t1_id.setText(String.valueOf(1));
                    t2_name.setText(String.valueOf(komputerModel.getName()));
                    t3_price.setText(String.valueOf(komputerModel.getCena()));
                    t4_opis.setText(komputerModel.getDescription());
                }else if(position == 1){
                    t1_id.setText(String.valueOf(2));
                    t2_name.setText(String.valueOf(myszkaModel.getName()));
                    t3_price.setText(String.valueOf(myszkaModel.getCena()));
                    t4_opis.setText(myszkaModel.getDescription());
                }else{
                    t1_id.setText(String.valueOf(3));
                    t2_name.setText(String.valueOf(klawiaturaModel.getName()));
                    t3_price.setText(String.valueOf(klawiaturaModel.getCena()));
                    t4_opis.setText(klawiaturaModel.getDescription());
                }
            }else if(myszkaPosition != 4 && keyboardPosition == 4 && kameraPosition != 4){
                if(position == 0){
                    t1_id.setText(String.valueOf(1));
                    t2_name.setText(String.valueOf(komputerModel.getName()));
                    t3_price.setText(String.valueOf(komputerModel.getCena()));
                    t4_opis.setText(komputerModel.getDescription());
                }else if(position == 1){
                    t1_id.setText(String.valueOf(2));
                    t2_name.setText(String.valueOf(myszkaModel.getName()));
                    t3_price.setText(String.valueOf(myszkaModel.getCena()));
                    t4_opis.setText(myszkaModel.getDescription());
                }else{
                    t1_id.setText(String.valueOf(3));
                    t2_name.setText(String.valueOf(kameraModel.getName()));
                    t3_price.setText(String.valueOf(kameraModel.getCena()));
                    t4_opis.setText(kameraModel.getDescription());
                }
            }else if(myszkaPosition == 4 && keyboardPosition != 4 && kameraPosition != 4){
                if(position == 0){
                    t1_id.setText(String.valueOf(1));
                    t2_name.setText(String.valueOf(komputerModel.getName()));
                    t3_price.setText(String.valueOf(komputerModel.getCena()));
                    t4_opis.setText(komputerModel.getDescription());
                }else if(position == 1){
                    t1_id.setText(String.valueOf(2));
                    t2_name.setText(String.valueOf(klawiaturaModel.getName()));
                    t3_price.setText(String.valueOf(klawiaturaModel.getCena()));
                    t4_opis.setText(klawiaturaModel.getDescription());
                }else{
                    t1_id.setText(String.valueOf(3));
                    t2_name.setText(String.valueOf(kameraModel.getName()));
                    t3_price.setText(String.valueOf(kameraModel.getCena()));
                    t4_opis.setText(kameraModel.getDescription());
                }
            }else if(myszkaPosition != 4 && keyboardPosition != 4 && kameraPosition != 4){
                if(position == 0){
                    t1_id.setText(String.valueOf(1));
                    t2_name.setText(String.valueOf(komputerModel.getName()));
                    t3_price.setText(String.valueOf(komputerModel.getCena()));
                    t4_opis.setText(komputerModel.getDescription());
                }else if(position == 1){
                    t1_id.setText(String.valueOf(2));
                    t2_name.setText(String.valueOf(myszkaModel.getName()));
                    t3_price.setText(String.valueOf(myszkaModel.getCena()));
                    t4_opis.setText(myszkaModel.getDescription());
                }else if(position == 2){
                    t1_id.setText(String.valueOf(3));
                    t2_name.setText(String.valueOf(klawiaturaModel.getName()));
                    t3_price.setText(String.valueOf(klawiaturaModel.getCena()));
                    t4_opis.setText(klawiaturaModel.getDescription());
                }else{
                    t1_id.setText(String.valueOf(4));
                    t2_name.setText(String.valueOf(kameraModel.getName()));
                    t3_price.setText(String.valueOf(kameraModel.getCena()));
                    t4_opis.setText(kameraModel.getDescription());
                }
            }
            else{
                t1_id.setText(String.valueOf(1));
                t2_name.setText(String.valueOf(komputerModel.getName()));
                t3_price.setText(String.valueOf(komputerModel.getCena()));
                t4_opis.setText(komputerModel.getDescription());
            }



        }


        return convertView;
    }
}
