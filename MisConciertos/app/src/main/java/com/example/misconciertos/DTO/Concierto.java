package com.example.misconciertos.DTO;

public class Concierto {

    private String artista;
    private String fecha;
    private String genero;
    private int valorEntrada;
    private String calificacion;

    public Concierto(String artista, String fecha, String genero, int valorEntrada, String calificacion) {
        this.artista = artista;
        this.fecha = fecha;
        this.genero = genero;
        this.valorEntrada = valorEntrada;
        this.calificacion = calificacion;
    }

    public Concierto() {
        this.artista = artista;
        this.fecha = fecha;
        this.genero = genero;
        this.valorEntrada = valorEntrada;
        this.calificacion = calificacion;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Concierto: " + artista + ", fecha " + fecha + ", valor: "+valorEntrada +", valoración: "+calificacion;
    }
}
