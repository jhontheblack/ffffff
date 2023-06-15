package com.example.ffffff;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btnEnviar);
        botonEvent();
    }


    private  void botonEvent()
    {
        EditText nombre=(EditText)findViewById(R.id.txtNombre);
        EditText pass=(EditText)findViewById(R.id.txtPassword);
        EditText fechaNac=(EditText)findViewById(R.id.fechaNac);
        Switch sw=findViewById(R.id.swNotificaciones);
        if(sw.isChecked())
            Log.i("jhon1","esta seleccionado");
        else
            Log.i("jhon2","no esta seleccionado");
        RadioGroup grupo=findViewById(R.id.grupo);
        Log.i("jhon1",grupo.getId()+"");
        Intent intent=new Intent(this, results.class);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("nombre",nombre.getText().toString());
                startActivity(intent);
                //Toast.makeText(view.getContext(),nombre.getText()+"Click en el boton",Toast.LENGTH_LONG).show(); //pepa
            }
        });
    }


}