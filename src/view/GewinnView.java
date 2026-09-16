package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
public class GewinnView extends JFrame {
    private JLabel gesamtLabel;
    private JLabel rundenLabel;
    private JTextField spielerFeld;
    private JTextField computerFeld;
    private JButton weiterButton;
    public GewinnView() {
        setTitle("Zahlen-Gewinnspiel");
        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel hauptPanel = new JPanel(new BorderLayout(10, 10));
        hauptPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
        JPanel ergebnisPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        gesamtLabel = new JLabel("Gesamtpunkte: 30");
        rundenLabel = new JLabel("Rundenergebnis: ");
        gesamtLabel.setOpaque(true);
        rundenLabel.setOpaque(true);
        gesamtLabel.setBackground(Color.WHITE);
        rundenLabel.setBackground(Color.WHITE);
        ergebnisPanel.add(gesamtLabel);
        ergebnisPanel.add(rundenLabel);
        JPanel eingabePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        spielerFeld = new JTextField();
        computerFeld = new JTextField();
        computerFeld.setEditable(false);
        eingabePanel.add(new JLabel("Deine Zahl (1–9):"));
        eingabePanel.add(spielerFeld);
        eingabePanel.add(new JLabel("Computerzahl:"));
        eingabePanel.add(computerFeld);
        weiterButton = new JButton("Noch einmal!");
        hauptPanel.add(ergebnisPanel, BorderLayout.NORTH);
        hauptPanel.add(eingabePanel, BorderLayout.CENTER);
        hauptPanel.add(weiterButton, BorderLayout.SOUTH);
        setContentPane(hauptPanel);
    }
    public String getSpielerEingabe() {
        return spielerFeld.getText();
    }
    public void registriereController(ActionListener controller) {
        spielerFeld.setActionCommand("runde");
        weiterButton.setActionCommand("weiter");
        spielerFeld.addActionListener(controller);
        weiterButton.addActionListener(controller);
    }
    public void zeigeRunde(int gesamt, int ergebnis, int computer) {
        gesamtLabel.setText("Gesamtpunkte: " + gesamt);
        rundenLabel.setText("Rundenergebnis: " + ergebnis);
        computerFeld.setText(String.valueOf(computer));
        gesamtLabel.setBackground(Color.WHITE);
        rundenLabel.setBackground(Color.WHITE);
    }
    public void leereRunde() {
        spielerFeld.setText("");
        computerFeld.setText("");
        rundenLabel.setText("Rundenergebnis: ");
        gesamtLabel.setBackground(Color.WHITE);
        rundenLabel.setBackground(Color.WHITE);
        spielerFeld.requestFocusInWindow();
    }
    public void zeigeMeldung(String text) {
        JOptionPane.showMessageDialog(this, text);
    }
}