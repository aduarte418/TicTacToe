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

    public boolean gana(Ficha.valorFicha ficha) {
        if (ficha == null) {
            return false;
        }
        return ganaHorizontal(ficha) || ganaVertical(ficha) || 
               ganaDiagonalDirecta(ficha) || ganaDiagonalIndirecta(ficha);
    }

    protected boolean ganaHorizontal(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        for (int i = 0; i < 3; i++) {
            if (this.matrizTablero[i][0] == c && this.matrizTablero[i][1] == c && this.matrizTablero[i][2] == c) {
                return true;
            }
        }
        return false;
    }

    protected boolean ganaVertical(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        for (int j = 0; j < 3; j++) {
            if (this.matrizTablero[0][j] == c && this.matrizTablero[1][j] == c && this.matrizTablero[2][j] == c) {
                return true;
            }
        }
        return false;
    }

    protected boolean ganaDiagonalDirecta(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        return this.matrizTablero[0][0] == c && this.matrizTablero[1][1] == c && this.matrizTablero[2][2] == c;
    }

    protected boolean ganaDiagonalIndirecta(Ficha.valorFicha ficha) {
        if (ficha == null) return false;
        char c = ficha.name().charAt(0);
        return this.matrizTablero[0][2] == c && this.matrizTablero[1][1] == c && this.matrizTablero[2][0] == c;
    }

    // Método toString para representar el tablero visualmente
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------\n");
        for (int i = 0; i < 3; i++) {
            sb.append("| ");
            for (int j = 0; j < 3; j++) {
                sb.append(matrizTablero[i][j]).append(" | ");
            }
            sb.append("\n-------------\n");
        }
        return sb.toString();
    }
}