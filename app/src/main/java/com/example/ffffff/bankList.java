package com.example.ffffff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ffffff.consumeAct.saludoApi;
import com.example.ffffff.webService.Asynchtask;
import com.example.ffffff.webService.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class bankList extends AppCompatActivity /* implements Asynchtask */{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_list);
       // leerApi();
        try {
            volley();
        }catch (Exception e){
            Log.i("msg",e.getMessage());
        }
    }



    //volley
    private void volley(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api-uat.kushkipagos.com/transfer-subscriptions/v1/bankList";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("resultado",response);
                        Toast.makeText(bankList.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("errorsito",error.getMessage());
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Public-Merchant-Id", "84e1d0de1fbf437e9779fd6a52a9ca18");
                return params;
            }
        };
        queue.add(stringRequest);
    }


/*

    //httprequest
    public void leerApi(){

        //Bundle bundle = this.getIntent().getExtras();
        //usuario=bundle.getString("usuario");
        // contrasenia=bundle.getString("contrasenia");
        Map<String, String> datos = new HashMap<String, String>();

        String url="https://api-uat.kushkipagos.com/transfer-subscriptions/v1/bankList";
        WebService ws= new WebService(
                url,
                datos, this, this);
        ws.execute("GET","Public-Merchant-Id","84e1d0de1fbf437e9779fd6a52a9ca18");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        //parsear(result);
    }

    public void parsear(String result) throws JSONException {
        String lstBancos="";
        JSONArray JSONlista = new JSONArray(result);
        for(int i=0; i< JSONlista.length();i++){
            JSONObject banco= JSONlista.getJSONObject(i);
            lstBancos = lstBancos + "\n" +
                    banco.getString("name").toString();
        }
        TextView tv=findViewById(R.id.bancos);
        tv.setText(lstBancos);
    }*/

}