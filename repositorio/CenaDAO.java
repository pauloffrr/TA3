package repositorio;

import model.Cena;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CenaDAO {


    public static Cena findCenaById(Integer id) throws SQLException {
        Connection conn = DatabaseManager.getConnection();
        String sql = "SELECT * FROM cena WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        if (rs.next()) {
            cena.setId(rs.getInt("id"));
            cena.setDescricao(rs.getString("descricao"));
        }

        return cena;
    }

    public void insertCena(Cena cena) throws SQLException {
        Connection conn = DatabaseManager.getConnection();
        String insert = "INSERT INTO cena(descricao) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(insert);
        ps.setString(1, cena.getDescricao());
        ps.execute();
    }

    public List<Cena> findAll() throws SQLException {
        Connection conn = DatabaseManager.getConnection();
        String sql = "SELECT * FROM cena;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<Cena> cenas = new ArrayList<>();
        while (resultSet.next()) {
            Cena cena = new Cena();
            cena.setId(resultSet.getInt("id"));
            cena.setDescricao(resultSet.getString("descricao"));
            cenas.add(cena);
        }

        return cenas;
    }
}