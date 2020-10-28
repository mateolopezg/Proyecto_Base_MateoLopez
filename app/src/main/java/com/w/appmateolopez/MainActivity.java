package com.w.appmateolopez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Clases.AsyncLogin;
import Clases.IComunicacion;

public class MainActivity extends AppCompatActivity implements IComunicacion {

    private ProgressBar progressBar;
    private Button btnLogin;
    private TextView nombre, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        btnLogin    = (Button)findViewById(R.id.btnLogin);
        nombre      = (TextView)findViewById(R.id.editTextNombre);
        password    = (TextView)findViewById(R.id.editTextPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AsyncLogin(MainActivity.this).execute(nombre.getText().toString(), password.getText().toString(), 3000); // ejecuta mi tarea asíncrona.
            }
        });
    }

    @Override
    public void toggleProgressBar(boolean status) {
        if (status){
            progressBar.setVisibility(View.VISIBLE);
        } else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this, tipoActividad);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}