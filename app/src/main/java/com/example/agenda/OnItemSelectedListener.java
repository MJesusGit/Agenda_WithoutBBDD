package com.example.agenda;

import android.view.MenuItem;

public interface OnItemSelectedListener {

        void onContactoSeleccionado(int posicion);
        void onMenuContextualContacto(int posicion, MenuItem menu);
}
