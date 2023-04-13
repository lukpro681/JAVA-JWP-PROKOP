import javax.swing.*;
import java.awt.*;
import java.util.Random;

class PanelZawartoscA extends JPanel {
    public PanelZawartoscA() {
        setBackground(Color.PINK);
        setLayout(new BorderLayout());
        add(new PanelKropki());
    }
}

class PanelKropki extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getSize().width;
        int height = getSize().height;
        int OvalSize = 25;

        Random random = new Random();

        for (int i = 0; i < width; i += OvalSize) {
            for (int j = 0; j < height; j += OvalSize) {
                int red = random.nextInt(256);
                int green = random.nextInt(256);
                int blue = random.nextInt(256);
                Color color = new Color(red, green, blue);
                g.setColor(color);
                g.fillOval(i, j, OvalSize, OvalSize);
            }
        }
    }
}

public class Zad2 {

    private static void zrobOkno() {
        JFrame okno = new JFrame("Moja Pierwsza apka");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(new PanelZawartoscA());
        okno.setBounds(200, 200, 640, 480);
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

