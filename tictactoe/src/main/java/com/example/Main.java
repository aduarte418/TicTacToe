package com.example;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("   BIENVENIDO AL TRES EN RAYA    ");
        System.out.println("=================================\n");

        Scanner scanner = new Scanner(System.in);
        Partida partida = new Partida();

        // Mostrar tablero inicial
        System.out.println(partida);

        // Bucle de juego mientras la partida no haya finalizado
        while (!partida.terminada()) {
            System.out.println("Turno de la ficha: " + partida.getTurnoActual());
            
            int fila = leerCoordenada(scanner, "Introduce la Fila (0, 1 ó 2): ");
            int columna = leerCoordenada(scanner, "Introduce la Columna (0, 1 ó 2): ");

            System.out.println();
            partida.jugar(fila, columna);
            
            // Pintar estado actualizado del tablero tras la jugada
            System.out.println(partida);
        }

        // Determinar resultado final
        Ficha ganador = partida.ganador();
        if (ganador != null) {
            System.out.println("¡ENHORABUENA! Ha ganado la ficha: " + ganador);
        } else {
            System.out.println("¡EMPATE! El tablero está lleno y no hay más movimientos posibles.");
        }

        scanner.close();
    }

    // Método para depurar la entrada de números enteros válidos para las coordenadas
    private static int leerCoordenada(Scanner scanner, String mensaje) {
        int valor = -1;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = scanner.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número entero válido.");
                scanner.next();
            }
        }
        return valor;
    }
}