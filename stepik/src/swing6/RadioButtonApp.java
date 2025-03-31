package swing6;

import javax.swing.*;
import java.awt.*;

public class RadioButtonApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор любимого времени года");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        JRadioButton springButton = new JRadioButton("Весна");
        JRadioButton summerButton = new JRadioButton("Лето");
        JRadioButton autumnButton = new JRadioButton("Осень");
        JRadioButton winterButton = new JRadioButton("Зима");

        ButtonGroup group = new ButtonGroup();
        group.add(springButton);
        group.add(summerButton);
        group.add(autumnButton);
        group.add(winterButton);

        JButton button = new JButton("Ответить");
        JLabel answerLabel = new JLabel("Ответ:");

        button.addActionListener(e -> {
            String selectedSeason = "Не выбрано";
            if (springButton.isSelected()) {
                selectedSeason = "Весна";
            } else if (summerButton.isSelected()) {
                selectedSeason = "Лето";
            } else if (autumnButton.isSelected()) {
                selectedSeason = "Осень";
            } else if (winterButton.isSelected()) {
                selectedSeason = "Зима";
            }
            answerLabel.setText("Ответ: " + selectedSeason);
        });

        frame.add(springButton);
        frame.add(summerButton);
        frame.add(autumnButton);
        frame.add(winterButton);
        frame.add(button);
        frame.add(answerLabel);

        frame.setVisible(true);
    }
}

