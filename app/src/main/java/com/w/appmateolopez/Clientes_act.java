package com.w.appmateolopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spinnersClientes, spinnersPlanes;
    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spinnersClientes = (Spinner)findViewById(R.id.spinnersClientes);
        spinnersPlanes = (Spinner)findViewById(R.id.spinnersPlanes);
        editText = (EditText)findViewById(R.id.editTextMontoPagar);
        textView = (TextView)findViewById(R.id.textViewMontoFinal);

        // Recibir el dato.
        // <----
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);

        spinnersClientes.setAdapter(adapt);
        spinnersPlanes.setAdapter(adapts);
    }

    public void Calcular(View v)
    {
        String cliente = spinnersClientes.getSelectedItem().toString();  // almaceno selección del spinner.
        String planes = spinnersPlanes.getSelectedItem().toString();

        Planes plan = new Planes();  // Construir mi objeto.
        try {
            int saldo =Integer.parseInt(editText.getText().toString());

                int resultXtreme = saldo - plan.getXtreme();
                int resultMind = saldo - plan.getMindfullnes();

                // Inteligencia Roberto.

                if(cliente.equals("Roberto") && planes.equals("xtreme"))
                {
                    textView.setText("El precio del plan es: " + resultXtreme);
                }

                if(cliente.equals("Roberto") && planes.equals("mindfullness"))
                {
                    textView.setText("El precio del plan es: " + resultMind);
                }

                // Inteligencia para Ivan.

                if(cliente.equals("Ivan") && planes.equals("xtreme"))
                {
                    textView.setText("El precio del plan es: " + resultXtreme);
                }

                if(cliente.equals("Ivan") && planes.equals("mindfullness"))
                {
                    textView.setText("El precio del plan es: " + resultMind);
                }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //metodo para validar si es un valor numerico
    public  boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    //metodo para validar si editext esta vacio
    public  boolean isEmpty(EditText campo){
        String dato = campo.getText().toString().trim();
        if(TextUtils.isEmpty(dato)){
            campo.setError("Campo Requerido");
            campo.requestFocus();
            return true;
        }
        else{
            return false;
        }
    }
}