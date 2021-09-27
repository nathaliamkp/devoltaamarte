public class Planalto {

    private Coordenadas coordenadasMaximas;

    public Planalto(Coordenadas coordenadasMaximas) {
        this.coordenadasMaximas = coordenadasMaximas;
        verificaSePlanaltoEPequeno();
    }

    public Coordenadas getCoordenadasMaximas() {
        return coordenadasMaximas;
    }

    private void verificaSePlanaltoEPequeno(){
        if (coordenadasMaximas.getX() * coordenadasMaximas.getY() < 9) throw new RuntimeException("A exploração desse planalto " +
                "é economicamente inviável");
    }
}
