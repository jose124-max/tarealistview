package com.example.tarealistview;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tarealistview.Adapters.adpatadorProducto;
import com.example.tarealistview.modelos.producto;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import webservice.Asynchtask;
import webservice.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    ListView lstOpciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstOpciones = (ListView)findViewById(R.id.listx);
        View header = getLayoutInflater().inflate(R.layout.listproductsmodel, null);
        lstOpciones.addHeaderView(header);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://fakestoreapi.com/products",
                datos, (Context) MainActivity.this, (Asynchtask) MainActivity.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {

        try {
            Log.d("MainActivity", "Response from web service: " + result);
            JSONArray JSONlistaUsuarios = new JSONArray(result);
            JSONlistaUsuarios=getFirstN(JSONlistaUsuarios,5);
            Log.d("prueba a", "Aqui funciona");

            ArrayList<producto> lstUsuarios = producto.JsonObjectsBuild(JSONlistaUsuarios);
            Log.d("prueba b", "Aqui funciona");

            adpatadorProducto adapatorUsuario = new adpatadorProducto(this, lstUsuarios);
            Log.d("prueba c", "Aqui funciona");

            lstOpciones.setAdapter(adapatorUsuario);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("MainActivity", "Error parsing JSON", e);
        }
    }
    private JSONArray getFirstN(JSONArray jsonArray, int n) throws JSONException {
        JSONArray resultArray = new JSONArray();
        for (int i = 0; i < Math.min(n, jsonArray.length()); i++) {
            resultArray.put(jsonArray.getJSONObject(i));
        }
        return resultArray;
    }
}