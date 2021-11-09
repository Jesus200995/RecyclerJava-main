package com.example.recyclerjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detalle extends AppCompatActivity {

    TextView textonombre,textoapellido;
    ImageView imagenV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        instancias();
        String imagen = getIntent().getExtras().getString("imagen");
        String nombre = getIntent().getExtras().getString("nombre");
        String apellido = getIntent().getExtras().getString("apellido");


        textonombre.setText(nombre);
        textoapellido.setText(apellido);
        Glide.with(getApplicationContext()).load(imagen).into(imagenV);

    }

    private void instancias() {

        textoapellido = findViewById(R.id.apellidodetalle);
        textonombre = findViewById(R.id.nombredetalle);
        imagenV = findViewById(R.id.imagendetalle);
    }

}