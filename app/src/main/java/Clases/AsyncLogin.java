package Clases;

import android.os.AsyncTask;

import com.w.appmateolopez.Menu_act;

import Clases.IComunicacion;

public class AsyncLogin extends AsyncTask<Object, Void, Boolean> {
    private IComunicacion comm;

    public AsyncLogin(IComunicacion comm){ this.comm = comm; }


    /**
     * @deprecated
     */
    @Override
    protected void onPreExecute() {
        comm.toggleProgressBar(true);
    }

    /**
     * @param objects
     * @deprecated
     */
    @Override
    protected Boolean doInBackground(Object... objects) {
        try {
            Thread.sleep((int) objects[2]);
            String user = (String) objects[0];
            String pass = (String) objects[1];
            if (user.equals("admin") && pass.equals("admin")){
                return true;
            }else{
                return false;
            }
        }catch (InterruptedException ie){
            ie.printStackTrace();
        }
        return false;
    }

    /**
     * @param aBoolean
     * @deprecated
     */
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean){
            this.comm.lanzarActividad(Menu_act.class);
            this.comm.showMessage("Logeado correctamente");
            this.comm.toggleProgressBar(false);
        }else{
            this.comm.showMessage("Datos Incorrectos");
        }
    }
}
