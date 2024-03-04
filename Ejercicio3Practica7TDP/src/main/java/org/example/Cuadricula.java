package org.example;

import java.util.Random;
import java.util.Scanner;

class Cuadricula {
    private final int TAMANO = 10;
    private int[][] tablero = new int[TAMANO][TAMANO];
    private Random rand = new Random();
    private String climaActual = "soleado";
    private int contadorTurnosLluvia = 0;

    public void actualizarClima() {
        int climaAleatorio = rand.nextInt(3); // 0: soleado, 1: lluvioso, 2: tormentoso
        switch (climaAleatorio) {
            case 0:
                climaActual = "soleado";
                contadorTurnosLluvia = 0; // Restablecer contador de lluvia
                break;
            case 1:
                climaActual = "lluvioso";
                break;
            case 2:
                climaActual = "tormentoso";
                aplicarTormenta();
                contadorTurnosLluvia = 0; // Restablecer contador de lluvia
                break;
        }
        System.out.println("El clima actual es: " + climaActual);
        if ("lluvioso".equals(climaActual)) {
            contadorTurnosLluvia++;
            if (contadorTurnosLluvia == 5) {
                revelarZonaAleatoria();
                contadorTurnosLluvia = 0; // Restablecer para el próximo ciclo
            }
        }
    }

    private void revelarZonaAleatoria() {
        int x = rand.nextInt(TAMANO - 2);
        int y = rand.nextInt(TAMANO - 2);
        System.out.println("Revelando zona debido al clima lluvioso...");
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (tablero[i][j] == 1) {
                    System.out.println("Barco oculto revelado en (" + i + ", " + j + ").");
                }
            }
        }
    }

    private void aplicarTormenta() {
        System.out.println("Tormenta intensa: rayos caen en el tablero.");
        for (int i = 0; i < 9; i++) { // 9 rayos caen en posiciones aleatorias
            int x = rand.nextInt(TAMANO);
            int y = rand.nextInt(TAMANO);
            if (tablero[x][y] == 1) {
                System.out.println("Un rayo ha revelado un barco en (" + x + ", " + y + ").");
            }
        }
    }


    public Cuadricula() {
        // Inicializa el tablero con agua (representado por 0).
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = 0;
            }
        }
    }

    public void colocarBarcosAleatoriamente() {
        // Ejemplo: Coloca 3 barcos de diferentes tamaños.
        colocarBarcoAleatoriamente(5); // Tamaño 5
        colocarBarcoAleatoriamente(4); // Tamaño 4
        colocarBarcoAleatoriamente(3); // Tamaño 3
    }

    private void colocarBarcoAleatoriamente(int longitud) {
        boolean colocado = false;
        while (!colocado) {
            int x = rand.nextInt(TAMANO);
            int y = rand.nextInt(TAMANO);
            boolean horizontal = rand.nextBoolean();

            if (puedeColocarBarco(x, y, longitud, horizontal)) {
                for (int i = 0; i < longitud; i++) {
                    if (horizontal) {
                        tablero[x][y + i] = 1; // Marca como parte de un barco
                    } else {
                        tablero[x + i][y] = 1; // Marca como parte de un barco
                    }
                }
                colocado = true;
            }
        }
    }

    private boolean puedeColocarBarco(int x, int y, int longitud, boolean horizontal) {
        // Implementación de la verificación para colocar el barco
        if (horizontal) {
            if (y + longitud > TAMANO) return false; // Verifica límites horizontales
            for (int i = 0; i < longitud; i++) { // Verifica espacios ocupados
                if (tablero[x][y + i] != 0) return false;
            }
        } else {
            if (x + longitud > TAMANO) return false; // Verifica límites verticales
            for (int i = 0; i < longitud; i++) { // Verifica espacios ocupados
                if (tablero[x + i][y] != 0) return false;
            }
        }
        return true;
    }

    public void imprimirTablero(boolean mostrarBarcos) {
        // Imprimir números de columna en la parte superior
        System.out.print("  "); // Espacio para alinear los números de columna
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < TAMANO; i++) {
            // Imprimir número de fila al inicio de cada fila
            System.out.print(i + " ");
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print(". "); // Agua o espacio no atacado
                } else if (tablero[i][j] == 1) {
                    System.out.print(mostrarBarcos ? "B " : ". "); // Barco, oculto a menos que mostrarBarcos sea true
                } else if (tablero[i][j] == 2) {
                    System.out.print("H "); // Barco atacado
                } else if (tablero[i][j] == 3) {
                    System.out.print("X "); // Ataque fallido en agua
                }
            }
            System.out.println();
        }
    }

    public boolean realizarAtaque(int x, int y) {
        if (x < 0 || x >= TAMANO || y < 0 || y >= TAMANO) {
            System.out.println("Coordenadas fuera de rango.");
            return false; // Coordenadas fuera del rango del tablero.
        }

        if (tablero[x][y] == 1) { // Si hay un barco
            tablero[x][y] = 2; // Marca como barco atacado
            System.out.println("¡Impacto!");
            return true;
        } else if (tablero[x][y] == 0) {
            tablero[x][y] = 3; // Marca como ataque fallido en agua
            System.out.println("Fallaste.");
            return false;
        }

        // Si el ataque es a una casilla ya atacada, no cambia nada
        // Pero informa adecuadamente al usuario sobre el estado de su ataque.
        if (tablero[x][y] == 2) {
            System.out.println("Ya has atacado este barco.");
        } else if (tablero[x][y] == 3) {
            System.out.println("Ya has atacado esta posición.");
        }
        return false;
    }

    public boolean verificarFinJuego() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getClimaActual() {
        return climaActual;
    }

}

