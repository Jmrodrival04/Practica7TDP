package org.example;

class Libro {
    String titulo;
    String genero;

    public Libro(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return titulo + " (" + genero + ")";
    }
}
