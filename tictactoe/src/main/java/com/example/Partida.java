package com.example;

public class Partida {

    private Tablero tablero;
    private Ficha.valorFicha turnoActual;

    // Constructor que inicializa una nueva partida con su tablero
    public Partida() {
        this.tablero = new Tablero();
        this.turnoActual = Ficha.valorFicha.X;
    }

    // Método jugar de Partida
    public void jugar(int x, int y) {
        if (terminada()) {
            System.out.println("La partida ya ha finalizado. No se pueden realizar más movimientos.");
            return;
        }

        Ficha.valorFicha fichaActual = this.turnoActual;
        boolean exito = tablero.jugar(fichaActual, x, y);
        if (exito) {
            // Si la jugada actual no es ganadora, cambiar turno
            if (!this.tablero.gana(fichaActual)) {
                if (this.turnoActual == Ficha.valorFicha.X) {
                    this.turnoActual = Ficha.valorFicha.O;
                } else {
                    this.turnoActual = Ficha.valorFicha.X;
                }
            }
        } else {
            System.out.println("No se puede colocar la ficha en (" + x + ", " + y + "): casilla ocupada o posición no válida.");
        }
    }

    // Método que recupera el turno actual
    public Ficha.valorFicha getTurnoActual() {
        return turnoActual;
    }

    // Método que comprueba si la partida ha terminado (hay ganador o el tablero está lleno)
    public boolean terminada() {
        return ganador() != null || tablero.estaLleno();
    }

    // Método que devuelve la Ficha que ha ganado (X u O), o null si no hay ganador
    public Ficha ganador() {
        if (this.tablero.gana(Ficha.valorFicha.X)) {
            return new Ficha(Ficha.valorFicha.X);
        }
        if (this.tablero.gana(Ficha.valorFicha.O)) {
            return new Ficha(Ficha.valorFicha.O);
        }
        return null;
    }

    // Reinicia la partida reseteando el tablero y el turno
    public void resetear() {
        this.tablero.resetear();
        this.turnoActual = Ficha.valorFicha.X;
    }

    public Tablero getTablero() {
        return tablero;
    }

    // Método toString para pintar la partida
    @Override
    public String toString() {
        return "=== JUGUEMOS ===\n" + tablero.toString();
    }
}