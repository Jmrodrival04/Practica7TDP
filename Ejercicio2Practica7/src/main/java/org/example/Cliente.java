package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cliente {
    private String nombre;
    private int id;
    private List<Libro> historialDeCompras;
    private List<Libro> recomendaciones;

    public Cliente(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.historialDeCompras = new ArrayList<>();
        this.recomendaciones = new ArrayList<>();
    }

    // Agregar libro al historial de compras
    public void agregarLibroHistorial(Libro libro) {
        // Asegurarse de que el libro no se agregue duplicado
        if (!historialDeCompras.contains(libro)) {
            this.historialDeCompras.add(libro);
        }
    }

    // Generar recomendaciones basadas en el historial de compras
    public void generarRecomendaciones(List<Libro> librosDisponibles) {
        Map<String, Integer> generoContador = new HashMap<>();

        // Contar la frecuencia de géneros en el historial de compras
        for (Libro libroComprado : historialDeCompras) {
            String genero = libroComprado.getGenero();
            generoContador.put(genero, generoContador.getOrDefault(genero, 0) + 1);
        }

        // Identificar el género más frecuente
        String generoPopular = generoContador.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        if (generoPopular != null) {
            // Filtrar libros del mismo género no comprados aún
            this.recomendaciones = librosDisponibles.stream()
                    .filter(libro -> libro.getGenero().equals(generoPopular) && !historialDeCompras.contains(libro))
                    .collect(Collectors.toList());
        }
    }

    // Mostrar recomendaciones
    public void mostrarRecomendaciones() {
        if (recomendaciones.isEmpty()) {
            System.out.println("No hay recomendaciones disponibles para " + nombre + ".");
            return;
        }

        System.out.println("Recomendaciones para " + nombre + ":");
        for (Libro libro : recomendaciones) {
            System.out.println(libro.getTitulo() + " - " + libro.getGenero());
        }
    }

    // Getters para acceder a la información del cliente desde fuera de la clase
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public List<Libro> getHistorialDeCompras() {
        return new ArrayList<>(historialDeCompras);
    }

    public List<Libro> getRecomendaciones() {
        return new ArrayList<>(recomendaciones);
    }
}
