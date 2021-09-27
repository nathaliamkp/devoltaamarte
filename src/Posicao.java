public class Posicao {

    private Coordenadas coordenadas;
    private String direcao;


    public Posicao(Coordenadas coordenadas, String direcao) {
        this.coordenadas = coordenadas;
        this.direcao = direcao;
    }

    public String getDirecao() {
        return direcao;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }
}
