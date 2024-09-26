package repositorio;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static Connection connection;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/textadventure",
                    "root",
                    ""
            );
            return connection;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        System.out.println("erro ao conectar");
    } catch (ClassNotFoundException e) {
        System.out.println("erro ao importar");
    }
        return null;
    }
}
