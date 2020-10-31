package com.w.appmateolopez;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Clases.DataBaseHelper;

public class Insu_act extends AppCompatActivity {

    private DataBaseHelper db;
    private EditText stock, codigo, nombre, precio;
    private Button btnMostrar, btnEditar, btnBorrar, btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insu_act);
        db = new DataBaseHelper(this);

        codigo = (EditText) findViewById(R.id.editTextCodigo);
        nombre = (EditText) findViewById(R.id.editTNombre);
        precio = (EditText) findViewById(R.id.editTextPrecio);
        stock = (EditText) findViewById(R.id.editTextStock);

        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
    }

    public void insertar(View v) {
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String c = codigo.getText().toString();
                    String p = precio.getText().toString();
                    String s = stock.getText().toString();
                    String n = nombre.getText().toString();
                    boolean isInsert = db.insert(c, n, p, s);
                    if (isInsert == true)
                        Toast.makeText(Insu_act.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Insu_act.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void viewAll(View v) {
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Cursor res = db.getAllData();
                    if (res.getCount() == 0) {
                        showMessage("Error", "No hay datos");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Código : " + res.getString(0) + "\n");
                        buffer.append("Nombre : " + res.getString(1) + "\n");
                        buffer.append("Precio : " + res.getString(2) + "\n");
                        buffer.append("Stock : " + res.getString(3) + "\n\n");
                    }
                    showMessage("Data ", buffer.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void update(View v){
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String c = codigo.getText().toString();
                    String p = precio.getText().toString();
                    String s = stock.getText().toString();
                    String n = nombre.getText().toString();
                    boolean isUpdate = db.update(c, n, p, s );
                    if (isUpdate)
                        Toast.makeText(Insu_act.this, "Data Update", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Insu_act.this, "Data Not Update", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }

    public void delete(View v){
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String c = codigo.getText().toString();
                    Integer deleteRows = db.delete(c);
                    if (deleteRows > 0)
                        Toast.makeText(Insu_act.this, "Deleted Data", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Insu_act.this, "Data Not Deleted", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

}