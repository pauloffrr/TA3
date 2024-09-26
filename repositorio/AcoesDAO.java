package repositorio;

import model.Acao;
import model.Cena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcoesDAO {

    public static Acao findAcaoByComando(Integer idCena, String comando) throws SQLException {
        Connection conn = DatabaseManager.getConnection();
        String sql = "SELECT * FROM acoes WHERE id_cena = ? AND comando = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCena);
        stmt.setString(1, comando);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Acao acao = new Acao();
            acao.setId(rs.getInt("id"));
            acao.setComando(rs.getString("comando"));
            acao.setDescricao(rs.getString("descricao_acao"));
            acao.setProximaCenaId(rs.getInt("id_prox_cena"));
            return acao;
        } else {
            return null;
        }
    }


}