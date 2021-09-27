public abstract class EquipamentoExplorador implements Movel{

    private Posicao posicao;
    private String trajetoria;

    public EquipamentoExplorador(Posicao posicao, String trajetoria, Planalto planalto) throws Exception {
        this.posicao = posicao;
        verificaSePosicaoEValida(planalto);
        this.trajetoria = trajetoria;
    }

    private void verificaSePosicaoEValida(Planalto planalto) throws Exception {
        if (posicao.getCoordenadas().getX() > planalto.getCoordenadasMaximas().getX() ||
                posicao.getCoordenadas().getY() > planalto.getCoordenadasMaximas().getY() ){
            throw new Exception();
        }
    }

    @Override
    public void mover() throws Exception {
        String direcao = this.posicao.getDirecao();

        switch (direcao){
            case "N":
                atualizaEixo("y", 1);
                break;
            case "S":
                atualizaEixo("y", -1);
                break;
            case "W":
                atualizaEixo("x", -1);
                break;
            case "E":
                atualizaEixo("x", 1);
                break;
            default:
                throw new Exception();
        }

    }

    @Override
    public void mudaDirecao(char ordemDeMudarDirecao) {
        String direcaoAtual = posicao.getDirecao();
        String novaDirecao = null;
        switch (direcaoAtual) {
            case "N":
                if (ordemDeMudarDirecao == 'R') novaDirecao = "E";
                else if (ordemDeMudarDirecao == 'L') novaDirecao = "W";
                break;
            case "S":
                if (ordemDeMudarDirecao == 'R') novaDirecao = "W";
                else if (ordemDeMudarDirecao == 'L') novaDirecao = "E";
                break;
            case "W":
                if (ordemDeMudarDirecao == 'R') novaDirecao = "N";
                else if (ordemDeMudarDirecao == 'L') novaDirecao = "S";
                break;
            case "E":
                if (ordemDeMudarDirecao == 'R') novaDirecao = "S";
                else if (ordemDeMudarDirecao == 'L') novaDirecao = "N";
                break;
        }
        posicao = new Posicao(new Coordenadas(this.posicao.getCoordenadas().getX(),
                this.posicao.getCoordenadas().getY()),novaDirecao);
    }

    @Override
    public void cumprirTrajetoria(Planalto planalto) throws Exception {
        for(int i = 0; i < trajetoria.length(); i++){
            switch (trajetoria.charAt(i)){
                case 'M':
                    mover();
                    verificaSePosicaoEValida(planalto);
                    break;
                case 'R':
                    mudaDirecao('R');
                    break;
                case 'L':
                    mudaDirecao('L');
                    break;
                default:
                    throw new RuntimeException("Algum equipamento explorador possui uma trajetória inválida");
            }

        }
    }

    @Override
    public void atualizaEixo(String eixo, int valor) {
        Coordenadas coordenadas = null;
        if (eixo.equals("x")){
             coordenadas = new Coordenadas(this.posicao.getCoordenadas().getX() + valor, this.posicao.getCoordenadas().getY());
        }
        else if(eixo.equals("y")){
             coordenadas = new Coordenadas(this.posicao.getCoordenadas().getX(), this.posicao.getCoordenadas().getY() + valor);
        }
        posicao = new Posicao(coordenadas, this.posicao.getDirecao());

    }

   public String dadosPosicao(){
        String stringPosicao = posicao.getCoordenadas().getX() + " " +
                posicao.getCoordenadas().getY() + " " + posicao.getDirecao();
        return stringPosicao;
   }
}
