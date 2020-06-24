package com.example.petagram;

public class Mascota {
    private String nombre;
    private int  cantidadRaiting;
    private Boolean like;
    private int foto;

    public Mascota(int foto, String nombre, int cantidadRaiting, Boolean like){
        this.cantidadRaiting = cantidadRaiting;
        this.foto = foto;
        this.like = like;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadRaiting() {
        return cantidadRaiting;
    }

    public void setCantidadRaiting(int cantidadRaiting) {
        this.cantidadRaiting = cantidadRaiting;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
