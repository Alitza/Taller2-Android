package yiseth.alitza.dragonmaid;


import android.content.Context;
import android.content.Intent;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements Observer {


    private Comunicacion c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WifiManager wm = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        WifiManager.MulticastLock multicastLock = wm.createMulticastLock("mydebuginfo");
        multicastLock.acquire();
        setContentView(R.layout.activity_main);

        Async a = new Async();
        a.execute();
        try {
            c = a.get();
            c.addObserver(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(c + "  ................................................................................");

    }


    @Override
    public void update(Observable observable, Object o) {
        if (o instanceof Boolean) {
            Intent i = new Intent(this, Main2Activity.class);
            startActivity(i);
        }
    }


}