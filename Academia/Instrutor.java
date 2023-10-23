import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Instrutor implements Observer {
    private String nome;
    private List<String> avisosRecebidos = new ArrayList<>();

    public Instrutor(String nome, Academia academia) {
        this.nome = nome;

        academia.adicionarInstrutor(this); 
    }

    public void receberAviso(String academiaNome, String aviso) {
        System.out.println("Aviso recebido da academia " + academiaNome + ": " + aviso);
        avisosRecebidos.add(aviso);
    }

    public String getNome() {
        return nome;
    }

    public List<String> getAvisosRecebidos() {
        return avisosRecebidos;
    }

    public static void criarInstrutor(List<Academia> academias, List<Instrutor> instrutores, Scanner scanner) {
        if (academias.isEmpty()) {
            System.out.println("Crie pelo menos uma academia antes de adicionar instrutores.");
        } else {
            System.out.print("Digite o nome do instrutor: ");
            String nomeInstrutor = scanner.nextLine();

            System.out.println("Escolha a academia à qual vincular o instrutor:");
            for (int i = 0; i < academias.size(); i++) {
                System.out.println(i + 1 + ". " + academias.get(i).getNome());
            }

            int escolhaAcademia = scanner.nextInt();
            scanner.nextLine();

            if (escolhaAcademia >= 1 && escolhaAcademia <= academias.size()) {
                Academia academiaEscolhida = academias.get(escolhaAcademia - 1);
                Instrutor instrutor = new Instrutor(nomeInstrutor, academiaEscolhida);
                instrutores.add(instrutor);
                System.out.println("Instrutor " + nomeInstrutor + " vinculado à academia " + academiaEscolhida.getNome() + ".");
            } else {
                System.out.println("Escolha de academia inválida.");
            }
        }
    }

    public static void visualizarAvisos(List<Instrutor> instrutores, Scanner scanner) {
        if (instrutores.isEmpty()) {
            System.out.println("Não existem instrutores para visualizar os avisos.");
        } else {
            System.out.print("Digite o nome do instrutor para visualizar os avisos: ");
            String nomeInstrutorAvisos = scanner.nextLine();
            Instrutor instrutorEncontrado = null;
            for (Instrutor instrutor : instrutores) {
                if (instrutor.getNome().equalsIgnoreCase(nomeInstrutorAvisos)) {
                    instrutorEncontrado = instrutor;
                    break;
                }
            }
            if (instrutorEncontrado != null) {
                System.out.println("Nome do Instrutor: " + instrutorEncontrado.getNome());
                instrutorEncontrado.visualizarAvisos();
            } else {
                System.out.println("Instrutor não encontrado.");
            }
        }
    }
    
    public void visualizarAvisos() {
        System.out.println("Avisos recebidos por " + nome + ":");
        for (String aviso : avisosRecebidos) {
            System.out.println(aviso);
        }
    }
}
