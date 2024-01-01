package com.example.tarealistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String precio = intent.getStringExtra("precio");
        String category = intent.getStringExtra("categoria");
        String imagend = intent.getStringExtra("imagen");
        TextView txtTitulo = findViewById(R.id.lbtitle);
        TextView txtPrecio = findViewById(R.id.lbpreciopre);
        TextView txtcategoria = findViewById(R.id.lbcategoriapre);


        txtTitulo.setText(titulo);
        txtPrecio.setText(precio);
        txtcategoria.setText(category);

        ImageView imageView = (ImageView)findViewById(R.id.imgProd);
        Glide.with(this).load(imagend).into(imageView);

    }
    public void pagar(View view){
        Intent intent = new Intent(MainActivity2.this, MainActivity2.class);
        startActivity(intent);
    }
}