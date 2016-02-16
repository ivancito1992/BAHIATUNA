package com.example.ivanb.zumosol;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DatosZumos extends AppCompatActivity {

    int countClasico = 0;
    int countAntiox = 0;
    int countOrganico = 0;
    int countPrisma = 0;
    int countRojo = 0;
    int countVerde = 0;
    int countNaranja = 0;

    String zumoClasico = "Clasico";
    String zumoAntiox = "Antioxidante";
    String zumoOrganico = "Organico";
    String zumoPrisma = "Prisma";
    String zumoRojo = "Veggie Rojo";
    String zumoVerde = "Veggie Verde";
    String zumoNaranja = "Veggie Naranja";


    Button clasicoSum, antioxSum, organicoSum, prismaSum, rojoSum, verdeSum, naranjaSum;
    Button clasicoRes, antioxRes, organicoRes, prismaRes, rojoRes, verdeRes, naranjaRes;

    TextView clasico, antiox, organico, prisma, rojo, verde, naranja;
    private DataBaseZumosol manager;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_zumos);
        manager = new DataBaseZumosol(this);


        clasico = (TextView) findViewById(R.id.clasicoCount);
        antiox = (TextView) findViewById(R.id.antioxCount);
        organico = (TextView) findViewById(R.id.organicoCount);
        prisma = (TextView) findViewById(R.id.prismaCount);
        rojo = (TextView) findViewById(R.id.rojoCount);
        verde = (TextView) findViewById(R.id.verdeCount);
        naranja = (TextView) findViewById(R.id.naranjaCount);

        clasicoSum = (Button) findViewById(R.id.clasicoSumar);
        clasicoSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countClasico++;
                clasico.setText(Integer.toString(countClasico));
            }
        });

        clasicoRes = (Button) findViewById(R.id.clasicoRestar);
        clasicoRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countClasico > 0) {
                    countClasico--;
                    clasico.setText(Integer.toString(countClasico));
                }
            }
        });

        antioxSum = (Button) findViewById(R.id.antioxSumar);
        antioxSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countAntiox++;
                antiox.setText(Integer.toString(countAntiox));
            }
        });

        antioxRes = (Button) findViewById(R.id.antioxRestar);
        antioxRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countAntiox > 0) {
                    countAntiox--;
                    antiox.setText(Integer.toString(countAntiox));
                }
            }
        });

        organicoSum = (Button) findViewById(R.id.organicoSumar);
        organicoSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countOrganico++;
                organico.setText(Integer.toString(countOrganico));
            }
        });

        organicoRes = (Button) findViewById(R.id.organicoRestar);
        organicoRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countOrganico > 0) {
                    countOrganico--;
                    organico.setText(Integer.toString(countOrganico));
                }
            }
        });

        prismaSum = (Button) findViewById(R.id.prismaSumar);
        prismaSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countPrisma++;
                prisma.setText(Integer.toString(countPrisma));
            }
        });

        prismaRes = (Button) findViewById(R.id.prismaRestar);
        prismaRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countPrisma > 0) {
                    countPrisma--;
                    prisma.setText(Integer.toString(countPrisma));
                }
            }
        });

        rojoSum = (Button) findViewById(R.id.rojoSumar);
        rojoSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countRojo++;
                rojo.setText(Integer.toString(countRojo));
            }
        });

        rojoRes = (Button) findViewById(R.id.rojoRestar);
        rojoRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countRojo > 0) {
                    countRojo--;
                    rojo.setText(Integer.toString(countRojo));
                }
            }
        });

        verdeSum = (Button) findViewById(R.id.verdeSumar);
        verdeSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countVerde++;
                verde.setText(Integer.toString(countVerde));
            }
        });

        verdeRes = (Button) findViewById(R.id.verdeRestar);
        verdeRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countVerde > 0) {
                    countVerde--;
                    verde.setText(Integer.toString(countVerde));
                }
            }
        });

        naranjaSum = (Button) findViewById(R.id.naranjaSumar);
        naranjaSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countNaranja++;
                naranja.setText(Integer.toString(countNaranja));
            }
        });

        naranjaRes = (Button) findViewById(R.id.naranjaResta);
        naranjaRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countNaranja > 0) {
                    countNaranja--;
                    naranja.setText(Integer.toString(countNaranja));
                }
            }
        });



        guardarYsiguienteLayout();
    }
    private void guardarYsiguienteLayout() {
        Button continuar = (Button) findViewById(R.id.continuar5);
        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.insertarZumos(zumoClasico, String.valueOf(countClasico));
                manager.insertarZumos(zumoAntiox, String.valueOf(countAntiox));
                manager.insertarZumos(zumoOrganico, String.valueOf(countOrganico));
                manager.insertarZumos(zumoPrisma, String.valueOf(countPrisma));
                manager.insertarZumos(zumoRojo, String.valueOf(countRojo));
                manager.insertarZumos(zumoVerde, String.valueOf(countVerde));
                manager.insertarZumos(zumoNaranja, String.valueOf(countNaranja));
                startActivity(new Intent(DatosZumos.this, Preguntas1.class));
            }
        });
    }
}
