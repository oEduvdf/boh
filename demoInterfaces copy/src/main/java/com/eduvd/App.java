public class App{
    public static void imprimeVeiculo(Veiculo veiculo){
        System.out.println(veiculo.toString());
    }
    public static void main(String args[]){
        Carro carro = new Carro("Dudu", "1234", "Toyota", "Prata");
        Caminhao caminhao = new Caminhao(Igol, "2345", "Peugeot", "rosa");
        imprimeVeiculo(carro);
        imprimeVeiculo(caminhao);
    }
}

