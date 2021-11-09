package com.example.recyclerjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerPersonas extends RecyclerView.Adapter<RecyclerPersonas.MiHolder> {


    List<Persona> listaPersonas;
    Context context;
    OnSelected listener;
    public RecyclerPersonas(List<Persona> listaPersonas, Context context) {
        this.listaPersonas = listaPersonas;
        this.context = context;
        listener = (OnSelected) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_persona,parent,false);
        MiHolder miHolder = new MiHolder(view);
        return miHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Persona persona = listaPersonas.get(position);
        Glide.with(context).load(persona.getImagen()).into(holder.imagenHolder);

        holder.nombreHolder.setText(persona.getNombre());
        holder.apellidoHolder.setText(persona.getApellido());
        holder.nombreHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.SelectedNombre(persona);
            }
        });

    }

    interface OnSelected{
        void SelectedNombre(Persona persona);
    }
    @Override
    public int getItemCount() {
        return listaPersonas.size();
    }

    //MIHOLDER EXTIENDE DE RECYCLERVIEW
    public class MiHolder extends RecyclerView.ViewHolder {
        TextView nombreHolder,apellidoHolder;
        ImageView imagenHolder;
        //CONSTRUCTOR
        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombreHolder = itemView.findViewById(R.id.idnombre);
            apellidoHolder = itemView.findViewById(R.id.idapellido);
            imagenHolder = itemView.findViewById(R.id.idimagen);

        }

        public TextView getNombreHolder() {
            return nombreHolder;
        }

        public void setNombreHolder(TextView nombreHolder) {
            this.nombreHolder = nombreHolder;
        }

        public TextView getApellidoHolder() {
            return apellidoHolder;
        }

        public void setApellidoHolder(TextView apellidoHolder) {
            this.apellidoHolder = apellidoHolder;
        }

        public ImageView getImagenHolder() {
            return imagenHolder;
        }

        public void setImagenHolder(ImageView imagenHolder) {
            this.imagenHolder = imagenHolder;
        }
    }
}
