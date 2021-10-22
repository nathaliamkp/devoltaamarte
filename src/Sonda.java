import java.util.List;

public class Sonda extends EquipamentoExplorador {

     final static int MAXIMODEMOVIMENTOS = 10;
     boolean ativa = true;


    public Sonda(Posicao posicao, String trajetoria){
        super(posicao, trajetoria);
    }


    public boolean validaSonda(String trajetoria){
        return (verificarTotalDeMovimentos(trajetoria) <= this.MAXIMODEMOVIMENTOS);
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

    @Override
    public void colide() {
        inativaSonda();
        System.out.println("Houve uma colisão e essa Sonda foi desativada antes de cumprir toda a sua trajetória");
    }

    @Override
    public void cumpraTrajetoria(Planalto planalto, List<Movel> moveis) {
        super.cumpraTrajetoria(planalto, moveis);
        inativaSonda();
    }

    private void inativaSonda(){
        this.ativa = false;
    }
}
