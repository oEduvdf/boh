package com.igor;

public class ContaApp{
    public static void main(String[] args){
        ContaCorrenteSemExtrato conta1 = new ContaCorrenteSemExtrato(1, "Igor Machado");
        ContaCorrenteSemExtrato conta2 = new ContaCorrenteSemExtrato(2, "Neymar JR");

            conta1.deposita(1000);
            conta1.saca(200);
            conta1.transfere(300, conta2);
            conta2.deposita(500);

            System.out.println("Saldo conta 1: " + conta1.getSaldo());
            System.out.println("Saldo conta 2: " + conta2.getSaldo());

            System.out.println("Extrato Completo");
            for (Operacao operacao : conta1.getExtrato()) {
            System.out.println(operacao.toString());
            }

            System.out.println("Extrato Completo");
            for (Operacao operacao : conta2.getExtrato()) {
            System.out.println(operacao.toString());
            }

            int anoAtual = java.time.LocalDate.now().getYear();
            int mesAtual = java.time.LocalDate.now().getMonthValue();

            System.out.println("Operações do mês "+mesAtual+"/"+anoAtual);
            for (Operacao operacao : conta1.getExtratoMensal(anoAtual, mesAtual)) {
            System.out.println(operacao.toString());
            }

            System.out.println("Extrato Formatado");
            System.out.println(conta2.getExtratoFormatado(anoAtual, mesAtual));
    }
}

