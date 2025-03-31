package swing6;

import javax.swing.*;
import java.awt.*;

public class SpinnerApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор количества книг");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Сколько книг вы возьмете с собой?");
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        JButton button = new JButton("Ответить");
        JLabel answerLabel = new JLabel("Ответ:");

        button.addActionListener(e -> {
            int booksCount = (int) spinner.getValue();
            answerLabel.setText("Ответ: Я возьму " + booksCount + " книг.");
        });

        frame.add(label);
        frame.add(spinner);
        frame.add(button);
        frame.add(answerLabel);

        frame.setVisible(true);
    }
}

