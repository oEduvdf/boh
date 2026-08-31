package com.eduvd;

public class App {

    public static void main(String[] args) {
       AlunoNaTurma a1 =  new AlunoTurma("Ze", "POO");
       a1.informaNota(7.0);
       a1.informaNota(8.0);
       AlunoNaTurma a2= new AlunoTurma("Dudu", "ALEST");
       a2.informaNota(8.0);
       a2.informaNota(7.0);

       System.out.println(a1.toString());
       System.out.println("Média do " + a1.getNomeAluno() + " em " + a1.getNomeDisciplina() + ": " +a1.media() + ", " + (a1.aprovado() ? "Aprovado" : Reprovado));
       System.out.println(a2.toString());
       System.out.println("Média do " + a2.getNomeAluno() + " em " + a2.getNomeDisciplina() + ": " +a2.media() + ", " + (a2.aprovado() ? "Aprovado" : Reprovado));

    }
}
