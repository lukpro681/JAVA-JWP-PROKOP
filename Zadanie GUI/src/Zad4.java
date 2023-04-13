import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.*;

class ZdarzeniaMyszy extends JPanel implements MouseListener {
    final int SREDNICA = 24;
    int koloX, koloY;

    class ObslugaKlawiatury implements KeyListener {
        public ObslugaKlawiatury() {
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    koloY += 5;
                    break;
                case KeyEvent.VK_UP:
                    koloY -= 5;
                    break;
                case KeyEvent.VK_LEFT:
                    koloX -= 5;
                    break;
                case KeyEvent.VK_RIGHT:
                    koloX += 5;
                    break;
            }
            repaint();//metoda odrysowuje element na powierzchni panelu
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        koloX = e.getX() - SREDNICA / 2;
        koloY = e.getY() - SREDNICA / 2;
        repaint();
    }

    // implementacje pozostałych metod interfejsu MouseListener
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillOval(koloX, koloY, SREDNICA, SREDNICA);
    }

    public static class Zad4 {

        private static void zaczynaj() {
            JFrame okno = new JFrame("Zdarzenia myszy");
            okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            okno.setContentPane(new ZdarzeniaMyszy());
            okno.setBounds(200, 200, 640, 480);
            okno.setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    zaczynaj();
                }
            });
        }
    }
}