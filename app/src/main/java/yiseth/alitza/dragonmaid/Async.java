package yiseth.alitza.dragonmaid;

import android.os.AsyncTask;

/**
 * Created by prada on 5/04/2017.
 */
public class Async extends AsyncTask<String, String, String> {


    @Override
    protected String doInBackground(String... strings) {
        Comunicacion c = new Comunicacion();
        Thread t = new Thread(c);
        t.start();
        return null;
    }
}
