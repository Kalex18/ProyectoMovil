package com.help.animal.animalhelp;

import java.io.Serializable;

public class datos  implements Serializable {

    private int id;
    private String Titulo;
    private String  Detalle;
    private int Imagen;

    public datos(int id, String titulo, String detalle, int imagen) {
        this.id = id;
        Titulo = titulo;
        Detalle = detalle;
        Imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDetalle() {

        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }
}
