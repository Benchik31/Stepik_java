package swing6;

import javax.swing.*;
import java.awt.*;

public class ClickerApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Кликер");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Кнопка нажата 0 раз.");
        JButton button = new JButton("Нажми меня");

        button.addActionListener(e -> {
            String text = label.getText();
            int count = Integer.parseInt(text.replaceAll("[^0-9]", ""));
            count++;
            label.setText("Кнопка нажата " + count + " раз.");
        });

        frame.add(label);
        frame.add(button);

        frame.setVisible(true);
    }
}

