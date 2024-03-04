package org.example;
import java.util.Random;
import java.util.Scanner;

public class BatallaNaval {
    private Cuadricula cuadriculaJugador = new Cuadricula();
    private Cuadricula cuadriculaIA = new Cuadricula();
    private Scanner scanner = new Scanner(System.in);
    private Random rand = new Random();

    public BatallaNaval() {
        System.out.println("Iniciando Batalla Naval...");
        cuadriculaJugador.colocarBarcosAleatoriamente(); // Coloca barcos para el jugador automáticamente
        cuadriculaIA.colocarBarcosAleatoriamente(); // Coloca barcos para la IA automáticamente
    }


    public void iniciarJuego() {
        System.out.println("¡Bienvenido a Batalla Naval con efectos climáticos!");
        boolean turnoJugador = true;

        while (!cuadriculaJugador.verificarFinJuego() && !cuadriculaIA.verificarFinJuego()) {
            if (turnoJugador) {
                System.out.println("\nTurno del Jugador");
                cuadriculaIA.imprimirTablero(false);
                System.out.print("Ingresa coordenadas de ataque (x y): ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                boolean resultado = cuadriculaIA.realizarAtaque(x, y);
                if (resultado) {
                    System.out.println("¡Impacto!");
                } else {
                    System.out.println("Fallaste.");
                }
            } else {
                System.out.println("\nTurno de la IA");
                int x = rand.nextInt(10);
                int y = rand.nextInt(10);
                boolean resultado = cuadriculaJugador.realizarAtaque(x, y);
                if (resultado) {
                    System.out.println("La IA te ha impactado.");
                }
            }
            turnoJugador = !turnoJugador;
            cuadriculaJugador.actualizarClima();
            cuadriculaIA.actualizarClima();
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
