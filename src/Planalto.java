public class Planalto {

    private Coordenadas coordenadasMaximas;

    public Planalto(Coordenadas coordenadasMaximas) {
        this.coordenadasMaximas = coordenadasMaximas;
    }

    public Coordenadas getCoordenadasMaximas() {
        return coordenadasMaximas;
    }

    public boolean valida(){
        return coordenadasMaximas.getX() * coordenadasMaximas.getY() >= 9;
    }
}
