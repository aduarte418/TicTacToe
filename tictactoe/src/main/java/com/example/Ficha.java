package com.example;

public class Ficha {

    public enum valorFicha {
        X, O
    }

    private valorFicha valor;

    // Constructor vacío
    public Ficha() {
    }

    // Constructor que recibe un valor de Ficha
    public Ficha(valorFicha valor) {
        this.valor = valor;
    }

    // Métodos get y set
    public valorFicha getValor() {
        return valor;
    }

    public void setValor(valorFicha valor) {
        this.valor = valor;
    }

    // Método para pasar al siguiente turno 
    public valorFicha siguiente(valorFicha actual) {
        if (actual == valorFicha.X) {
            return valorFicha.O;
        } else {
            return valorFicha.X;
        }
    }

    // Método toString
    @Override
    public String toString() {
        if (valor != null) {
            return valor.name();
        } else {
            return "";
        }
    }
}


