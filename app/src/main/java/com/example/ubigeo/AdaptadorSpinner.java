package com.example.ubigeo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class AdaptadorSpinner extends BaseAdapter{
    Context c;
    List<Mapa> mapas;
    int layout;

    public AdaptadorSpinner(Context c, List<Mapa> datos, int layout) {

        this.c = c;
        this.mapas = datos;
        this.layout = layout;
    }
    @Override
    public int getCount() {        return mapas.size();    }
    @Override
    public Object getItem(int i) {        return mapas.get(i);    }
    @Override
    public long getItemId(int i) {        return i;    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(c);
        view=inflater.inflate(layout,null);
        TextView v1 = view.findViewById(R.id.txt_spinner1);
        ImageView v3=view.findViewById(R.id.icono);
        v1.setText(mapas.get(i).nombre);
        v3.setImageResource(mapas.get(i).icono);
        return view;
    }
}
