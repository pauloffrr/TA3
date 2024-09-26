package model;

public class Acao {
    private int id;
    private String descricao;
    private String comando;  // Adicione este campo
    private int proximaCenaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public int getProximaCenaId() {
        return proximaCenaId;
    }

    public void setProximaCenaId(int proximaCenaId) {
        this.proximaCenaId = proximaCenaId;
    }

    @Override
    public String toString() {
        return "Acao{" +
                "id=" + id +
                ", descricao_acao='" + descricao + '\'' +
                ", comando='" + comando + '\'' +
                ", id_proxima_cena=" + proximaCenaId +
                '}';
    }
}