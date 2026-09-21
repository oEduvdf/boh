public interface Caixa<T>{
    Long Id();
    void Guarda(T object) throws CaixaOcupadaException;
    T consulta();
    T retira();
    String descricaoConteudo();
}

public void Consulta(){
    if(T.length>0) return T;
    else return null;
}

public void 
