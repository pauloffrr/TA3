package model;

public class Item {
    private Integer id;
    private String nome;
    private String descricao;
    private String itemPego;
    private String getMensagem;
    private String useMensagem;
    private Cena Cena;
    private Cena ProxCena;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getItemPego() {
        return itemPego;
    }

    public void setItemPego(String itemPego) {
        this.itemPego = itemPego;
    }

    public String getGetMensagem() {
        return getMensagem;
    }

    public void setGetMensagem(String getMensagem) {
        this.getMensagem = getMensagem;
    }

    public String getUseMensagem() {
        return useMensagem;
    }

    public void setUseMensagem(String useMensagem) {
        this.useMensagem = useMensagem;
    }

    public Cena getCena() {
        return Cena;
    }

    public void setCena(Cena cena) {
        Cena = cena;
    }

    public model.Cena getProxCena() {
        return ProxCena;
    }

    public void setProxCena(Cena proxCena) {
        ProxCena = proxCena;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", itemPego='" + itemPego + '\'' +
                ", getMensagem='" + getMensagem + '\'' +
                ", useMensagem='" + useMensagem + '\'' +
                ", Cena=" + Cena +
                ", ProxCena=" + ProxCena +
                '}';
    }


}
