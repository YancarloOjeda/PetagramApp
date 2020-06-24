package com.example.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Favoritos extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.mipmap.mascota_1_foreground, "Jack", 5, true));
        mascotas.add(new Mascota(R.mipmap.mascota_2_foreground, "Titan", 15, true));
        mascotas.add(new Mascota(R.mipmap.mascota_3_foreground, "Leo", 2, false));
        mascotas.add(new Mascota(R.mipmap.mascota_4_foreground, "Rabbit", 8, true));
        mascotas.add(new Mascota(R.mipmap.mascota_5_foreground, "Puppy", 10, false));

        Collections.sort(mascotas, new Comparator<Mascota>() {
            @Override
            public int compare(Mascota o1, Mascota o2) {
                return new Integer(o2.getCantidadRaiting()).compareTo(new Integer(o1.getCantidadRaiting()));
            }
        });

    }

    public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);

    }
}