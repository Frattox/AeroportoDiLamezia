package gui;
public class MetodoDiPagamento {
    private int numero;
    private String tipologia;
    private int limiteTransazione;
    private String CFUtente; // Aggiungiamo CFUtente per il collegamento con il Passeggero

    public MetodoDiPagamento(int numero, String tipologia, int limiteTransazione, String CFUtente) {
        this.numero = numero;
        this.tipologia = tipologia;
        this.limiteTransazione = limiteTransazione;
        this.CFUtente = CFUtente;
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

    public String getCFUtente() {
        return CFUtente;
    }

    public void setCFUtente(String CFUtente) {
        this.CFUtente = CFUtente;
    }
}
