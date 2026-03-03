package dominio;

public class Interaccion {
    
    private Proteina destino;
    private int costo;

    public Interaccion(Proteina destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }

    public Proteina getDestino() {
        return destino;
    }

    public void setDestino(Proteina destino) {
        this.destino = destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}