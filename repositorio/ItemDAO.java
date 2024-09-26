package repositorio;

import model.Cena;
import model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static Item findItemById(Integer id) {
        return new Item();
    }

    public static List<Item> findItemByScene(Cena cena) throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "select * from item i where id_cena = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cena.getId());
        ResultSet resultSet = ps.executeQuery();

        List<Item> items = new ArrayList<>();
        while (resultSet.next()) {
            Item item = new Item();
            item.setId(resultSet.getInt("id"));
            item.setNome(resultSet.getString("nome"));
            item.setDescricao(resultSet.getString("descricao"));

            Integer Cena = resultSet.getInt("id_cena");
            Cena cenaAtual = CenaDAO.findCenaById(Cena);

            item.setCena(cenaAtual);

            Cena = resultSet.getInt("id_prox_cena");
            Cena proxCena = CenaDAO.findCenaById(Cena);
            item.setCena(proxCena);

            items.add(item);

        }
        return items;
    }
}
