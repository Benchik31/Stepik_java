package swing6;

import javax.swing.*;
import java.awt.*;

public class ComboBoxApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Выбор любимого цвета");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(new FlowLayout());

        String[] colors = {"Красный", "Синий", "Зеленый", "Желтый", "Черный"};
        JComboBox<String> comboBox = new JComboBox<>(colors);

        JCheckBox checkBox = new JCheckBox("Ввести свой цвет");
        JTextField textField = new JTextField(10);
        textField.setEnabled(false);

        JButton button = new JButton("Ответить");
        JLabel answerLabel = new JLabel("Ответ:");

        checkBox.addActionListener(e -> textField.setEnabled(checkBox.isSelected()));

        button.addActionListener(e -> {
            String selectedColor = (String) comboBox.getSelectedItem();
            if (checkBox.isSelected() && !textField.getText().isEmpty()) {
                selectedColor = textField.getText();
            }
            answerLabel.setText("Ответ: " + selectedColor);
        });

        frame.add(comboBox);
        frame.add(checkBox);
        frame.add(textField);
        frame.add(button);
        frame.add(answerLabel);

        frame.setVisible(true);
    }
}

