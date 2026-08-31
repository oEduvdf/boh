import java.util.ArrayList;
public class AlunoNaTurma {
    private String nomeAluno;
    private String nomeDisciplina;
    private CalculadoraDeNotas calculadoraDeNotas;
    private ArrayList<Double> notas;

    public AlunoNaTurma(String nomeAluno, String nomeDisciplina, CalculadoraDeNotas calculadoraDeNotas){
        this.nomeAluno = nomeAluno;
        this.nomeDisciplina = nomeDisciplina;
        this.calculadoraDeNotas = calculadoraDeNotas;
        notas = new ArrayList<>();
    }

    public String getNomeAluno(){
        return nomeAluno;
    }
    public String getNomeDisciplina(){
        return nomeDisciplina;
    }

    public Arrayits<Double> getNota(){
        return notas;
    }
    public void informaNota(double nota){
        notas.add(nota);
    }
    public double media(){
        double acum = 0.0;
        for(double nota : notas){
            acum+=nota;
        }
        return acum / notas.size();
    }
    public boolean aprovado(){
        return media() >= 7.0;
    }
    public String toString(){
        return ("Aluno: " + nomeAluno + ", Disciplina: " + nomeDisciplina + ", Notas: " + notas.toString());
    }
}
