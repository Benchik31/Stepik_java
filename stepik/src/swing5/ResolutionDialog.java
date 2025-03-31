package swing5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResolutionDialog extends JPanel {

    public ResolutionDialog() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        JButton resolutionButton = new JButton("Выберите разрешение");
        resolutionButton.addActionListener(e -> showResolutionDialog());

        add(resolutionButton);
    }

    private void showResolutionDialog() {
        String[] resolutions = {"800x600", "1024x768", "1280x1024", "1920x1080"};
        JComboBox<String> resolutionComboBox = new JComboBox<>(resolutions);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Выберите разрешение экрана:"));
        panel.add(resolutionComboBox);

        int option = JOptionPane.showConfirmDialog(this, panel, "Выбор разрешения", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String selectedResolution = (String) resolutionComboBox.getSelectedItem();
            int width = 800, height = 600;

            switch (selectedResolution) {
                case "800x600":
                    width = 800;
                    height = 600;
                    break;
                case "1024x768":
                    width = 1024;
                    height = 768;
                    break;
                case "1280x1024":
                    width = 1280;
                    height = 1024;
                    break;
                case "1920x1080":
                    width = 1920;
                    height = 1080;
                    break;
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
        ResolutionDialog panel = new ResolutionDialog();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

