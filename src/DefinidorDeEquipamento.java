import java.util.Optional;
import java.util.Scanner;

public class DefinidorDeEquipamento {

    public DefinidorDeEquipamento() {
    }

    public EquipamentoExplorador enviarEquipamentoExplorador(int x, int y, String trajetoria, String direcao, Planalto planalto){

        if (verificarTotalDeMovimentos(trajetoria) <= Sonda.maximoDeMovimentos) {
            try {
                return new Sonda(new Posicao(new Coordenadas(x, y), direcao), trajetoria, planalto);
            } catch (Exception e) {
                throw new RuntimeException("Para a exploração ser viável, todos equipamentos precisam possuir posições iniciais válidas.");
            }
        }throw new RuntimeException("No momento só podemos enviar sondas. E sondas só se movimentam 10 vezes");

    }

    private int verificarTotalDeMovimentos(String trajetoria){
        int totalMovimentos = 0;
        char temp;
        for (int i = 0; i < trajetoria.length(); i++) {
            temp = trajetoria.charAt(i);
            if (temp == 'M')
                totalMovimentos++;
        }
        return totalMovimentos;
    }


}
