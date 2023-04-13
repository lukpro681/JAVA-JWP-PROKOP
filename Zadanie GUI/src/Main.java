import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PanelZawartosc extends JPanel {
    private Color m_wybranyKolor = Color.PINK; // domyślny kolor

    public PanelZawartosc() {
        JButton przyciskKoloru = new JButton("Wybierz kolor z palety");
        przyciskKoloru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component zrodlo = (Component) e.getSource(); // pobierz źródło zdarzenia
                Color wybranyKolor = JColorChooser.showDialog(zrodlo, "Wybierz kolor z palety", m_wybranyKolor);
                if (wybranyKolor != null) { // jeśli użytkownik wybrał kolor
                    PanelZawartosc.this.m_wybranyKolor = wybranyKolor; // zapisuje wybrany kolor w zmiennej obiektu PanelZawartosc
                    setBackground(wybranyKolor); // ustawia tło panelu na wybrany kolor
                }
            }
        });
        add(przyciskKoloru);
        setBackground(m_wybranyKolor);
    }
}

public class Main {

    private static void zrobOkno() {
        JFrame okno = new JFrame("Moja Pierwsza apka");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(new PanelZawartosc());
        okno.setBounds(200,200,640,480);
        okno.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                zrobOkno();
            }
        });
    }
}