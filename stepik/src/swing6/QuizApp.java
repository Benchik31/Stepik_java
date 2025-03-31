package swing6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class QuizApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Викторина");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JLabel questionLabel = new JLabel("Вопрос 1: Кто написал «Преступление и наказание»?", SwingConstants.CENTER);
        frame.add(questionLabel, BorderLayout.NORTH);

        JButton option1 = new JButton("Лев Толстой");
        JButton option2 = new JButton("Фёдор Достоевский");
        JButton option3 = new JButton("Александр Пушкин");
        JButton option4 = new JButton("Максим Горький");

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1));
        optionsPanel.add(option1);
        optionsPanel.add(option2);
        optionsPanel.add(option3);
        optionsPanel.add(option4);

        frame.add(optionsPanel, BorderLayout.CENTER);

        JLabel resultLabel = new JLabel("Ваш результат: 0/1", SwingConstants.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        int[] score = {0};

        option1.addActionListener((ActionEvent e) -> {
            if (!option1.getText().equals("Фёдор Достоевский")) {
                resultLabel.setText("Неверно! Ваш результат: " + score[0] + "/1");
            } else {
                score[0]++;
                resultLabel.setText("Верно! Ваш результат: " + score[0] + "/1");
            }
            questionLabel.setText("Вопрос 2: Какой элемент химической таблицы имеет символ O?");
            option1.setText("Азот");
            option2.setText("Кислород");
            option3.setText("Углерод");
            option4.setText("Гелий");
        });

        option2.addActionListener((ActionEvent e) -> {
            if (!option2.getText().equals("Фёдор Достоевский")) {
                resultLabel.setText("Неверно! Ваш результат: " + score[0] + "/1");
            } else {
                score[0]++;
                resultLabel.setText("Верно! Ваш результат: " + score[0] + "/1");
            }
            questionLabel.setText("Вопрос 2: Какой элемент химической таблицы имеет символ O?");
            option1.setText("Азот");
            option2.setText("Кислород");
            option3.setText("Углерод");
            option4.setText("Гелий");
        });

        option3.addActionListener((ActionEvent e) -> {
            if (!option3.getText().equals("Фёдор Достоевский")) {
                resultLabel.setText("Неверно! Ваш результат: " + score[0] + "/1");
            } else {
                score[0]++;
                resultLabel.setText("Верно! Ваш результат: " + score[0] + "/1");
            }
            questionLabel.setText("Вопрос 2: Какой элемент химической таблицы имеет символ O?");
            option1.setText("Азот");
            option2.setText("Кислород");
            option3.setText("Углерод");
            option4.setText("Гелий");
        });

        option4.addActionListener((ActionEvent e) -> {
            if (!option4.getText().equals("Фёдор Достоевский")) {
                resultLabel.setText("Неверно! Ваш результат: " + score[0] + "/1");
            } else {
                score[0]++;
                resultLabel.setText("Верно! Ваш результат: " + score[0] + "/1");
            }
            questionLabel.setText("Вопрос 2: Какой элемент химической таблицы имеет символ O?");
            option1.setText("Азот");
            option2.setText("Кислород");
            option3.setText("Углерод");
            option4.setText("Гелий");
        });

        frame.setVisible(true);
    }
}

