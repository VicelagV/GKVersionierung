package controller;
import model.GewinnModel;
import view.GewinnView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnView view;
    public GewinnController(GewinnModel model, GewinnView view) {
        if (model == null || view == null) {
            throw new IllegalArgumentException("Model und View fehlen.");
        }
        this.model = model;
        this.view = view;
        view.registriereController(this);
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event == null) {
            return;
        }
        if ("runde".equals(event.getActionCommand())) {
            spieleRunde();
        } else if ("weiter".equals(event.getActionCommand())) {
            view.leereRunde();
        }
    }
    private void spieleRunde() {
        if (model.hatGewonnen() || model.hatVerloren()) {
            view.zeigeMeldung("Das Spiel ist bereits beendet.");
            return;
        }
        String eingabe = view.getSpielerEingabe();
        if (eingabe == null || eingabe.trim().isEmpty()) {
            view.zeigeMeldung("Bitte eine Zahl von 1 bis 9 eingeben.");
            return;
        }
        int zahl;
        try {
            zahl = Integer.parseInt(eingabe.trim());
        } catch (NumberFormatException exception) {
            view.zeigeMeldung("Bitte eine ganze Zahl eingeben.");
            return;
        }
        if (zahl < 1 || zahl > 9) {
            view.zeigeMeldung("Die Zahl muss zwischen 1 und 9 liegen.");
            return;
        }
        model.berechneComputerZahl();
        model.berechneRunde(zahl);
        view.zeigeRunde(
                model.getGesamtPunkte(),
                model.getRundenErgebnis(),
                model.getComputerZahl()
        );
        if (model.hatGewonnen()) {
            view.zeigeMeldung("Du hast gewonnen!");
        } else if (model.hatVerloren()) {
            view.zeigeMeldung("Du hast verloren!");
        }
    }
}