import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Academia> academias = new ArrayList<>();
        List<Membro> membros = new ArrayList<>();
        List<Instrutor> instrutores = new ArrayList<>();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Criar Academia");
            System.out.println("2. Criar Membro e Vincular à Academia");
            System.out.println("3. Criar Instrutor e Vincular à Academia"); 
            System.out.println("4. Enviar Notificação");
            System.out.println("5. Visualizar Notificações (Membro)");
            System.out.println("6. Visualizar Notificações (Instrutor)");
            System.out.println("7. Exibir Notificações");
            System.out.println("0. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    limparConsole();
                    Academia.criarAcademia(academias, scanner);
                    break;
                case 2:
                    limparConsole();
                    Membro.criarMembro(academias, membros, scanner);
                    break;
                case 3:
                    limparConsole();
                    Instrutor.criarInstrutor(academias, instrutores, scanner); 
                    break;
                case 4:
                    limparConsole();
                    Academia.enviarAviso(academias, scanner);
                    break;
                case 5:
                    limparConsole();
                    Membro.visualizarAvisos(membros, scanner);
                    break;
                case 6:
                limparConsole();
                    Instrutor.visualizarAvisos(instrutores, scanner);
                    break;
                case 7:
                    limparConsole();
                    Academia.exibirNotificacoesEnviadas(academias);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void limparConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
