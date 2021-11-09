package com.example.recyclerjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerPersonas.OnSelected {

    RecyclerView recyclerView;

    RecyclerPersonas recyclerPersonas;

    List<Persona> listaPersonas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        instancias();

        recyclerView.setAdapter(recyclerPersonas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));

        recyclerPersonas.notifyDataSetChanged();


        listaPersonas.add( new Persona("https://codigoonclick.com/wp-content/uploads/2018/03/Conoce-Angular-1024x538.jpg","ANGULAR","Precio del curso: $2,500 MXN"));
        listaPersonas.add( new Persona("https://blog.tednologia.com/wp-content/uploads/2020/03/php-2.png","PHP","Precio del curso: $3,500 MXN"));
        listaPersonas.add( new Persona("https://s3.amazonaws.com/s3.timetoast.com/public/uploads/photo/17959187/image/medium-fe0247cebdaf8334db47bf281f2b95ec.png","HTML","Precio del curso: $5,300 MXN"));
        listaPersonas.add( new Persona("https://i.blogs.es/53044d/java/1366_521.jpg","JAVA","Precio del curso: $4,800 MXN"));
        listaPersonas.add( new Persona("https://i.blogs.es/6665fc/original/450_1000.png","KOTLIN","Precio del curso : $7,800  MXN"));


    }

    private void instancias() {

        listaPersonas = new ArrayList();
        recyclerView = findViewById(R.id.listado);
        recyclerPersonas = new RecyclerPersonas(listaPersonas,MainActivity.this);


    }


    @Override
    public void SelectedNombre(Persona persona) {
        Toast.makeText(getApplicationContext(),"Nombre: "+persona.nombre,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Detalle.class);
        intent.putExtra("imagen",persona.imagen);
        intent.putExtra("nombre",persona.nombre);
        intent.putExtra("apellido",persona.apellido);
        startActivity(intent);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnList: Utilidad.visualizacion=Utilidad.LIST;
                break;
            case R.id.btnGrid: Utilidad.visualizacion=Utilidad.GRID;
                break;



    }
    }
}
