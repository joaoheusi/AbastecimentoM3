package com.example.joaomheusi.exerciciorecyclerview;

import android.view.View;
import java.io.Serializable;
import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import android.widget.Toast;

/**
 * Created by joaomheusi on 27/11/17.
 */

public class Abastecimento extends RealmObject implements Serializable {

    private static Double ultimoKm ;
    private String data;
    private Double litros;
    private Double kmA;
    private String posto;
    public Abastecimento() {

    }

    public ArrayList<Abastecimento> recuperaLista(View view){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Abastecimento> result1    = realm.where(Abastecimento.class).findAll();
        ArrayList<Abastecimento> a = new ArrayList<>();

        for(int i = 0; i < result1.size(); i++){
            Abastecimento atual = result1.get(i);
            a.add(atual);
        }
        return a;
    }

    public Double retornaAutonomia(){
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Abastecimento> result1    = realm.where(Abastecimento.class).findAll();
        ArrayList<Abastecimento> a = new ArrayList<>();
        Double AuxKm = 0.0;
        Double AuxL = 0.0;
        Double min =0.0;
        Double max =0.0;
        for(int i = 0; i < result1.size(); i++){
            Abastecimento atual = result1.get(i);
            AuxKm+= atual.getKmA();
            AuxL+=atual.getLitros();
            if( (i == result1.size()-1) && result1.size()!= 1 ){
                AuxL-=atual.getLitros();
            }
            if(max < atual.getKmA() || i == 0){
                max = atual.getKmA();
            }
            if(min> atual.getKmA() ||(i == 0 && result1.size()!= 1) ){
                min = atual.getKmA();
            }
            if( result1.size() == 1 ){
                return 0.0;

            }
        }
        return (max-min)/AuxL;

    }
    public double retornaUltimoKm(){
        return ultimoKm;
    };
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(Double litros) {
        this.litros = litros;
    }

    public double getKmA() {
        return kmA;
    }

    public void setKmA(Double kmA) {
        this.kmA = kmA;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }
}
