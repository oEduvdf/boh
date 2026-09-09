public class Caminhao extends Veiculo{
    private String marca;
    private String cor;

    public Caminhao(String proprietario, String placa, String marca, String cor){
        super(proprietario,placa);
        this.marca = marca;
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    @Override
    public String toString(){
        return super.toString() + ", marca = " + marca + ", cor = " + cor;
    }
}
