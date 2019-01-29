package com.example.diego.pruebamenus;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class BlocActivity extends AppCompatActivity {

    EditText cadena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Declaramos el elemento para intercatuar con el
        cadena = (EditText)findViewById(R.id.txtTexto);
        //Creamos el archivo de preferencias, en el caso que no exista
        SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
        //Variable dónde guardaremos el contenido leido del archivo de configuración
        String valorLeido;
        //Le pasamos el valor del campo del archivo de preferencias y si no hay nada añadimos el campo
        valorLeido = prefs.getString("Texto", "vacio");
        //Mostramos el valor en el campo de texto
        cadena.setText(valorLeido);
    }

    @Override

    //Creamos el menu
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guardar, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Cuando se clickea el botón guardar del menú superior
        if (id == R.id.guardar) {
            //Creamos el archivo de preferencias, en el caso que no exista
            SharedPreferences prefs = getSharedPreferences("ficheroconfiguracion", Context.MODE_PRIVATE);
            //Creamos el editor para poder escribir en el archivo
            SharedPreferences.Editor editor = prefs.edit();
            //Le pasamos los datos
            editor.putString("Texto", cadena.getText().toString());
            //Añadimos al contenido del archivo de preferencias
            editor.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
