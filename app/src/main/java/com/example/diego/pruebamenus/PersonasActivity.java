package com.example.diego.pruebamenus;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PersonasActivity extends AppCompatActivity {

    ImageView empleado1,empleado2,empleado3,empleado4,empleado5,empleado6;
    int telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Declaramos los elemento para interactuar con ellos
        empleado1 = (ImageView) findViewById(R.id.imagen1);
        empleado2 = (ImageView) findViewById(R.id.imagen2);
        empleado3 = (ImageView) findViewById(R.id.imagen3);
        empleado4 = (ImageView) findViewById(R.id.imagen4);
        empleado5 = (ImageView) findViewById(R.id.imagen5);
        empleado6 = (ImageView) findViewById(R.id.imagen6);
        //Al dejar pulsado los elementos abrimos el menu contextual
        registerForContextMenu(empleado1);
        registerForContextMenu(empleado2);
        registerForContextMenu(empleado3);
        registerForContextMenu(empleado4);
        registerForContextMenu(empleado5);
        registerForContextMenu(empleado6);

                SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("Telefono", "652123123");
                editor.commit();


    }
    //Creamos el menu contextual
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contextual, menu);
    }

    //Recogemos que elemento pinchamos del menu contextual
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.llamar:
                Toast toast1 =
                        Toast.makeText(getApplicationContext(), R.string.telefono, Toast.LENGTH_SHORT);
                toast1.show();
                // Acción a realizar por contextual 1
            case R.id.correo:  // Acción a realizar por contextual 2
                Toast toast2 =
                        Toast.makeText(getApplicationContext(), R.string.correo, Toast.LENGTH_SHORT);
                toast2.show();
        }
        return true;
    }

}
