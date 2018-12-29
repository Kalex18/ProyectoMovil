package com.help.animal.animalhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar ;
    Button boton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton1 = (Button) findViewById(R.id.btnIngreso);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, navegacion.class);
                startActivity(intent);
            }
        });

        toolbar =(Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    }
    public void entrar (View view){
        Intent entrar = new Intent(this ,PrincipalPantalla.class);
        startActivity(entrar);
    }

    public void entrar2 (View view){
        Intent entrar2 = new Intent(this ,animalesInfo.class);
        startActivity(entrar2);
    }
}
