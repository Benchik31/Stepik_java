package swing6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Форма регистрации");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(12, 2, 10, 10));

        JLabel nameLabel = new JLabel("Имя:");
        JTextField nameField = new JTextField();

        JLabel emailLabel = new JLabel("Электронная почта:");
        JTextField emailField = new JTextField();

        JLabel phoneLabel = new JLabel("Телефон:");
        JTextField phoneField = new JTextField();

        JLabel genderLabel = new JLabel("Пол:");
        JRadioButton maleButton = new JRadioButton("Мужской");
        JRadioButton femaleButton = new JRadioButton("Женский");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        JLabel ageLabel = new JLabel("Возраст:");
        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(18, 18, 100, 1));

        JLabel eventLabel = new JLabel("Как вы узнали о мероприятии?");
        JCheckBox socialMediaCheck = new JCheckBox("Социальные сети");
        JCheckBox friendsCheck = new JCheckBox("Друзья");
        JCheckBox websiteCheck = new JCheckBox("Сайт мероприятия");

        JLabel feedbackLabel = new JLabel("Комментарии:");
        JTextArea feedbackArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(feedbackArea);

        JButton submitButton = new JButton("Отправить");

        submitButton.addActionListener((ActionEvent e) -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String gender = maleButton.isSelected() ? "Мужской" : femaleButton.isSelected() ? "Женский" : "Не указан";
            int age = (int) ageSpinner.getValue();
            String eventSource = "";
            if (socialMediaCheck.isSelected()) eventSource += "Социальные сети ";
            if (friendsCheck.isSelected()) eventSource += "Друзья ";
            if (websiteCheck.isSelected()) eventSource += "Сайт мероприятия ";
            String feedback = feedbackArea.getText();

            String message = String.format("Имя: %s\nЭлектронная почта: %s\nТелефон: %s\nПол: %s\nВозраст: %d\nКак вы узнали о мероприятии: %s\nКомментарии: %s",
                    name, email, phone, gender, age, eventSource, feedback);

            JOptionPane.showMessageDialog(frame, message, "Информация о регистрации", JOptionPane.INFORMATION_MESSAGE);
        });

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(genderLabel);
        JPanel genderPanel = new JPanel();
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        frame.add(genderPanel);
        frame.add(ageLabel);
        frame.add(ageSpinner);
        frame.add(eventLabel);
        JPanel eventPanel = new JPanel();
        eventPanel.add(socialMediaCheck);
        eventPanel.add(friendsCheck);
        eventPanel.add(websiteCheck);
        frame.add(eventPanel);
        frame.add(feedbackLabel);
        frame.add(scrollPane);
        frame.add(submitButton);

        frame.setVisible(true);
    }
}

