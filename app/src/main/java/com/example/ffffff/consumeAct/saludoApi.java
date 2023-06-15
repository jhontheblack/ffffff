package com.example.ffffff.consumeAct;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ffffff.R;
import com.example.ffffff.webService.Asynchtask;
import com.example.ffffff.webService.WebService;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class saludoApi extends AppCompatActivity implements Asynchtask {

    String usuario="cristian";
    String contrasenia="cristian123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo_api);
     /*   try {
            leerApi();
        }catch (Exception ex){
            Log.i("errorsito",ex.getMessage());
        }*/


        volley();

    }


    //volley

    private void volley(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://revistas.uteq.edu.ec/ws/login.php?usr=crisfftian&pass=cristian123";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("resultado",response);
                        Toast.makeText(saludoApi.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("errorsito",error.getMessage());
                    }
                });
        queue.add(stringRequest);
    }





    //httprequest

    public void leerApi(){

        //Bundle bundle = this.getIntent().getExtras();
        //usuario=bundle.getString("usuario");
       // contrasenia=bundle.getString("contrasenia");
        Map<String, String> datos = new HashMap<String, String>();

        String url="https://revistas.uteq.edu.ec/ws/login.php?usr=crisfftian&pass=cristian123";
        WebService ws= new WebService(
                url,
                datos, this, this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        Log.i("holiiiii",result);
    }
}