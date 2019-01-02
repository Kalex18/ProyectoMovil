package com.help.animal.animalhelp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class PrincipalPantalla extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    ///// view de la camara
    ImageView imagen;
    Button boton;
    Button CargarIMg;
    ListView listaDato;
    ArrayList<datos> lista;
///////////////////////// views de autentificacion
    int id =0;
    Button enviar ;
    EditText titulo;
    EditText ubicacion;
    EditText descripcion;
    RadioButton rbPerro,rbGato ,rbOtro;
    //indicadores de verdad
    int banderatext =0;


    static final int REQUEST_IMAGE_CAPTURE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {





///////////////////////////////////////////////////////////
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_pantalla);

        imagen = (ImageView) findViewById(R.id.imgCargada);
        boton = (Button) findViewById(R.id.btnFoto);



        if (validarPermiso()){
           boton.setEnabled(true);
        }else{
        boton.setEnabled(false);
        }


        boton = (Button) findViewById(R.id.btnFoto);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamarIntent();
            }
        });

//////////////////////////////////////


        enviar =(Button)findViewById(R.id.btnEnviarU);
        ubicacion = (EditText)findViewById(R.id.txtubicacion);
        descripcion = (EditText)findViewById(R.id.txtdescripcion);
        titulo= (EditText)findViewById(R.id.txtTituloPrin);
        rbPerro= (RadioButton) findViewById(R.id.rbperro);
        rbGato= (RadioButton) findViewById(R.id.rbgato);
        rbOtro= (RadioButton) findViewById(R.id.rbotro);

/////comienza comprobacion
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {
                String mensaje ="faltan campos por completar \n";
            banderatext =0;

                if (rbGato.isChecked()==false &&rbPerro.isChecked()==false&&rbOtro.isChecked()==false){
                    banderatext=1;
                mensaje+="clase de animal no seleccionada\n";

                }


                if (ubicacion.getText().toString().isEmpty()){
                    banderatext=1;
                    mensaje+="ubicacion no designada\n";
                }

                if (descripcion.getText().toString().isEmpty()) {
                    banderatext = 1;
                    mensaje+="descripcion no designada\n";
                }


                if (banderatext==1){

                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    mensaje, Toast.LENGTH_SHORT);

                    toast1.show();
                }
                else {

             insertedDates();







                    // luego de la comprobacion aqui iran los parametros para enviar a la base de datos



                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Enviado", Toast.LENGTH_SHORT);

                    toast1.show();

                    ///se pasa a la pantalla de inicio



                    Intent perdida = new Intent(PrincipalPantalla.this ,animalesInfo.class);
                    startActivity(perdida);



                }

            }



        });

    }
//fin comporbacion


    private boolean validarPermiso() {
            if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M){
                return true;
            }
            if ((checkSelfPermission(CAMERA)==PackageManager.PERMISSION_GRANTED&&(checkSelfPermission(WRITE_EXTERNAL_STORAGE)==PackageManager.PERMISSION_GRANTED))){
            return true;
            }
            if ((shouldShowRequestPermissionRationale(CAMERA))||(shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE))){
                cargarDialogoRecomendacion();
        }else{
               requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 100){
            if (grantResults.length==2 && grantResults[0] ==PackageManager.PERMISSION_GRANTED && grantResults[1] ==PackageManager.PERMISSION_GRANTED){
              boton.setEnabled(true);
            }else {
                solicitarPermisoManual();
            }
        }
    }

    private void solicitarPermisoManual() {

    }

    private void cargarDialogoRecomendacion() {
        AlertDialog.Builder dialogo= new AlertDialog.Builder(PrincipalPantalla.this);
        dialogo.setTitle("Permisos Desactivados");
        dialogo.setMessage("Debe aceptar los permisos para el correcto funcionamiento de la App");

        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,CAMERA},100);
            }
        });
        dialogo.show();
    }

    private void llamarIntent() {
    Intent tomarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
    if (tomarFoto.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(tomarFoto, REQUEST_IMAGE_CAPTURE);
    }
}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
           Bundle extras = data.getExtras();
            Bitmap imgBitmap = (Bitmap) extras.get("data");
            imagen.setImageBitmap(imgBitmap);
        }
        }


//////////////////////////envia los parametros a la activity animales info
        private void insertedDates(){

////////////////////////


            Intent intent = new Intent(PrincipalPantalla.this,animalesInfo.class);

            intent.putExtra("descripcion",descripcion.getText().toString());
            intent.putExtra("titulo",titulo.getText().toString());
            intent.putExtra("imagen",titulo.getText().toString());
            startActivity(intent);



        }







    }


