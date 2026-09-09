public class Veiculo{
    private String proprietario;
    private String placa;

    public Veiculo(String proprietario, String placa) {
        this.proprietario = proprietario;
        this.placa = placa;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
