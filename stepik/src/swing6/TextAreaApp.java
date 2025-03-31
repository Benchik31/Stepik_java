package swing6;

import javax.swing.*;
import java.awt.*;

public class TextAreaApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Добавление строк в JTextArea");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JTextField textField = new JTextField(20);
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton button = new JButton("Записать");

        button.addActionListener(e -> {
            String text = textField.getText();
            if (!text.isEmpty()) {
                textArea.append(text + "\n");
                textField.setText("");
            }
        });

        frame.add(textField);
        frame.add(button);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}

