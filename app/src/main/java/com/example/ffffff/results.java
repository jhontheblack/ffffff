package com.example.ffffff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getValues();
    }


    private void getValues()
    {
        Bundle bundle = this.getIntent().getExtras();
        String nom=bundle.getString("nombre");
        String pass=bundle.getString("pass");
        String genero=bundle.getString("genero");
      //  String notifica=bundle.getString("notifica");
        TextView tv=findViewById(R.id.nombre);
        TextView tv2=findViewById(R.id.txtPassword);
        //TextView tv3=findViewById(R.id.notifica);
        tv.setText(nom);
        tv2.setText(pass);
      //  tv3.setText(notifica);
    }





}