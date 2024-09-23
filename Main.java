import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CenaDAO cenaDAO = new CenaDAO();
        AcoesDAO acoesDAO = new AcoesDAO(); // DAO para as ações
        SaveDAO saveDAO = new SaveDAO();    // DAO para o save
        Scanner scanner = new Scanner(System.in);

        // Perguntar ao jogador se quer carregar um jogo salvo
        System.out.println("Deseja carregar o jogo salvo? (s/n)");
        String resposta = scanner.nextLine();

        int idCenaAtual = 1; // Cena inicial padrão

        if (resposta.equalsIgnoreCase("s")) {
            Integer saveId = saveDAO.getCenaById(); // Pega o id da cena salva
            if (saveId != null) {
                idCenaAtual = saveId;
                System.out.println("Jogo carregado. Continuando da cena " + idCenaAtual);
            } else {
                System.out.println("Nenhum jogo salvo encontrado. Iniciando um novo jogo.");
            }
        }

        boolean jogoAtivo = true;

        while (jogoAtivo) {
            // Obter a cena atual
            Cena cenaAtual = cenaDAO.getCenaById(idCenaAtual);
            if (cenaAtual == null) {
                System.out.println("Cena não encontrada!");
                break;
            }

            // Exibir a descrição da cena
            System.out.println(cenaAtual.getDescricao());

            // Obter as ações possíveis para essa cena
            List<Acao> acoes = acoesDAO.getAcoesByCenaId(idCenaAtual);
            if (acoes.isEmpty()) {
                System.out.println("Não há ações disponíveis para esta cena.");
                break;
            }

            // Exibir as opções de ação
            System.out.println("Escolha uma ação:");
            for (int i = 0; i < acoes.size(); i++) {
                System.out.println((i + 1) + ". " + acoes.get(i).getDescricao());
            }

            // Capturar a escolha do jogador
            int escolha = scanner.nextInt();
            if (escolha < 1 || escolha > acoes.size()) {
                System.out.println("Escolha inválida.");
                continue;
            }

            // Avançar para a próxima cena com base na ação escolhida
            Acao acaoEscolhida = acoes.get(escolha - 1);
            idCenaAtual = acaoEscolhida.getProximaCenaId();

            // Oferecer ao jogador a opção de salvar o jogo
            System.out.println("Deseja salvar o jogo? (s/n)");
            scanner.nextLine();  // Consumir a nova linha pendente
            String salvarJogo = scanner.nextLine();
            if (salvarJogo.equalsIgnoreCase("s")) {
                saveDAO.salvarProgresso(idCenaAtual); // Salva o ID da cena atual
                System.out.println("Jogo salvo!");
            }

            // Verificar se o jogo terminou (exemplo: ID de cena final = -1)
            if (idCenaAtual == -1) {
                System.out.println("Fim do jogo.");
                jogoAtivo = false;
            }
        }

        scanner.close();
    }
}
