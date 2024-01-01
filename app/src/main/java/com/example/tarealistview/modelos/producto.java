package com.example.tarealistview.modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
public class producto {
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private String titulo;

    public String getPrecio() {
        return precio;
    }

    public String getImagenpro() {
        return imagenpro;
    }

    public void setImagenpro(String imagenpro) {
        this.imagenpro = imagenpro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;
    private String precio;
    private String descripcion;
    private String imagenpro;

    public producto(JSONObject a) throws JSONException {
        titulo = a.getString("title").toString();
        category = a.getString("category").toString() ;
        precio = a.getString("price").toString();
        descripcion = a.getString("description").toString() ;
        imagenpro=a.getString("image").toString() ;
    }


    public static ArrayList<producto> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<producto> productos = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            productos.add(new producto(datos.getJSONObject(i)));
        }
        return productos;
    }
}
