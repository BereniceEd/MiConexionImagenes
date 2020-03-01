package com.example.miconexionimagenes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.PersonViewHolder>{

   //Constructor con los objetos
    ArrayList<Heroe> persons;

    Adapter(ArrayList<Heroe> persons){
        this.persons = persons;
    }


    //Se le pasa el layout que contendra la informacion al recycler view
    @NonNull

    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagenes, parent, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }


//Se le pasan los datos del array list, para la imagen se usa la libreria Picasso
    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        holder.personName.setText(persons.get(position).getName());
        Picasso.get().load(persons.get(position).getImage_url()).resize(500, 500).into(holder.personPhoto);

    }
//Metodo para ver cuantas veces se repetira el llenado

    @Override
    public int getItemCount() {
        return persons.size();
    }
    //Prepara el recycler view
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
    //Carga los datos de la lista en las cardviews del layout
    public static class PersonViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.textView2);

            personPhoto = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

}
