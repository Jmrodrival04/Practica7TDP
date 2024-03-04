package org.example;

import java.util.Map;

public class SimulacionDadoIA {
    public static void main(String[] args) {
        DadoIA dado1 = new DadoIA(6);
        DadoIA dado2 = new DadoIA(10);
        DadoIA dado3 = new DadoIA(12);

        int sumaResultados = 0;
        while (sumaResultados < 20) {
            int resultado1 = dado1.lanzar();
            int resultado2 = dado2.lanzar();
            int resultado3 = dado3.lanzar();
            sumaResultados = resultado1 + resultado2 + resultado3;

            System.out.println("Resultados: " + resultado1 + ", " + resultado2 + ", " + resultado3);
            System.out.println("Probabilidades Dado 1: " + dado1.predecirProbabilidad());
            System.out.println("Probabilidades Dado 2: " + dado2.predecirProbabilidad());
            System.out.println("Probabilidades Dado 3: " + dado3.predecirProbabilidad());
        }
    }
}
