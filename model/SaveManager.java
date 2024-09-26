package model;

public class SaveManager {
    private Integer id;
    private Cena cenaAtual;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cena getCenaAtual() {
        return cenaAtual;
    }

    public void setCenaAtual(Cena cenaAtual) {
        this.cenaAtual = cenaAtual;
    }

    @Override
    public String toString() {
        return "SaveManager{" +
                "id=" + id +
                ", cenaAtual=" + cenaAtual +
                '}';
    }
}