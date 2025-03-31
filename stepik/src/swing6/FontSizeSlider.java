package swing6;

import javax.swing.*;
import java.awt.*;

public class FontSizeSlider {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Изменение шрифта надписи");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Моя первая надпись!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.ITALIC, 50));

        JSlider slider = new JSlider(5, 100, 50);
        slider.addChangeListener(e -> {
            int fontSize = slider.getValue();
            label.setFont(new Font("Arial", Font.ITALIC, fontSize));
        });

        frame.add(label, BorderLayout.CENTER);
        frame.add(slider, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

