package swing6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CalculatorApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 350);
        frame.setLayout(new BorderLayout());

        JTextField display = new JTextField();
        display.setEditable(false);
        frame.add(display, BorderLayout.NORTH);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener((ActionEvent e) -> {
                String command = e.getActionCommand();
                if (command.equals("C")) {
                    display.setText("");
                } else if (command.equals("=")) {
                    try {
                        display.setText(evaluate(display.getText()));
                    } catch (Exception ex) {
                        display.setText("Ошибка");
                    }
                } else {
                    display.setText(display.getText() + command);
                }
            });
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private static String evaluate(String expression) {
        try {
            String[] tokens = expression.split(" ");
            double num1 = Double.parseDouble(tokens[0]);
            String operator = tokens[1];
            double num2 = Double.parseDouble(tokens[2]);

            switch (operator) {
                case "+":
                    return String.valueOf(num1 + num2);
                case "-":
                    return String.valueOf(num1 - num2);
                case "*":
                    return String.valueOf(num1 * num2);
                case "/":
                    if (num2 == 0) {
                        return "Ошибка";
                    } else {
                        return String.valueOf(num1 / num2);
                    }
                default:
                    return "Ошибка";
            }
        } catch (Exception e) {
            return "Ошибка";
        }
    }
}

