package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Cuadricula {
    protected final int TAMANO = 10;
    protected int[][] tablero = new int[TAMANO][TAMANO];
    protected Random rand = new Random();

    public Cuadricula() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                tablero[i][j] = 0; // Inicializa el tablero con agua (0).
            }
        }
    }

    public void colocarBarcosAleatoriamente() {
        // Coloca barcos de tamaño 5, 4 y 3 en el tablero
        colocarBarco(5);
        colocarBarco(4);
        colocarBarco(3);
    }

    private void colocarBarco(int size) {
        boolean placed = false;
        while (!placed) {
            int x = rand.nextInt(TAMANO);
            int y = rand.nextInt(TAMANO);
            placed = (rand.nextBoolean() ? tryPlaceBoatHorizontal(x, y, size) : tryPlaceBoatVertical(x, y, size));
        }
    }

    private boolean tryPlaceBoatHorizontal(int x, int y, int size) {
        if (y + size > TAMANO) return false;
        for (int i = 0; i < size; i++) {
            if (tablero[x][y + i] != 0) return false;
        }
        for (int i = 0; i < size; i++) {
            tablero[x][y + i] = 1; // Coloca el barco horizontalmente
        }
        return true;
    }

    private boolean tryPlaceBoatVertical(int x, int y, int size) {
        if (x + size > TAMANO) return false;
        for (int i = 0; i < size; i++) {
            if (tablero[x + i][y] != 0) return false;
        }
        for (int i = 0; i < size; i++) {
            tablero[x + i][y] = 1; // Coloca el barco verticalmente
        }
        return true;
    }

    public boolean realizarAtaque(int x, int y) {
        if (x < 0 || x >= TAMANO || y < 0 || y >= TAMANO) {
            System.out.println("Ataque fuera de los límites.");
            return false; // Ataque fuera de los límites del tablero
        }

        if (tablero[x][y] == 1) {
            tablero[x][y] = 2; // Marca como golpe a un barco
            System.out.println("¡Acierto!");
            return true;
        } else if (tablero[x][y] == 0) {
            tablero[x][y] = 3; // Marca como agua
            System.out.println("Fallaste.");
        } else {
            System.out.println("Esta posición ya fue atacada.");
        }
        return false;
    }

    public boolean verificarFinJuego() {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == 1) return false; // Quedan barcos sin hundir
            }
        }
        return true; // Todos los barcos han sido hundidos
    }

    public void imprimirTablero(boolean mostrarBarcos) {
        System.out.print("  ");
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < TAMANO; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < TAMANO; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print(". "); // Agua o espacio no atacado
                } else if (tablero[i][j] == 1) {
                    System.out.print(mostrarBarcos ? "B " : ". "); // Barco no atacado, visible solo si se elige mostrar
                } else if (tablero[i][j] == 2) {
                    System.out.print("X "); // Golpe a barco
                } else if (tablero[i][j] == 3) {
                    System.out.print("O "); // Fallo, agua atacada
                }
            }
            System.out.println();
        }
    }
}
