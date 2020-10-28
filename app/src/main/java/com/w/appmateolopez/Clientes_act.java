package com.w.appmateolopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spnClientes);
        spin2 = (Spinner)findViewById(R.id.spnPlanes);
        edit = (EditText)findViewById(R.id.et1);
        text = (TextView)findViewById(R.id.tv);

        // Recibir el dato.
        // <----
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void Calcular(View v)
    {
        String cliente = spin1.getSelectedItem().toString();  // almaceno selección del spinner.
        String planes = spin2.getSelectedItem().toString();

        Planes plan = new Planes();  // Construir mi objeto.

        int saldo = Integer.parseInt(edit.getText().toString());

        int resultXtreme = saldo - plan.getXtreme();
        int resultMind = saldo - plan.getMindfullnes();

        // Inteligencia Roberto.

        if(cliente.equals("Roberto") && planes.equals("xtreme"))
        {
            text.setText("El precio del plan es: " + resultXtreme);
        }

        if(cliente.equals("Roberto") && planes.equals("mindfullness"))
        {
            text.setText("El precio del plan es: " + resultMind);
        }

        // Inteligencia para Ivan.

        if(cliente.equals("Ivan") && planes.equals("xtreme"))
        {
            text.setText("El precio del plan es: " + resultXtreme);
        }

        if(cliente.equals("Ivan") && planes.equals("mindfullness"))
        {
            text.setText("El precio del plan es: " + resultMind);
        }
    }

}