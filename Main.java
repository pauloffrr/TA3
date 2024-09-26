import com.google.gson.Gson;
import model.Acao;
import model.Cena;
import model.SaveManager;
import repositorio.AcoesDAO;
import repositorio.CenaDAO;
import repositorio.ItemDAO;
import repositorio.SaveDAO;
import model.Item;
import spark.Spark;

import java.sql.SQLException;
import java.util.List;

import static spark.Spark.post;

public class Main {
    public static final Gson gson = new Gson();

    public static void main(String[] args) {
        try {

            SaveManager saveManager = SaveDAO.newGame();
            String json = gson.toJson(saveManager);

            Spark.get("/", (req, res) -> json);

            Spark.get("/cena/:id", (req, res) -> {
                Integer idCena = Integer.parseInt(req.params(":id"));
                String cenaJson = gson.toJson(CenaDAO.findCenaById(idCena));
                return cenaJson;
            });

            Spark.post("/comando/:descricao", (req, res) -> {
                String descricao = req.queryParams("descricao_acao");
                Integer idCenaAtual = Integer.parseInt(req.queryParams("id"));

                AcoesDAO acaoDAO = new AcoesDAO();
                Acao acao = acaoDAO.findAcaoByComando(idCenaAtual, descricao);

                if (acao != null) {
                    Cena proximaCena = CenaDAO.findCenaById(acao.getProximaCenaId());
                    return gson.toJson(proximaCena);
                } else {
                    return "Comando inválido ou ação não encontrada.";
                }
            });

            Cena cena = CenaDAO.findCenaById(1);
            System.out.println(cena.toString());

            List<Item> items = ItemDAO.findItemByScene(cena);
            System.out.println("Itens: " + items);

            System.out.println("save");
            saveManager = SaveDAO.newGame();
            System.out.println(saveManager.getCenaAtual().getDescricao());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}