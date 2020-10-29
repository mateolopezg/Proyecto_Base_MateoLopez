package com.w.appmateolopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Insumos_act extends AppCompatActivity {

    public Button btnGuardar, btnMostrar, btnActualizar, btnEliminar;
    public TextView edTextCodigo, edTextNombre, edTextStock, edTextPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos_act);

        btnActualizar   = (Button)findViewById(R.id.btnActualizar);
        btnEliminar     = (Button)findViewById(R.id.btnEliminar);
        btnGuardar      = (Button)findViewById(R.id.btnGuardar);
        btnMostrar      = (Button)findViewById(R.id.btnMostrar);
    }
}