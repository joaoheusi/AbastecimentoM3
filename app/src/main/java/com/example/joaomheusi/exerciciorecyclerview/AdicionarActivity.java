package com.example.joaomheusi.exerciciorecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;

public class AdicionarActivity extends AppCompatActivity {


    private EditText etKm;
    private EditText etLitros;
    private EditText etData;
    private Spinner sPostos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar);

        etKm = (EditText) findViewById(R.id.etKm);
        etLitros = (EditText) findViewById(R.id.etLitros);
        etData = (EditText) findViewById(R.id.etData);
        sPostos = (Spinner) findViewById(R.id.sPostos);

    }
    // feita comparação km anterior
    public void salvar(View v){

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();


        Abastecimento a = realm.createObject(Abastecimento.class);

        Double atual= Double.parseDouble(etKm.getText().toString());

        RealmResults<Abastecimento> result1  = realm.where(Abastecimento.class).findAll();
        Abastecimento x = result1.first();

        if(atual < x.getKmA()){
            Toast.makeText(this, "Erro KM", Toast.LENGTH_SHORT).show();
            return;
        }else{
            a.setKmA(Double.parseDouble(etKm.getText().toString()));
            a.setLitros(Double.parseDouble(etLitros.getText().toString()));
            a.setData(etData.getText().toString());
            a.setPosto(sPostos.getSelectedItem().toString());

            realm.copyFromRealm(a);
        }

        realm.commitTransaction();
        finish();

    }

}
