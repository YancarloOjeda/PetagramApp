package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;


import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.favoritos) {
            Intent intent = new Intent(MainActivity.this, Favoritos.class);
            startActivity(intent);
        }
        return true;

    }

    public void inicializarListaMascotas(){
        /*Estos datos son estaticos. Cada vez que se inicializa este activity, se vuelven a cargar los mismos datos,
        no importa que los haya modificado en el setter. Lo mismo pasa en el activity Favoritos, que tiene la misma lista
        y se inicializa de la misma forma que aquí. Lo que necesito para que estos datos sean variables y no estaticos, es
        que al iniciar la App se lean de una BD y que cuando se cierre la App los guarde.
         */
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.mipmap.mascota_1_foreground, "Jack", 5, true));
        mascotas.add(new Mascota(R.mipmap.mascota_2_foreground, "Titan", 15, true));
        mascotas.add(new Mascota(R.mipmap.mascota_3_foreground, "Leo", 2, false));
        mascotas.add(new Mascota(R.mipmap.mascota_4_foreground, "Rabbit", 8, true));
        mascotas.add(new Mascota(R.mipmap.mascota_5_foreground, "Puppy", 10, false));

    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }

}