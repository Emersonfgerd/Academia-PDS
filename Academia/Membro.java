import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// A classe Membro implementa a interface Observer para receber avisos da Academia.
class Membro implements Observer {
    private String nome; // Armazena o nome do membro
    private Academia academia; // Mantém uma referência à academia à qual o membro está vinculado
    private List<String> avisosRecebidos = new ArrayList<>(); // Armazena os avisos recebidos

    // Construtor da classe Membro para criar um novo membro e vinculá-lo a uma academia.
    public Membro(String nome, Academia academia) {
        this.nome = nome; // Inicializa o campo "nome" com o valor passado como argumento
        this.academia = academia; // Inicializa o campo "academia" com a academia passada como argumento

        academia.adicionarMembro(this); // Adiciona este membro à lista de membros da academia
    }

    // Método para receber um aviso da academia.
    public void receberAviso(String academiaNome, String aviso) {
        System.out.println("Aviso recebido da academia " + academiaNome + ": " + aviso);
        avisosRecebidos.add(aviso); // Adiciona o aviso à lista de avisos recebidos
    }

    // Método para obter o nome do membro.
    public String getNome() {
        return nome;
    }

    // Método para obter a lista de avisos recebidos.
    public List<String> getAvisosRecebidos() {
        return avisosRecebidos;
    }

    // Método estático para visualizar avisos de membros.
    public static void visualizarAvisos(List<Membro> membros, Scanner scanner) {
        if (membros.isEmpty()) {
            System.out.println("Crie pelo menos um membro antes de visualizar os avisos.");
        } else {
            System.out.print("Digite o nome do membro para visualizar os avisos: ");
            String nomeMembroAvisos = scanner.nextLine();
            Membro membroEncontrado = null;
            // Procura o membro com o nome inserido.
            for (Membro membro : membros) {
                if (membro.getNome().equalsIgnoreCase(nomeMembroAvisos)) {
                    membroEncontrado = membro;
                    break;
                }
            }
            if (membroEncontrado != null) {
                System.out.println("Nome do Membro: " + membroEncontrado.getNome());
                membroEncontrado.visualizarAvisos(); // Chama o método de visualização de avisos do membro
            } else {
                System.out.println("Membro não encontrado.");
            }
        }
    }

    // Método estático para criar um membro e vinculá-lo a uma academia.
    public static void criarMembro(List<Academia> academias, List<Membro> membros, Scanner scanner) {
        if (academias.isEmpty()) {
            System.out.println("Crie pelo menos uma academia antes de adicionar membros.");
        } else {
            System.out.print("Digite o nome do membro: ");
            String nomeMembro = scanner.nextLine();
            System.out.println("Escolha a academia à qual vincular o membro:");
            for (int i = 0; i < academias.size(); i++) {
                System.out.println(i + 1 + ". " + academias.get(i).getNome());
            }
            int escolhaAcademia = scanner.nextInt();
            scanner.nextLine();
            if (escolhaAcademia >= 1 && escolhaAcademia <= academias.size()) {
                Academia academiaEscolhida = academias.get(escolhaAcademia - 1);
                Membro membro = new Membro(nomeMembro, academiaEscolhida);
                membros.add(membro);
                System.out.println("Membro " + nomeMembro + " vinculado à academia " + academiaEscolhida.getNome() + ".");
            } else {
                System.out.println("Escolha de academia inválida.");
            }
        }
    }

    // Método para visualizar os avisos do membro.
    public void visualizarAvisos() {
        System.out.println("Avisos recebidos por " + nome + ":");
        for (String aviso : avisosRecebidos) {
            System.out.println(aviso);
        }
    }

    // Método para obter a academia à qual o membro está vinculado.
    public Academia getAcademia() {
        return academia;
    }
}
