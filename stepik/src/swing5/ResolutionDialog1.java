package swing5;

import javax.swing.*;
import java.awt.*;

public class ResolutionDialog1 extends JPanel {

    public ResolutionDialog1() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        JButton resolutionButton = new JButton("Выберите разрешение");
        resolutionButton.addActionListener(e -> showResolutionDialog());

        add(resolutionButton);
    }

    // Диалоговое окно с выбором разрешения
    private void showResolutionDialog() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Выберите разрешение экрана:"));

        JRadioButton rb1 = new JRadioButton("800x600");
        JRadioButton rb2 = new JRadioButton("1024x768");
        JRadioButton rb3 = new JRadioButton("1280x1024");
        JRadioButton rb4 = new JRadioButton("1920x1080");

        ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        group.add(rb3);
        group.add(rb4);

        panel.add(rb1);
        panel.add(rb2);
        panel.add(rb3);
        panel.add(rb4);

        int option = JOptionPane.showConfirmDialog(this, panel, "Выбор разрешения", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            int width = 800, height = 600;

            if (rb1.isSelected()) {
                width = 800;
                height = 600;
            } else if (rb2.isSelected()) {
                width = 1024;
                height = 768;
            } else if (rb3.isSelected()) {
                width = 1280;
                height = 1024;
            } else if (rb4.isSelected()) {
                width = 1920;
                height = 1080;
            }

            createWindow(width, height);
        }
    }

    private void createWindow(int width, int height) {
        JFrame frame = new JFrame("Окно с разрешением " + width + "x" + height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Диалог выбора разрешения");
        ResolutionDialog1 panel = new ResolutionDialog1();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

