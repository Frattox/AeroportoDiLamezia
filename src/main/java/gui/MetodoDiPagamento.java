package gui;

public class MetodoDiPagamento {
    private int numero;
    private String tipologia;
    private int limiteTransazione;
    private Passeggero passeggero; // Aggiungiamo CFUtente per il collegamento con il Passeggero

    public MetodoDiPagamento(int numero, String tipologia, int limiteTransazione, Passeggero passeggero) {
        this.numero = numero;
        this.tipologia = tipologia;
        this.limiteTransazione = limiteTransazione;
        this.passeggero = passeggero;
    }

    // Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getLimiteTransazione() {
        return limiteTransazione;
    }

    public void setLimiteTransazione(int limiteTransazione) {
        this.limiteTransazione = limiteTransazione;
    }

    public Passeggero getPasseggero() {
        return passeggero;
    }

    public void setPasseggero(Passeggero passeggero) {
        this.passeggero = passeggero;
    }
}
