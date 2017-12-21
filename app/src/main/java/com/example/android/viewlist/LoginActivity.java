package com.example.android.viewlist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor spEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences=getSharedPreferences("data_login", Context.MODE_PRIVATE);
        spEditor=sharedPreferences.edit();

        //ambil setting yang sudah ada jika tersimpan
        String uname=sharedPreferences.getString("uname","");
        String pass=sharedPreferences.getString("pass","");

        if(validasiLogin(uname,pass)) {
            //pindah activity
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    public void masuk (View view){
        EditText et_username =(EditText) findViewById(R.id.et_username);
        EditText et_password= (EditText) findViewById(R.id.et_password);

        String uname=et_username.getText().toString();
        String pass=et_password.getText().toString();
        if(validasiLogin(uname,pass)){
            //simpan setting username & password
            spEditor.putString("uname",uname);
            spEditor.putString("pass",pass);
            spEditor.commit();

            //lakukan pindah activity
            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            //munculkan tulisan username & password tidak cocok
            Toast.makeText(this,"username password salah",Toast.LENGTH_SHORT).show();
        }
    }
    public boolean validasiLogin(String uname,String pass){
        if (uname.equals("admin")&&pass.equals("123456")){
            return true;
        }
        return false;
    }
}
