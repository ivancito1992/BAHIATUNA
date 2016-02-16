package com.example.ivanb.zumosol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class Preguntas2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas_2);
        siguienteLayout();
    }

    private void siguienteLayout() {
        Button continuar = (Button) findViewById(R.id.continuar3);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Preguntas2.this, Preguntas3.class));
            }
        });
    }
}
