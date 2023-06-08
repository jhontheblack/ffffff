package com.example.ffffff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        EditText ttt=(EditText)findViewById(R.id.txtNome2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),ttt.getText()+"Click en el boton",Toast.LENGTH_LONG).show(); //pepa
            }
        });

    }


}