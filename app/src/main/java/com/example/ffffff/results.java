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
        TextView tv=findViewById(R.id.nombre);
        tv.setText(nom);
    }

}