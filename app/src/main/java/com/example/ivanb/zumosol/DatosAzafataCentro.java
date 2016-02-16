package com.example.ivanb.zumosol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DatosAzafataCentro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_azafata_centro);
        siguienteLayout();
    }

    private void siguienteLayout() {
        Button continuar1 = (Button) findViewById(R.id.continuar1);
        continuar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DatosAzafataCentro.this, PantallaInicial.class));
            }
        });
    }
}
