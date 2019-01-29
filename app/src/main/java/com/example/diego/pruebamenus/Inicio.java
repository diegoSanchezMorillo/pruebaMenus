package com.example.diego.pruebamenus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class Inicio extends AppCompatActivity {

    ImageView persona,bloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Declaramos los elementos para interactuar con ellos
        persona = (ImageView) findViewById(R.id.imgPersonas);
        bloc = (ImageView)findViewById(R.id.imgBloc);
        //Al hacer click en la imagen se abre la nueva activity
        persona.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Inicio.this,PersonasActivity.class);
                startActivity(i);
            }
        });
        bloc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Inicio.this,BlocActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Al pinchar en elemento del menu abrimos su activity
        if (id == R.id.personas) {
            Intent i = new Intent(Inicio.this,PersonasActivity.class);
            startActivity(i);

            return true;
        }if (id == R.id.blocNotas) {
            Intent i = new Intent(Inicio.this,BlocActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
