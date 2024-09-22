import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;


public class CenaDAO {
    public List<Cena> getAllCenas() {
        List<Cena> cenas = new ArrayList<>();
        String sql = "SELECT * FROM Cena";

        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descricao = resultSet.getString("descricao");
                cenas.add(new Cena(id, descricao));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cenas;
    }
}
