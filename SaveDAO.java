import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveDAO {

    public void salvarProgresso(int cenaId) {
        String sql = "INSERT INTO Save (id_cena) VALUES (?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, cenaId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int carregarProgresso() {
        String sql = "SELECT id_cena FROM Save ORDER BY id DESC LIMIT 1";
        int cenaId = 0;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                cenaId = rs.getInt("id_cena");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cenaId;
    }

    public int getCenaById() {
        String sql = "SELECT id_cena FROM Save ORDER BY id DESC LIMIT 1";
        int cenaId = 0;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                cenaId = rs.getInt("id_cena");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cenaId;
    }

    // Método para pegar o ID do último save (opcional para controle)
    public int getUltimoSaveId() {
        String sql = "SELECT id FROM Save ORDER BY id DESC LIMIT 1";
        int saveId = 0;

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                saveId = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return saveId;
    }
}



