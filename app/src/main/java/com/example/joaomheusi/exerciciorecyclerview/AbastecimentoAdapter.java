package com.example.joaomheusi.exerciciorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by joaomheusi on 27/11/17.
 */

public class AbastecimentoAdapter extends RecyclerView.Adapter {


    private ArrayList<Abastecimento> listaAbastecimentos;

    public void setListaAbastecimentos(ArrayList<Abastecimento> listaAbastecimentos) {
        this.listaAbastecimentos = listaAbastecimentos;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.abastecimento_item, parent, false);
        AbastecimentoHolder gaveta = new AbastecimentoHolder(layoutView);
        Log.d("RV", "Criando a gaveta "+gaveta.toString());
        return gaveta;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AbastecimentoHolder gaveta = (AbastecimentoHolder) holder;
        Abastecimento atual = this.listaAbastecimentos.get(position);
        gaveta.atualizaOAbastecimentoQueVoceEstaApresentando(atual);
        Log.d("RV", "Atualizando a gaveta "+gaveta.toString()+" com o objteto "+position);
    }

    @Override
    public int getItemCount() {
        return this.listaAbastecimentos.size();
    }
}
