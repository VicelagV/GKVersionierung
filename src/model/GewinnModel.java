package model;
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;
    public GewinnModel() {
        gesamtPunkte = 30;
    }
    public int getGesamtPunkte() {
        return gesamtPunkte;
    }
    public int getComputerZahl() {
        return computerZahl;
    }
    public int getRundenErgebnis() {
        return rundenErgebnis;
    }
    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }
    public void berechneRunde(int spielerZahl) {
        if (spielerZahl < 1 || spielerZahl > 9) {
            throw new IllegalArgumentException(
                    "Die Zahl muss zwischen 1 und 9 liegen."
            );
        }
        if (hatGewonnen() || hatVerloren()) {
            throw new IllegalStateException(
                    "Das Spiel ist bereits beendet."
            );
        }
        if (computerZahl < 1 || computerZahl > 9) {
            throw new IllegalStateException(
                    "Zuerst muss eine Computerzahl erzeugt werden."
            );
        }
        this.spielerZahl = spielerZahl;
        if (this.spielerZahl == computerZahl) {
            rundenErgebnis = 20;
        } else if (Math.abs(this.spielerZahl - computerZahl) == 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
        gesamtPunkte = gesamtPunkte + rundenErgebnis;
    }
    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }
    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}