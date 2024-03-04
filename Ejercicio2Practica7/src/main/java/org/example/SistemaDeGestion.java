package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaDeGestion {
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Libro> librosDisponibles = new ArrayList<>();

    public static void main(String[] args) {
        // Ejemplo de libros
        librosDisponibles.add(new Libro("El Señor de los Anillos", "Fantasía"));
        librosDisponibles.add(new Libro("Fundación", "Ciencia Ficción"));
        librosDisponibles.add(new Libro("1984", "Distopía"));
        librosDisponibles.add(new Libro("El nombre del viento", "Fantasía"));

        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\nGestión de Clientes con Recomendaciones Personalizadas" +
                    "");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Libro a Cliente");
            System.out.println("3. Mostrar Recomendaciones para Cliente");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    agregarCliente(scanner);
                    break;
                case "2":
                    agregarLibroACliente(scanner);
                    break;
                case "3":
                    mostrarRecomendacionesCliente(scanner);
                    break;
                case "4":
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (!opcion.equals("4"));
    }

    private static void agregarCliente(Scanner scanner) {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        Cliente nuevoCliente = new Cliente(nombre, clientes.size() + 1);
        clientes.add(nuevoCliente);
        System.out.println("Cliente agregado exitosamente.");
    }

    private static void agregarLibroACliente(Scanner scanner) {
        System.out.print("Ingrese ID del cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clientes.get(idCliente - 1); // El primer cliente es el 1 y se va sumando 1 por cada cliente agregado

        System.out.println("Libros disponibles:");
        for (int i = 0; i < librosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + librosDisponibles.get(i));
        }
        System.out.print("Ingrese el número del libro para agregar al historial: ");
        int indiceLibro = Integer.parseInt(scanner.nextLine());
        Libro libroSeleccionado = librosDisponibles.get(indiceLibro - 1);

        cliente.agregarLibroHistorial(libroSeleccionado);
        System.out.println("Libro agregado al historial del cliente.");
    }

    private static void mostrarRecomendacionesCliente(Scanner scanner) {
        System.out.print("Ingrese ID del cliente para ver recomendaciones: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        Cliente cliente = clientes.get(idCliente - 1); // El primer cliente es el 1 y se va sumando 1 por cada cliente agregado

        cliente.generarRecomendaciones(librosDisponibles);
        cliente.mostrarRecomendaciones();
    }
}
