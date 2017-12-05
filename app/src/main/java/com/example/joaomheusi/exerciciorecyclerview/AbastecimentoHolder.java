package com.example.joaomheusi.exerciciorecyclerview;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joaomheusi on 27/11/17.
 */

public class AbastecimentoHolder extends RecyclerView.ViewHolder {

    private TextView tvData;
    private TextView tvKm;
    private TextView tvLitros;
    private ImageView ivLogo;

    public AbastecimentoHolder(View itemView) {
        super(itemView);

        this.tvData = (TextView) itemView.findViewById(R.id.tvData);
        this.tvLitros = (TextView) itemView.findViewById(R.id.tvLitros);
        this.tvKm = (TextView) itemView.findViewById(R.id.tvKm);
        this.ivLogo = (ImageView) itemView.findViewById(R.id.ivLogo);
    }

    public void atualizaOAbastecimentoQueVoceEstaApresentando(Abastecimento v){
        tvData.setText( v.getData() );
        tvLitros.setText( String.valueOf(v.getLitros()));
        tvKm.setText( String.valueOf(v.getKmA()) );
        if(v.getPosto().toLowerCase().equals("ipiranga")){
            this.ivLogo.setImageResource(R.drawable.ipiranga);
        }else if (v.getPosto().toLowerCase().equals("shell")){
            this.ivLogo.setImageResource(R.drawable.shell);
        }else if (v.getPosto().toLowerCase().equals("petrobras")){
            this.ivLogo.setImageResource(R.drawable.petrobras);
        }else if (v.getPosto().toLowerCase().equals("texaco")){
            this.ivLogo.setImageResource(R.drawable.texaco_locao_);
        }else{
            this.ivLogo.setImageResource(R.drawable.outros);
        }
}
}
