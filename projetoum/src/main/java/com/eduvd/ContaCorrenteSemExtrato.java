package com.eduvd;

import java.time.LocalDateTime;

public class ContaCorrenteSemExtrato {
    private int numero;
    private String correntista;
    private double saldo;
    private boolean ativa;
    private Operacao[] extrato;
    private int contador;

    public ContaCorrenteSemExtrato(int numero, String correntista) {
        if (numero < 0) {
            throw new IllegalArgumentException("Número da conta não pode ser negativo.");
        }
        if (correntista == null || correntista.length() < 2) {
            throw new IllegalArgumentException("Correntista não pode ser nulo e deve ter pelo menos dois caracteres.");
        }
        this.numero = numero;
        this.correntista = correntista;
        this.saldo = 0.0;
        this.ativa = true;
        this.extrato = new Operacao[100];
        this.contador = 0;
    }

    public int getNumero() {
        return numero;
    }

    public String getCorrentista() {
        return correntista;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void deposita(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do depósito deve ser positivo.");
        }
        saldo += valor;

        Operacao operacao = new Operacao(valor, "DEPOSITO", LocalDateTime.now());
        extrato[contador] = operacao;
        contador++;
    }

    public void saca(double valor) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do saque deve ser positivo.");
        }
        if (valor >= saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        saldo -= valor;

        Operacao operacao = new Operacao(valor, "SAQUE", LocalDateTime.now());
        extrato[contador] = operacao;
        contador++;
    }

    public void transfere(double valor, ContaCorrenteSemExtrato contaDestino) {
        if (!ativa) {
            throw new IllegalStateException("Operação não permitida: conta inativa.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser positivo.");
        }
        if (valor > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        if (contaDestino == null){
            throw new NullPointerException("A conta desctino não pode ser nula");
        }
        if (!contaDestino.isAtiva()){
            throw new IllegalStateException("Conta destino inativa");
        }
        // Faz a transferencia
        saldo -= valor;
        contaDestino.deposita(valor);

        Operacao operacao = new Operacao(valor, "TRANSFERENCIA", LocalDateTime.now());
        extrato[contador] = operacao;
        contador++;
    }

    public void fecha() {
        if (saldo > 0.0) {
            throw new IllegalArgumentException("A conta ainda tem saldo e não pode ser fechada");
        }
        ativa = false;
    }

    public Operacao[] getExtrato(){
        Operacao[] resultado = new Operacao[contador];
        for(int i = 0; i < contador; i++){
            resultado[i] = extrato[i];
        }
        return resultado;
    }

    public Operacao[] getExtratoMensal(int ano, int mes){
        Operacao[] resultado = new Operacao[100];
        int aux = 0;

        for(int i = 0; i < contador; i++){
            LocalDateTime dataHora = extrato[i].getDataHora();
            if(dataHora.getYear() == ano && dataHora.getMonthValue() == mes){
                resultado[aux] = extrato[i];
                aux++;
            }
        }

        Operacao[] mensal = new Operacao[aux];
        for(int i = 0; i < aux; i++){
            mensal[i] = resultado[i];
        }
        return mensal;
    }

    public String getExtratoFormatado(int ano, int mes){
        Operacao[] operacoesMes = getExtratoMensal(ano, mes);
        String resultado = "";
        for(Operacao operacao : operacoesMes){
            resultado = resultado + operacao.toString() +"\n";
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "numero=" + numero +
                ", correntista='" + correntista + '\'' +
                ", saldo=" + saldo +
                ", ativa=" + ativa +
                '}';
    }
}
