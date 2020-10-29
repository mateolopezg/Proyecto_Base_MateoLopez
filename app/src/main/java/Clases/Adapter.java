package Clases;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.w.appmateolopez.R;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    ArrayList<Insumo> lista;
    daoInsumo dao;
    Insumo insu;
    Activity act;

    public Adapter(ArrayList<Insumo> lista, daoInsumo dao, Activity act) {
        this.lista = lista;
        this.dao = dao;
        this.act = act;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Insumo getItem(int i) {
        insu = lista.get(i);
        return null;
    }

    @Override
    public long getItemId(int i) {
        insu = lista.get(i);
        return insu.getCodigo();
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        View v = view;
        if (v==null){
            LayoutInflater li = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.item, null);
        }
        insu = lista.get(posicion);

        TextView codigo = (TextView) v.findViewById(R.id.editTextCodigo);
        TextView nombre = (TextView)v.findViewById(R.id.editTNombre);
        TextView precio = (TextView)v.findViewById(R.id.editTextPrecio);
        TextView stock = (TextView)v.findViewById(R.id.editTextStock);

        Button actualizar = (Button)v.findViewById(R.id.btnEditar);
        Button borrar = (Button)v.findViewById(R.id.btnBorrar);
        Button agregar = (Button)v.findViewById(R.id.btnGuardar);
        Button mostrar = (Button)v.findViewById(R.id.btnMostrar);

        codigo.setText(""+insu.getCodigo());
        nombre.setText(insu.getNombre());
        precio.setText(""+insu.getPrecio());
        stock.setText(""+insu.getStock());

        actualizar.setTag(posicion);
        borrar.setTag(posicion);

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return v;
    }
}
