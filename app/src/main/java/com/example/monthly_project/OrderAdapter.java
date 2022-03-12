package com.example.monthly_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderAdapter extends BaseAdapter {

    ArrayList<ZamowienieModel> arrayList;
    Context context;

    public OrderAdapter(Context context, ArrayList<ZamowienieModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
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
            convertView = inflater.inflate(R.layout.orderlistview, null);
            TextView t1_id = (TextView)convertView.findViewById(R.id.id_txt);
            TextView t2_date = (TextView)convertView.findViewById(R.id.date_txt);
            TextView t3_name = (TextView)convertView.findViewById(R.id.name_txt);
            ZamowienieModel zamowienieModel = arrayList.get(position);

            t1_id.setText(String.valueOf(zamowienieModel.getId()));
            t2_date.setText(String.valueOf(zamowienieModel.getDate()));
            t3_name.setText(String.valueOf(zamowienieModel.getName()));
        }


        return convertView;
    }
}
