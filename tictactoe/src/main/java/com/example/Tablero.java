package com.example;

public class Tablero {

    private char[][] matrizTablero;
    private static final char casillaVacia = ' ';

    // Constructor que crea la matriz e inicializa el tablero vacío
    public Tablero() {
        this.matrizTablero = new char[3][3];
        this.resetear();
    }

    // Método para resetear el tablero
    public void resetear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrizTablero[i][j] = casillaVacia;
            }
        }
    }

    // Método para jugar en una casilla específica del tablero
    public boolean jugar(Ficha.valorFicha ficha, int x, int y) {
        if (ficha == null) {
            return false;
        }
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            return false;
        }
        if (this.matrizTablero[x][y] != casillaVacia) {
            return false;
        }
        this.matrizTablero[x][y] = ficha.name().charAt(0);
        return true;
    }

    // Método para comprobar si el tablero está lleno
    public boolean estaLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.matrizTablero[i][j] == casillaVacia) {
                    return false;
                }
            }
        }
        return true;
    }

    // Métodos para verificar ganador y de qué manera se ha ganado
    public boolean gana(Ficha.valorFicha ficha) {
        if (ficha == null) {
            return false;
        }
        return ganaHorizontal(ficha) || ganaVertical(ficha) || 
               ganaDiagonalDirecta(ficha) || ganaDiagonalIndirecta(ficha);
    }

    private boolean ganaHorizontal(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        for (int i = 0; i < 3; i++) {
            if (this.matrizTablero[i][0] == c && this.matrizTablero[i][1] == c && this.matrizTablero[i][2] == c) {
                return true;
            }
        }
        return false;
    }

    private boolean ganaVertical(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        for (int j = 0; j < 3; j++) {
            if (this.matrizTablero[0][j] == c && this.matrizTablero[1][j] == c && this.matrizTablero[2][j] == c) {
                return true;
            }
        }
        return false;
    }

    private boolean ganaDiagonalDirecta(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        return this.matrizTablero[0][0] == c && this.matrizTablero[1][1] == c && this.matrizTablero[2][2] == c;
    }

    private boolean ganaDiagonalIndirecta(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        return this.matrizTablero[0][2] == c && this.matrizTablero[1][1] == c && this.matrizTablero[2][0] == c;
    }

    // Método toString para representar el tablero
    @Override
    public String toString() {
        String resultado = "-------------\n";
        for (int i = 0; i < 3; i++) {
            resultado = resultado + "| ";
            for (int j = 0; j < 3; j++) {
                resultado = resultado + matrizTablero[i][j] + " | ";
            }
            resultado = resultado + "\n-------------\n";
        }
        return resultado;
    }
}