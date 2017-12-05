package com.example.joaomheusi.exerciciorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ListaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        Abastecimento x = new Abastecimento();
        View v;
        v = new View(this);

        RecyclerView rvLista = (RecyclerView) findViewById(R.id.rvLista);
        AbastecimentoAdapter adaptador = new AbastecimentoAdapter();
        adaptador.setListaAbastecimentos( x.recuperaLista(v) );
        rvLista.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        rvLista.setAdapter( adaptador );

    }
}
