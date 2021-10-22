import java.util.Collections;
import java.util.List;

public class Exploracao {

    private Planalto planalto;
    private List<Movel> moveis;

    public Exploracao() {
    }

    public void criaLista(List<Movel> moveis){
        if(this.moveis == null) this.moveis = moveis;
        else{
            System.out.println("Os esquipamentos que participarão da exploração já foram informados");
        }
    }

    public void criaPlanalto(int x, int y){
        Planalto planalto = new Planalto(new Coordenadas(x, y));
         if(planalto.valida()){
             this.planalto = planalto;
            }
        else{
            throw new RuntimeException("O Planalto possui dimensões muito pequenas, não vale a pena explorá-lo.");
        }
    }

    public List<Movel> getMoveis() {
        return Collections.unmodifiableList(this.moveis);
    }

    public void adiciona(Movel movel){
        explora(movel);
        this.moveis.add(movel);
    }


    private void explora(Movel movel){
        movel.validaPosicao(this.planalto);
        movel.cumpraTrajetoria(this.planalto, getMoveis());

    }

    public void exibeResultadoExplorcao() {
        getMoveis().forEach(movel -> System.out.println(movel.exibaPosicaoFinal()));
    }

    public Movel defineMovel(int x, int y, String trajetoria, String direcao) {
        if(trajetoria != null) {
            Sonda sonda = new Sonda(new Posicao(new Coordenadas(x, y), direcao), trajetoria);
            if (sonda.validaSonda(trajetoria)) {
                return sonda;
            }
        }
        throw new RuntimeException("Não foi possível iniciar a exploração");
    }

}
