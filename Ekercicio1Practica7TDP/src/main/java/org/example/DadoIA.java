package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DadoIA {
    private int caras;
    private Map<Integer, Integer> historialLanzamientos;
    private Map<Integer, Double> probabilidades;
    private Random random;

    public DadoIA(int caras) {
        this.caras = caras;
        this.historialLanzamientos = new HashMap<>();
        this.probabilidades = new HashMap<>();
        this.random = new Random();

        // Inicializar el historial y las probabilidades
        for (int i = 1; i <= caras; i++) {
            this.historialLanzamientos.put(i, 0);
            this.probabilidades.put(i, 1.0 / caras);
        }
    }

    public int lanzar() {
        int resultado = random.nextInt(caras) + 1;
        historialLanzamientos.put(resultado, historialLanzamientos.get(resultado) + 1);
        recalcularProbabilidades();
        return resultado;
    }

    private void recalcularProbabilidades() {
        int totalLanzamientos = historialLanzamientos.values().stream().mapToInt(Integer::intValue).sum();

        for (Map.Entry<Integer, Integer> entry : historialLanzamientos.entrySet()) {
            int cara = entry.getKey();
            int frecuencia = entry.getValue();
            double nuevaProbabilidad = (double) frecuencia / totalLanzamientos;
            probabilidades.put(cara, nuevaProbabilidad);
        }
    }

    public Map<Integer, Double> predecirProbabilidad() {
        return new HashMap<>(probabilidades);
    }
}
