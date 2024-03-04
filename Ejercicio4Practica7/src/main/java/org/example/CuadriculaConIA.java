package org.example;


import java.util.LinkedList;
import java.util.Queue;

class CuadriculaConIA extends Cuadricula {
    private Queue<int[]> ataquesPendientes = new LinkedList<>();

    @Override
    public void colocarBarcosAleatoriamente() {
        super.colocarBarcosAleatoriamente();
    }

    public int[] decidirAtaque() {
        if (!ataquesPendientes.isEmpty()) {
            return ataquesPendientes.poll();
        }

        int x, y;
        do {
            x = rand.nextInt(TAMANO);
            y = rand.nextInt(TAMANO);
        } while (tablero[x][y] != 0); // Evita repetir ataques en la misma posición
        return new int[]{x, y};
    }

    @Override
    public boolean realizarAtaque(int x, int y) {
        boolean resultado = super.realizarAtaque(x, y);
        if (resultado) {
            // Si es un acierto, planifica los siguientes ataques alrededor del golpe
            int[][] direcciones = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : direcciones) {
                int nuevoX = x + dir[0];
                int nuevoY = y + dir[1];
                if (nuevoX >= 0 && nuevoX < TAMANO && nuevoY >= 0 && nuevoY < TAMANO && tablero[nuevoX][nuevoY] == 0) {
                    ataquesPendientes.offer(new int[]{nuevoX, nuevoY});
                }
            }
        }
        return resultado;
    }
}
