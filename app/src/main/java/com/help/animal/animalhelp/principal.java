package com.help.animal.animalhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class principal extends AppCompatActivity {


    Button enviar ;
    EditText ubicacion;
    EditText descripcion;
    ImageView imagen ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar);

 enviar =(Button)findViewById(R.id.btnEnviarU);
 ubicacion = (EditText)findViewById(R.id.txtubicacion);
 descripcion = (EditText)findViewById(R.id.txtdescripcion);


    }



    public void Ayuda (View view){
        Intent ayuda= new Intent(this , Ayuda.class);
        startActivity(ayuda);
    }
    public void perdida (View view){
        Intent perdida = new Intent(this ,perdido.class);
        startActivity(perdida);

    }

}
