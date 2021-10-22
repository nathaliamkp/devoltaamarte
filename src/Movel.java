import java.util.List;

public interface Movel {

    void mover();

    void mudaDirecao(char ordemDeMudarDirecao);

    void cumpraTrajetoria(Planalto planalto, List<Movel> moveis) ;

    void atualizaEixo(String eixo, int valor);

    String exibaPosicaoFinal();

    void validaPosicao(Planalto Planalto);

    String retornaCoordenadas();

    void colide();

}
