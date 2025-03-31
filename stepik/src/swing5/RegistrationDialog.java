package swing5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class RegistrationDialog {

    public static void main(String[] args) {
        int choice = JOptionPane.showConfirmDialog(null, "Добро пожаловать! Хотите зарегистрироваться?", "Регистрация", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
        }

        String login = getLogin();

        String password = getPassword();

        String confirmPassword = getConfirmPassword(password);

        JOptionPane.showMessageDialog(null, "Регистрация прошла успешно! Добро пожаловать, " + login + "!", "Регистрация", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String getLogin() {
        String login = "";
        boolean valid = false;

        while (!valid) {
            login = JOptionPane.showInputDialog(null, "Введите ваш логин (минимум 5 символов, без пробелов):");
            if (login != null && login.length() >= 5 && !login.contains(" ")) {
                valid = true;
            } else {
                JOptionPane.showMessageDialog(null, "Логин должен быть больше 5 символов и не содержать пробелов.", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }

        return login;
    }

    private static String getPassword() {
        String password = "";
        boolean valid = false;

        while (!valid) {
            JPasswordField passwordField = new JPasswordField(10);
            int option = JOptionPane.showConfirmDialog(null, passwordField, "Введите ваш пароль (более 8 символов, без пробелов, хотя бы одна цифра и буква)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                password = new String(passwordField.getPassword());
                if (isValidPassword(password)) {
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Пароль должен быть более 8 символов, содержать хотя бы одну цифру, одну букву и не содержать пробелов.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }

        return password;
    }

    private static boolean isValidPassword(String password) {
        return password.length() > 8 && !password.contains(" ") && password.matches(".*[A-Za-z].*") && password.matches(".*[0-9].*");
    }

    private static String getConfirmPassword(String password) {
        String confirmPassword = "";
        boolean valid = false;

        while (!valid) {
            JPasswordField confirmPasswordField = new JPasswordField(10);
            int option = JOptionPane.showConfirmDialog(null, confirmPasswordField, "Повторите ваш пароль", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (option == JOptionPane.OK_OPTION) {
                confirmPassword = new String(confirmPasswordField.getPassword());
                if (confirmPassword.equals(password)) {
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Пароли не совпадают. Пожалуйста, введите тот же пароль.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }

        return confirmPassword;
    }
}

