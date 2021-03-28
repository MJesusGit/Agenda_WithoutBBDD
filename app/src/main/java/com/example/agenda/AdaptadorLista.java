package com.example.agenda;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorLista extends RecyclerView.Adapter<AdaptadorLista.ViewHolder> {
    private ArrayList<Contacto> contactos;
    private OnItemSelectedListener itemSelectedListener;

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView lbl_nombre;
        private TextView lbl_telefono;
        private ImageView imagContacto;
        ViewHolder(View view) {
            super(view);
            lbl_nombre = view.findViewById(R.id.lbl_nombre);
            lbl_telefono = view.findViewById(R.id.lbl_telefono);
            imagContacto = view.findViewById(R.id.imagContacto);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int posicion = getAdapterPosition();
                    if (itemSelectedListener != null) {
                        itemSelectedListener.onContactoSeleccionado(posicion);
                    }
                }//añadir slide 42

            });
            PopupMenu popup = new PopupMenu(view.getContext(), view);
            popup.getMenuInflater().inflate(R.menu.menu_contextual, popup.getMenu());
            view.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                @Override
                public void onCreateContextMenu(ContextMenu menu, View v,
                                                ContextMenu.ContextMenuInfo menuInfo)
                {
                    popup.show();
                }
            });
// Oyente de selección de opciones del menú popup
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener (){
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (itemSelectedListener != null) {
                        itemSelectedListener.onMenuContextualContacto(getAdapterPosition(), item);
                    }
                    return true;
                }
            });
        }


    }

    public AdaptadorLista(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }
    public AdaptadorLista.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(AdaptadorLista.ViewHolder holder, int position) {
        Contacto contacto = contactos.get(position);
        holder.lbl_nombre.setText(contactos.get(position).getNombre());
        holder.lbl_telefono.setText(contactos.get(position).getTelefono());
        switch (contactos.get(position).getTipo())
        {
            case 0: //Cargar imagen de contactos tipo "familia"
                holder.imagContacto.setImageResource(R.drawable.familia);
                break;
            case 1: //Cargar imagen de los contactos tipo "amigos"
                holder.imagContacto.setImageResource(R.drawable.amigo);
                break;
            case 2: //Cargar imagen de los contactos tipo "trabajo"
                holder.imagContacto.setImageResource(R.drawable.trabajo);
        }
    }
    @Override
    public int getItemCount() {
        return contactos.size();
    }
    public void setItemSelectedListener(OnItemSelectedListener itemSelectedListener)
    {
        this.itemSelectedListener = itemSelectedListener;
    }
}