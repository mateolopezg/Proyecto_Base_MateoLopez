package com.w.appmateolopez;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Adapter;
import Clases.Insumo;
import Clases.daoInsumo;

public class Insumos_act extends AppCompatActivity {

    private daoInsumo dao;
    private Adapter adapter;
    private ArrayList<Insumo> lista;
    private Insumo insu;
    Activity act;

    private Button btnGuardar, btnMostrar, btnActualizar, btnEliminar;
    private TextView edTextCodigo, edTextNombre, edTextStock, edTextPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);

        final TextView codigo = (TextView) findViewById(R.id.editTextCodigo);
        final TextView nombre = (TextView) findViewById(R.id.editTNombre);
        final TextView precio = (TextView) findViewById(R.id.editTextPrecio);
        final TextView stock = (TextView) findViewById(R.id.editTextStock);

        dao = new daoInsumo(this);
        adapter = new Adapter(lista, dao, this);

        ListView list = (ListView) findViewById(R.id.lista);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = Integer.parseInt(precio.getText().toString());
                int s = Integer.parseInt(stock.getText().toString());
                try {
                    insu = new Insumo(p, s);
                    dao.insertar(insu);
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}