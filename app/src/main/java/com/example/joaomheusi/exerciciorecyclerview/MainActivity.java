package com.example.joaomheusi.exerciciorecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;


import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    ArrayList<Abastecimento> listaMae = new ArrayList<>();
    private TextView tvRendimento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Realm.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRendimento = (TextView) findViewById(R.id.tvRendimento);
        tvRendimento.setText("0.0");
    }



    public void abrirLista(View quemClicou){
        Bundle mochilaLista = new Bundle();
        Intent intencao = new Intent(getApplicationContext(), ListaActivity.class);
        mochilaLista.putSerializable("listaA", listaMae);
        startActivity(intencao,mochilaLista);
    }
    public void abrirAdicionar(View quemClicou){
        Intent intencao = new Intent(getApplicationContext(), AdicionarActivity.class);
        startActivityForResult(intencao,55);
    }


    @Override
    protected void onResume() {
        super.onResume();
        tvRendimento.setText(Abastecimento.retornaAutonomia()+"");
    }
}
