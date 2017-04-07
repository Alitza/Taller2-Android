package yiseth.alitza.dragonmaid;

import android.os.AsyncTask;

/**
 * Created by prada on 5/04/2017.
 */
public class Async extends AsyncTask<String, String, Comunicacion> {



    @Override
    protected Comunicacion doInBackground(String... strings) {
        Comunicacion com = new Comunicacion();
        Thread t = new Thread(com);
        t.start();
        return com;
    }


}
