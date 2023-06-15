package com.example.ffffff.usersAutorization;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ffffff.R;
import com.example.ffffff.consumeAct.saludoApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class usersActivityLogin extends AppCompatActivity {

    String url="https://api.uealecpeterson.net/public/login";
    String token;
    String correo;
    String clave;
    String fuente="1";
     final String  resultado="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_login);
        correo="carlos@gmail.com";
        clave="12345678";
        try {
           // eventoboton();
            eventoboton();
            //volley();
        }catch (Exception ex){
            Log.i("erroraaa",ex.getMessage());
        }
    }

    private void volley(){
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("resultado",response);
                       // Toast.makeText(usersActivityLogin.this,response,Toast.LENGTH_LONG).show();
                        TextView tv=findViewById(R.id.result);
                        tv.setText(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("errorsito",error.getMessage());
                    }
                }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                headerMap.put("correo", correo);
                headerMap.put("clave", clave);
                headerMap.put("fuente", fuente);
                return headerMap;
            }
        };
        queue.add(stringRequest);
    }

    public void eventoboton(){
        Button btn=findViewById(R.id.btnlogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                volley();
                Log.i("resultadoJhon",resultado);
                TextView tv=findViewById(R.id.result);
                tv.setText(resultado);
            }
        });
    }


}