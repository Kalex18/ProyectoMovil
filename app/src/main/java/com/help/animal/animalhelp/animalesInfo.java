package com.help.animal.animalhelp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class animalesInfo extends AppCompatActivity {

    ListView listaDato;
    ArrayList<datos> lista;
int id;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);













        setContentView(R.layout.activity_animales_info);

        listaDato=(ListView)findViewById(R.id.lstdatos2);

        lista = new ArrayList<datos>();





        lista.add(new datos(1 ,"Mishifu","gato adonado en calle", R.drawable.perro1));
        lista.add(new datos(2 ,"holas","gato abanado en calle", R.drawable.perro2));
        lista.add(new datos(3 ,"fsdfdsf","gato abando en calle", R.drawable.perro1));
        lista.add(new datos(4 ,"fsdfdsfsd","gato abandonn calle", R.drawable.perro1));



        Adaptador adaptador =new Adaptador(getApplicationContext(),lista);

        listaDato.setAdapter(adaptador);

        listaDato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            datos obj =(datos)parent.getItemAtPosition(position);
                Intent paso =new Intent(getApplicationContext(),detalle.class);
                paso.putExtra("objeto",(Serializable)obj);
                startActivity(paso);


            }

        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.camaraflotante);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(animalesInfo.this, PrincipalPantalla.class);
                startActivity(intent);
            }
        });


    }

    @Override


    protected void onRestart() {
        super.onRestart();

        id++;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();


    if (extras!=null){


    String descripcion = extras.getString("descripcion");

    String titulo = extras.getString("titulo");







    lista.add(new datos(6, titulo, descripcion, R.drawable.perro2));


    Adaptador adaptador = new Adaptador(getApplicationContext(), lista);

    listaDato.setAdapter(adaptador);

    ////////para el acesso a lso detalles
    listaDato.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            datos obj = (datos) parent.getItemAtPosition(position);
            Intent paso = new Intent(getApplicationContext(), detalle.class);
            paso.putExtra("objeto", (Serializable) obj);
            startActivity(paso);


        }

    });

}
    }
}
