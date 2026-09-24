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
        return (actual == valorFicha.X) ? valorFicha.O : valorFicha.X;
    }

    // Método toString
    @Override
    public String toString() {
        return valor != null ? valor.name() : "";
    }
}


