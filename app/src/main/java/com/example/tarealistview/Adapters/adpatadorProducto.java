package com.example.tarealistview.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tarealistview.MainActivity2;
import com.example.tarealistview.R;
import com.example.tarealistview.modelos.producto;

import java.util.ArrayList;

public class adpatadorProducto extends ArrayAdapter<producto> {
    public adpatadorProducto(Context context, ArrayList<producto> datos) {
        super(context, R.layout.listproductsmodel, datos);
        for (producto usuario : datos) {
            Log.d("AdaptadorUsuario", "Nombre: " + usuario.getTitulo());
            Log.d("AdaptadorUsuario", "Email: " + usuario.getDescripcion());
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listproductsmodel, null);

        ImageView imageView = (ImageView)item.findViewById(R.id.imgProd);
        Glide.with(getContext())
                .load(this.getItem(position).getImagenpro())
                .into(imageView);

        TextView lblCategoria = (TextView)item.findViewById(R.id.lbcate);
        lblCategoria.setText(getItem(position).getCategory().toString());

        TextView lblPrecio = (TextView)item.findViewById(R.id.lbpri);
        lblPrecio.setText(getItem(position).getPrecio().toString());

        TextView lblNombreProducto = (TextView)item.findViewById(R.id.lbnombreproducto);
        lblNombreProducto.setText(getItem(position).getTitulo());

        TextView lblPrecioTexto = (TextView)item.findViewById(R.id.lbprice);
        lblPrecioTexto.setText("Price:");

        TextView lblDescripcion = (TextView)item.findViewById(R.id.lbdescripcion);
        lblDescripcion.setText(getItem(position).getDescripcion());

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity2.class);

                intent.putExtra("titulo", getItem(position).getTitulo());
                intent.putExtra("precio", getItem(position).getPrecio());
                intent.putExtra("categoria", getItem(position).getCategory());
                intent.putExtra("imagen", getItem(position).getImagenpro());
                getContext().startActivity(intent);
            }
        });
        return item;
    }
}

