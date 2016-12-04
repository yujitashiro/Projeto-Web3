package br.com.web3.models;

public class Vaga {

   private long id;
   private String setor;
   private String numeroSetor;
   private boolean ocupado;
   Carro carro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNumeroSetor() {
        return numeroSetor;
    }

    public void setNumeroSetor(String numeroSetor) {
        this.numeroSetor = numeroSetor;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
