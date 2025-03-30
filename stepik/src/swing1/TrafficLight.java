package swing1;

import javax.swing.*;
import java.awt.*;

public class TrafficLight extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(90, 50, 120, 300);

        g.setColor(Color.RED);
        g.fillOval(110, 70, 80, 80);

        g.setColor(Color.YELLOW);
        g.fillOval(110, 160, 80, 80);

        g.setColor(Color.GREEN);
        g.fillOval(110, 250, 80, 80);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Светофор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        frame.add(new TrafficLight());
        frame.setVisible(true);
    }
}

