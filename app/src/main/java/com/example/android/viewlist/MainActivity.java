package com.example.android.viewlist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data yang harus ditampilkan dibentuk objeknya
        //dimasukkan ke dalam array list
        final ArrayList<Makanan> daftar_makanan = new ArrayList<>();
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_up_black_48dp,"rendang",12000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_up_black_48dp,"teri kacang sambal",15000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_down_black_48dp,"ayam jagat raya",13000));
        daftar_makanan.add(new Makanan(R.drawable.ic_thumb_down_black_48dp,"indomie",12000));

        //bentuk makanan adapter
        MakananAdapter adapter=new MakananAdapter(this,daftar_makanan);
        //ambil objek list view
        ListView lv_makanan=(ListView) findViewById(R.id.lv_makanan);
        lv_makanan.setAdapter(adapter);
        //tambahkan
        lv_makanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Makanan m= daftar_makanan.get(i);
                String nama_makanan=m.getNama();
                Toast.makeText(getApplicationContext(),"Nama: "+nama_makanan,Toast.LENGTH_LONG).show();
            }
        });
    }
    public void keluar (View view){
        SharedPreferences sharedPreferences=getSharedPreferences("data_login", Context.MODE_PRIVATE);
        SharedPreferences.Editor spEditor=sharedPreferences.edit();
        spEditor.clear();
        spEditor.commit();

        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

}
