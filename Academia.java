import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Academia {
    private String nome;
    private List<Observer> membros = new ArrayList<>(); // Lista de observadores (membros e instrutores)
    private List<String> notificacoesEnviadas = new ArrayList<>(); // Lista de notificações enviadas
    List<Academia> academias = new ArrayList<>(); // Talvez essa lista seja desnecessária

    // Construtor para criar uma instância de Academia com um nome
    public Academia(String nome) {
        this.nome = nome;
    }

    // Método para adicionar um membro ou instrutor à lista de observadores
    public void adicionarMembro(Observer membro) {
        membros.add(membro);
    }

    // Método para adicionar um instrutor à lista de observadores
    public void adicionarInstrutor(Observer instrutor) {
        membros.add(instrutor);
    }

    // Método para notificar todos os membros e instrutores com um aviso
    public void notificarMembros(String aviso) {
        for (Observer membro : membros) {
            membro.receberAviso(nome, aviso); // Chama o método receberAviso de cada observador
        }
        notificacoesEnviadas.add(aviso); // Registra o aviso nas notificações enviadas
    }

    // Método para obter a lista de notificações enviadas
    public List<String> getNotificacoesEnviadas() {
        return notificacoesEnviadas;
    }

    // Método para obter a lista de observadores (membros e instrutores)
    public List<Observer> getMembros() {
        return membros;
    }

    // Método para obter o nome da academia
    public String getNome() {
        return nome;
    }

    // Método estático para criar uma academia e adicioná-la à lista de academias
    public static void criarAcademia(List<Academia> academias, Scanner scanner) {
        System.out.print("Digite o nome da academia: ");
        String nomeAcademia = scanner.nextLine();
        Academia academia = new Academia(nomeAcademia);
        academias.add(academia);
        System.out.println("Academia " + nomeAcademia + " criada com sucesso!");
    }

    // Método estático para enviar um aviso a todos os observadores em uma academia
    public static void enviarAviso(List<Academia> academias, Scanner scanner) {
        if (academias.isEmpty()) {
            System.out.println("Crie pelo menos uma academia antes de enviar um aviso.");
        } else {
            System.out.print("Digite o nome da academia para enviar o aviso: ");
            String nomeAcademiaAviso = scanner.nextLine();
            for (Academia academia : academias) {
                if (academia.getNome().equals(nomeAcademiaAviso)) {
                    System.out.print("Digite o aviso a ser enviado: ");
                    String aviso = scanner.nextLine();
                    academia.notificarMembros(aviso); // Notifica todos os membros e instrutores na academia
                    System.out.println("Aviso enviado com sucesso.");
                    break;
                }
            }
        }
    }

    // Método estático para exibir notificações enviadas para membros e instrutores
    public static void exibirNotificacoesEnviadas(List<Academia> academias) {
        System.out.println("Notificações enviadas para membros e instrutores:");
    
        for (Academia academia : academias) {
            String academiaNome = academia.getNome();
            System.out.println("\nAcademia: " + academiaNome);
    
            for (Observer membro : academia.getMembros()) {
                if (membro instanceof Membro) { // Verifica se é um membro
                    Membro aluno = (Membro) membro;
                    System.out.println("\nMembro: " + aluno.getNome());
                    List<String> notificacoes = aluno.getAvisosRecebidos();
    
                    if (!notificacoes.isEmpty()) {
                        System.out.println("Notificações recebidas:");
    
                        for (String notificacao : notificacoes) {
                            System.out.println("- Aviso: " + notificacao);
                        }
                    }
                } else if (membro instanceof Instrutor) { // Verifique se é um instrutor
                    Instrutor instrutor = (Instrutor) membro;
                    System.out.println("\nInstrutor: " + instrutor.getNome());
                    List<String> notificacoes = instrutor.getAvisosRecebidos();
    
                    if (!notificacoes.isEmpty()) {
                        System.out.println("Notificações recebidas:");
    
                        for (String notificacao : notificacoes) {
                            System.out.println("- Aviso: " + notificacao);
                        }
                    }
                }
            }
        }
    }    
}
