package Clases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoInsumo {

    private SQLiteDatabase cx;
    private ArrayList<Insumo> lista;
    private Insumo insumo;
    private Context context;
    private String nombreBD = "BDInsumos";
    private String table = "create table if not exists insumo(codigo integer primary key autoincrement, nombre text, precio integer, stock integer)";

    public daoInsumo(Context c) {
        this.context = c;
        cx = context.openOrCreateDatabase(nombreBD, Context.MODE_WORLD_WRITEABLE, null);
        cx.execSQL(table);
    }

    public boolean insertar(Insumo i) {
        return true;
    }

    public boolean eliminar(int codigo) {
        return true;
    }

    public boolean actualizar(Insumo i) {
        return true;
    }

    public ArrayList<Insumo> listar(){
        return lista;
    }

    public Insumo buscar(int codigo){
        return insumo;
    }
}
