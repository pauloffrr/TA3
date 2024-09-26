package repositorio;

import model.SaveManager;

import java.sql.*;

public class SaveDAO {

    public static SaveManager newGame() throws SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "INSERT INTO save(cena_atual_id) VALUES (1)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        SaveManager saveManager = new SaveManager();
        if(generatedKeys.next()){
            saveManager.setId(generatedKeys.getInt(1));
            saveManager.setCenaAtual(CenaDAO.findCenaById(1));
        }
        return saveManager;
    }
}