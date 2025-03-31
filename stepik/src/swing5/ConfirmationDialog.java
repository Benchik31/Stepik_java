package swing5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfirmationDialog extends JPanel {

    public ConfirmationDialog() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        JButton startButton = new JButton("Начать опрос");
        startButton.addActionListener(e -> askQuestions());

        add(startButton);
    }

    private void askQuestions() {
        int response1 = JOptionPane.showConfirmDialog(this, "Вам нравится программировать?", "Вопрос 1", JOptionPane.YES_NO_OPTION);

        if (response1 == JOptionPane.YES_OPTION) {
            int response2 = JOptionPane.showConfirmDialog(this, "Хотите продолжить обучение?", "Вопрос 2", JOptionPane.YES_NO_OPTION);

            if (response2 == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Отлично! Продолжайте в том же духе!", "Результат", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Не переживайте, всегда можно вернуться к обучению позже.", "Результат", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            int response2 = JOptionPane.showConfirmDialog(this, "Хотите продолжить обучение?", "Вопрос 2", JOptionPane.YES_NO_OPTION);

            if (response2 == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(this, "Здорово! Может, стоит начать изучать программирование?", "Результат", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Это нормально, не все должны стать программистами.", "Результат", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Окно подтверждения");
        ConfirmationDialog panel = new ConfirmationDialog();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

