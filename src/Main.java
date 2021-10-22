import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Exploracao exploracao = new Exploracao();

        System.out.println("Informe as coordenadas máximas do planalto que será explorado");
        //System.out.println("x: ");
        //int x = scanner.nextInt();
        //System.out.println("y: ");
        //int y = scanner.nextInt();
        exploracao.criaPlanalto(5, 5);

        List<Movel> moveis = new ArrayList<>();
        exploracao.criaLista(moveis);

        System.out.println("Quantos equipamentos de exploração serão utilizados?");
//        int quantidadeExploradores = scanner.nextInt();
        int quantidadeExploradores = 2;
        for (int i = 0; i < quantidadeExploradores; i++){
            System.out.println("Informe as coordenadas e a direção da posição inicial do seu equipamento de exploração");

            System.out.println("x: ");
            int xE = scanner.nextInt();

            System.out.println("y: ");
            int yE = scanner.nextInt();

            System.out.println("Direção: ");
            String vazio = scanner.nextLine();
            String direcao = scanner.nextLine().toUpperCase();

            System.out.println("Informe a trajetória que ele realizará: ");
            String trajetoria = scanner.nextLine().toUpperCase();

            exploracao.adiciona(exploracao.defineMovel(xE, yE, trajetoria, direcao));

        }

        exploracao.exibeResultadoExplorcao();

        scanner.close();
    }
}
