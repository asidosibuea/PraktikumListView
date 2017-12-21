package com.example.android.viewlist;

/**
 * Created by User on 11/1/2017.
 */import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Praktikan on 01/11/2017.
 */
public class MakananAdapter extends ArrayAdapter<Makanan>{
    public MakananAdapter(Context context, List<Makanan> objects) {
        super(context, 0, objects);
    }
    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {


        //bentuk inflater
        LayoutInflater inflater=LayoutInflater.from(getContext());


        //bentuk view
        if(convertView== null) {
            convertView=inflater.inflate(R.layout.layout_daftar,parent,false);
        }


        // ambil objek makanan
        Makanan makanan = getItem(position);


        //ambil elemen
        ImageView imageView=(ImageView) convertView.findViewById(R.id.idGambar);
        TextView tv_nama=(TextView) convertView.findViewById(R.id.tv_makanan);
        TextView tv_harga=(TextView) convertView.findViewById(R.id.tv_harga);

        //hubungkan objek makananan dengan view
        imageView.setImageResource(makanan.getImageId());
        tv_nama.setText(makanan.getNama());
        tv_harga.setText(String.valueOf(makanan.getHarga()));
        return convertView;
    }
}
