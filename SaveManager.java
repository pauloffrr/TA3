import org.json.JSONObject;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class SaveManager {

    private static final String SAVE_FILE = "savegame.json";

    // Método para salvar o progresso do jogo
    public static void saveGame(int cenaId, String[] itens) {
        // Criando um objeto JSON
        JSONObject saveData = new JSONObject();
        saveData.put("cena_atual", cenaId); // Salvando a cena atual

        // Salvando o inventário
        JSONObject inventario = new JSONObject();
        for (String item : itens) {
            inventario.put(item, true); // Indicando que o item foi coletado
        }
        saveData.put("inventario", inventario); // Salvando o inventário no JSON

        // Salvando no arquivo
        try (FileWriter file = new FileWriter(SAVE_FILE)) {
            file.write(saveData.toString());
            System.out.println("Jogo salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para carregar o progresso do jogo
    public static void loadGame() {
        try (FileReader reader = new FileReader(SAVE_FILE)) {
            // Lendo o arquivo e convertendo para JSONObject
            char[] buffer = new char[1024];
            int length = reader.read(buffer);
            String jsonString = new String(buffer, 0, length);
            JSONObject saveData = new JSONObject(jsonString);

            // Recuperando os dados
            int cenaId = saveData.getInt("cena_atual");
            JSONObject inventario = saveData.getJSONObject("inventario");

            System.out.println("Cena atual: " + cenaId);
            System.out.println("Itens no inventário:");
            for (String key : inventario.keySet()) {
                System.out.println("- " + key);
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar o jogo!");
            e.printStackTrace();
        }
    }
}

