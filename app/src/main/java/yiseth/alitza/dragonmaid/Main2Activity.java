package yiseth.alitza.dragonmaid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.concurrent.ExecutionException;

public class Main2Activity extends AppCompatActivity {


    private ImageButton boton1;
    private ImageButton boton2;
    private ImageButton boton3;
    private ImageButton boton4;

    private Comunicacion c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        boton1 = (ImageButton) findViewById(R.id.imageButton);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncEnviar a = new AsyncEnviar();
            a.execute(new Obstaculo(1));
            }
        });

        boton2 = (ImageButton) findViewById(R.id.imageButton2);
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncEnviar a = new AsyncEnviar();
             a.execute(new Obstaculo(2));
            }
        });


        boton3 = (ImageButton) findViewById(R.id.imageButton3);
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncEnviar a = new AsyncEnviar();
             a.execute(new Obstaculo(3));
            }
        });

        boton4 = (ImageButton) findViewById(R.id.imageButton4);
        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncEnviar a = new AsyncEnviar();
             a.execute(new Obstaculo(4));
            }
        });

    }
}
