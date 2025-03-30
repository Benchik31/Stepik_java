package swing1;

import javax.swing.*;
import java.awt.*;

public class Snowman extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.CYAN);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.WHITE);
        g2.fillOval(100, 200, 200, 200);

        g2.fillOval(120, 120, 160, 160);

        g2.fillOval(140, 60, 120, 120);

        g2.setColor(Color.BLACK);
        g2.fillOval(170, 100, 10, 10);
        g2.fillOval(220, 100, 10, 10);

        g2.setColor(Color.ORANGE);
        int[] x = {195, 250, 195};
        int[] y = {130, 135, 140};
        g2.fillPolygon(x, y, 3);

        g2.setColor(new Color(139, 69, 19));
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(120, 160, 50, 100);
        g2.drawLine(280, 160, 350, 100);

        g2.setColor(Color.BLACK);
        g2.fillRect(160, 40, 80, 20);
        g2.fillRect(145, 60, 110, 10);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Снеговик");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.add(new Snowman());
        frame.setVisible(true);
    }
}

