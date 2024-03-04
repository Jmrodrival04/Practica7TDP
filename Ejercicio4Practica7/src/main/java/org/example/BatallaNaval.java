package org.example;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;


public class BatallaNaval {
    private CuadriculaConIA cuadriculaJugador = new CuadriculaConIA();
    private CuadriculaConIA cuadriculaIA = new CuadriculaConIA();
    private Scanner scanner = new Scanner(System.in);

    public BatallaNaval() {
        System.out.println("Iniciando Batalla Naval con IA...");
        cuadriculaJugador.colocarBarcosAleatoriamente();
        cuadriculaIA.colocarBarcosAleatoriamente();
    }

    public void iniciarJuego() {
        System.out.println("¡Bienvenido a Batalla Naval avanzada con IA!");
        boolean turnoJugador = true;

        while (!cuadriculaJugador.verificarFinJuego() && !cuadriculaIA.verificarFinJuego()) {
            if (turnoJugador) {
                System.out.println("\nTu tablero:");
                cuadriculaJugador.imprimirTablero(true); // Muestra los barcos del jugador
                System.out.println("\nTablero de la IA:");
                cuadriculaIA.imprimirTablero(false); // No muestra los barcos de la IA

                System.out.print("Ingresa coordenadas de ataque (x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                boolean resultado = cuadriculaIA.realizarAtaque(x, y);
                System.out.println(resultado ? "¡Impacto!" : "Fallaste.");
            } else {
                System.out.println("\nTurno de la IA:");
                int[] coordenadas = cuadriculaIA.decidirAtaque();
                boolean resultado = cuadriculaJugador.realizarAtaque(coordenadas[0], coordenadas[1]);
                System.out.println(resultado ? "La IA te ha impactado en (" + coordenadas[0] + "," + coordenadas[1] + ")." : "La IA falló en (" + coordenadas[0] + "," + coordenadas[1] + ").");
            }
            turnoJugador = !turnoJugador;
        }

        if (cuadriculaJugador.verificarFinJuego()) {
            System.out.println("La IA ha ganado.");
        } else {
            System.out.println("¡Felicidades, has ganado!");
        }
    }

    public static void main(String[] args) {
        BatallaNaval juego = new BatallaNaval();
        juego.iniciarJuego();
    }
}
