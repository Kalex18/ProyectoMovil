package com.help.animal.animalhelp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.help.animal.animalhelp.R;

import java.util.List;

public class Adaptador  extends BaseAdapter {

    Context contexto;
    List<datos> ListaObjetos;


    public Adaptador(Context contexto, List<datos> listaObjetos)
    {
        this.contexto = contexto;
        ListaObjetos = listaObjetos;
    }


    @Override

    public int getCount() {
        return ListaObjetos.size(); //retorna la cantidad de elementos de la lista
    }

    @Override

    public Object getItem(int position) {

        return ListaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {

        return ListaObjetos.get(position).getId();
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View vista = convertView;

        LayoutInflater inflate = LayoutInflater.from(contexto);

        vista = inflate.inflate(R.layout.itenlistview,null);


        ImageView imagen = (ImageView) vista.findViewById(R.id.imgmasccota);
        TextView titulo =(TextView) vista.findViewById(R.id.txtTituloview);
        TextView detalle =(TextView) vista.findViewById(R.id.txtDescrpcionview);

        titulo.setText(ListaObjetos.get(position).getTitulo().toString());
        detalle.setText(ListaObjetos.get(position).getDetalle().toString());
        imagen.setImageResource(ListaObjetos.get(position).getImagen());

        return vista;
    }
}
