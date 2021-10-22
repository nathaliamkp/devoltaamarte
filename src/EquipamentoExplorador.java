import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class EquipamentoExplorador implements Movel{

    private Posicao posicao;
    protected String trajetoria;
    private String relatorioPosicao;
    private List<Posicao> posicoes;


    public EquipamentoExplorador(Posicao posicao, String trajetoria){
        this.posicao = posicao;
        this.trajetoria = trajetoria;
        this.posicoes = new ArrayList<>();
        adicionaPosicao();
    }


    @Override
    public void mover(){
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
        }

    }

    @Override
    public void mudaDirecao(char ordemDeMudarDirecao) {
        String direcaoAtual = this.posicao.getDirecao();
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
    public void cumpraTrajetoria(Planalto planalto, List<Movel> moveis){
        for(int i = 0; i < this.trajetoria.length(); i++){
            switch (this.trajetoria.charAt(i)){
                case 'M':
                    mover();
                        if(validaNovaPosicao(moveis, i, planalto)){
                            adicionaPosicao();
                        }else{
                            this.posicao = this.posicoes.get(posicoes.size()-1);
                        }
                    break;
                case 'R':
                    mudaDirecao('R');
                    break;
                case 'L':
                    mudaDirecao('L');
                    break;
            }
        }
    }




    private boolean validaNovaPosicao(List<Movel> moveis, int i, Planalto planalto){
        boolean posicaoValida = true;
        validaPosicao(planalto);
        for (Movel movel : moveis) {
            if (this.posicao.getCoordenadas().toString().equals(movel.retornaCoordenadas())) {
                colide();
                this.trajetoria = this.trajetoria.substring(i);
                posicaoValida = false;
            }
        }
       return posicaoValida;
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
        this.posicao = new Posicao(coordenadas, this.posicao.getDirecao());

    }

    @Override
    public String exibaPosicaoFinal(){
        this.relatorioPosicao = this.posicao.getCoordenadas().getX() + " " +
                this.posicao.getCoordenadas().getY() + " " + this.posicao.getDirecao();
        return this.relatorioPosicao;
   }

    @Override
    public void validaPosicao(Planalto planalto) {
        if(this.posicao.getCoordenadas().getY() > planalto.getCoordenadasMaximas().getY() ||
                this.posicao.getCoordenadas().getX() > planalto.getCoordenadasMaximas().getX()){
            throw new RuntimeException("A trajetória desse equipamento excede o Planalto. Por segurança a exploração foi cancelada");
        }
    }

    @Override
    public void colide() {

    }

    @Override
    public String retornaCoordenadas() {
        return this.posicao.getCoordenadas().toString();
    }

    public List<Posicao> getPosicoes(){
        return Collections.unmodifiableList(this.posicoes);
    }

    private void adicionaPosicao(){
        this.posicoes.add(this.posicao);
    }

}
