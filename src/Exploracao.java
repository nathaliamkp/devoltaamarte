import java.util.List;

public class Exploracao {

    private Planalto planalto;
    private List<EquipamentoExplorador> exploradores;

    public Exploracao(Planalto planalto, List<EquipamentoExplorador> exploradores) {
        this.planalto = planalto;
        this.exploradores = exploradores;
    }

    public void explora() {
        exploradores.forEach(EquipamentoExplorador -> {
            try {
                EquipamentoExplorador.cumprirTrajetoria(planalto);
            } catch (Exception e) {
                throw new RuntimeException("A exploração não pode acontecer, pois um dos equipamentos possui algum dado inválido");
            }
        });
        System.out.println("Posição final do(s) equipamento(s): ");
        exploradores.forEach(EquipamentoExplorador -> System.out.println(EquipamentoExplorador.dadosPosicao()));
    }

}
