package swing1;

import javax.swing.*;
import java.awt.*;

public class Car extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(new Color(135, 206, 235));

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.GRAY);
        g2.fillRect(0, 300, getWidth(), 100);

        g2.setColor(Color.RED);
        g2.fillRoundRect(100, 220, 250, 80, 30, 30);

        g2.setColor(Color.RED);
        int[] xPoints = {160, 210, 270, 310};
        int[] yPoints = {220, 170, 170, 220};
        g2.fillPolygon(xPoints, yPoints, 4);

        g2.setColor(Color.CYAN);
        g2.fillRect(175, 180, 30, 30);
        g2.fillRect(225, 180, 30, 30);

        g2.setColor(Color.BLACK);
        g2.fillOval(130, 280, 50, 50);
        g2.fillOval(270, 280, 50, 50);

        g2.setColor(Color.LIGHT_GRAY);
        g2.fillOval(140, 290, 30, 30);
        g2.fillOval(280, 290, 30, 30);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Машинка");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 450);
        frame.add(new Car());
        frame.setVisible(true);
    }
}

