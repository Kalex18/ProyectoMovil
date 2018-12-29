package com.help.animal.animalhelp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detalle extends AppCompatActivity {
TextView  titulo;
TextView detalle;
ImageView foto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        foto = (ImageView) findViewById(R.id.imgdetalle);
        titulo=(TextView) findViewById(R.id.txtTituloDe);
        detalle=(TextView) findViewById(R.id.txtDetalleDe);

  datos obj = (datos) getIntent().getExtras().getSerializable("objeto");
  titulo.setText(obj.getDetalle());
detalle.setText(obj.getDetalle());
foto.setImageResource(obj.getImagen());



    }
}
