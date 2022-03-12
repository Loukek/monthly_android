package com.example.monthly_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Bitmap> pc;
    ArrayList<String> opisy;
    LayoutInflater layoutInflater;
    ImageView imageView;
    TextView textView;

    public MyAdapter(Context context, ArrayList<Bitmap> pc, ArrayList<String> opisy){
        super();
        this.context = context;
        this.pc = pc;
        this.opisy = opisy;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return pc.size();
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    @Override
    public long getItemId(int position){
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = layoutInflater.inflate(R.layout.my_spinner_items, null);
        imageView = convertView.findViewById(R.id.imageView);
        textView = convertView.findViewById(R.id.textView);
        imageView.setImageBitmap(pc.get(position));
        textView.setText(opisy.get(position));
        return convertView;
    }
}


