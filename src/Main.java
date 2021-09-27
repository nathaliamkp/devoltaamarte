import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DefinidorDeEquipamento definidorDeEquipamento = new DefinidorDeEquipamento();

        System.out.println("Informe as coordenadas máximas do planalto que será explorado");
        System.out.println("x: ");
        int x = scanner.nextInt();
        System.out.println("y: ");
        int y = scanner.nextInt();


        Planalto planalto = new Planalto(new Coordenadas(x, y));
        List<EquipamentoExplorador> exploradores = new ArrayList<>();

        System.out.println("Quantos equipamentos de exploração serão utilizados?");
        int quantidadeExploradores = scanner.nextInt();
        for (int i = 0; i < quantidadeExploradores; i++){
            System.out.println("Informe as coordenadas e a direcão da posicao inicial do seu equipamento de exploracao");

            System.out.println("x: ");
            int xE = scanner.nextInt();

            System.out.println("y: ");
            int yE = scanner.nextInt();

            System.out.println("Direção: ");
            String vazio = scanner.nextLine();
            String direcao = scanner.nextLine().toUpperCase();

            System.out.println("Informe a trajetória que ele realizará: ");
            String trajetoria = scanner.nextLine().toUpperCase();

            exploradores.add(definidorDeEquipamento.enviarEquipamentoExplorador(xE, yE, trajetoria, direcao, planalto));

        }

        Exploracao exploracao = new Exploracao(planalto, exploradores);
        exploracao.explora();

        scanner.close();
    }
}
