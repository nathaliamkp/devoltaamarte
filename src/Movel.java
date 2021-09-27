public interface Movel {

    void mover() throws Exception;

    void mudaDirecao(char ordemDeMudarDirecao);

    void cumprirTrajetoria(Planalto planalto) throws Exception;

    void atualizaEixo(String eixo, int valor);

   ;
}
