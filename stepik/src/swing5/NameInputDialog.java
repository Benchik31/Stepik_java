package swing5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NameInputDialog extends JPanel {

    public NameInputDialog() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        JButton openDialogButton = new JButton("Ввести имя");
        openDialogButton.addActionListener(e -> showInputDialog());

        add(openDialogButton);
    }

    private void showInputDialog() {
        String name = JOptionPane.showInputDialog(this, "Введите ваше имя:", "Имя", JOptionPane.QUESTION_MESSAGE);

        if (name != null && !name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ваше имя: " + name, "Информация", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Вы не ввели имя!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ввод имени");
        NameInputDialog panel = new NameInputDialog();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

