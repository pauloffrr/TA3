import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CenaDAO sceneDAO = new CenaDAO();
        Scanner scanner = new Scanner(System.in);

        List<Cena> cenas = sceneDAO.getAllCenas();
        for (Cena cena : cenas) {
            System.out.println(cena.getDescricao());
            // Aqui você pode adicionar lógica para capturar comandos e avançar nas cenas.
        }

        scanner.close();
    }
}
