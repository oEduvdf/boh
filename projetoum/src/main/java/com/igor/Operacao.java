package com.igor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Operacao {
    private double valor;
    private String tipo;
    private LocalDateTime dataHora;

    public Operacao(double valor, String tipo, LocalDateTime dataHora){
        this.valor = valor;
        this.tipo = tipo;
        this.dataHora = dataHora;
    }

    public double getValor(){
        return valor;
    }

    public String getTipo(){
        return tipo;
    }

    public LocalDateTime getDataHora(){
        return dataHora;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return dataHora.format(formatter) + " - " + tipo + " - " + valor;
    }
}
