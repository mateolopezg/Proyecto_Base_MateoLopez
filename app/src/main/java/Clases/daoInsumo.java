package Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class daoInsumo {

    private SQLiteDatabase cx;
    private ArrayList<Insumo> lista = new ArrayList<Insumo>();
    private Insumo insumo;
    private Context context;
    private String nombreBD = "BDInsumos";
    private String table = "create table if not exists insumo(codigo integer primary key autoincrement, nombre text, precio integer, stock integer)";

    public daoInsumo(Context c) {
        this.context = c;
        cx = context.openOrCreateDatabase(nombreBD, Context.MODE_PRIVATE, null);
        cx.execSQL(table);
    }

    public boolean insertar(Insumo i) {
        ContentValues container = new ContentValues();
        container.put("nombre", i.getNombre());
        container.put("precio", i.getPrecio());
        container.put("stock", i.getStock());
        return (cx.insert("insumo", null, container))>0;
    }

    public boolean eliminar(int codigo) {
        return true;
    }

    public boolean actualizar(Insumo i) {
        return true;
    }

    public ArrayList<Insumo> listar() {
        lista.clear();
        Cursor cursor = cx.rawQuery("select * from insumo", null);
        if(cursor != null && cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                lista.add(new Insumo(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        cursor.getInt(3)));
            }while(cursor.moveToNext());
        }
        return lista;
    }

    public Insumo buscar(int posicion) {
        Cursor cursor = cx.rawQuery("select * from insumo", null);
        cursor.moveToPosition(posicion);
        insumo = new Insumo(cursor.getInt(0),
                cursor.getString(1),
                cursor.getInt(2),
                cursor.getInt(3));
        return insumo;
    }
}
