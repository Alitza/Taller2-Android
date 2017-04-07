package yiseth.alitza.dragonmaid;

import android.os.AsyncTask;

/**
 * Created by prada on 7/04/2017.
 */
public class AsyncEnviar extends AsyncTask<Object, String, Comunicacion> {

    @Override
    protected Comunicacion doInBackground(Object... objects) {


        Comunicacion c = new Comunicacion();
        Thread t = new Thread(c);
        t.start();
c.enviarObjeto(objects);

        return c;
    }
}
