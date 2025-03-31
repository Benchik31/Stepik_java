package swing6;
import javax.swing.*;
import java.awt.*;

public class FirstLabelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Первая надпись");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Моя первая надпись!", SwingConstants.CENTER);

        label.setFont(new Font("Arial", Font.ITALIC, 50));

        frame.add(label, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}

