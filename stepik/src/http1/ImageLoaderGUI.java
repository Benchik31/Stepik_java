package http1;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class ImageLoaderGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Котики, Лисички, Собачки");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));

        JButton catButton = new JButton("Котика!");
        JButton dogButton = new JButton("Собачку!");
        JButton foxButton = new JButton("Лисичку!");

        buttonPanel.add(catButton);
        buttonPanel.add(dogButton);
        buttonPanel.add(foxButton);

        frame.add(buttonPanel, BorderLayout.WEST);

        JPanel imagePanel = new JPanel();
        JLabel imageLabel = new JLabel("Здесь будет картинка");
        imagePanel.add(imageLabel);
        frame.add(imagePanel, BorderLayout.CENTER);

        catButton.addActionListener(e -> {
            try {
                ImageIcon icon = loadImage("https://placekitten.com/400/300");
                imageLabel.setIcon(icon);
            } catch (IOException ex) {
                imageLabel.setText("Ошибка при загрузке изображения.");
            }
        });

        dogButton.addActionListener(e -> {
            try {
                ImageIcon icon = loadImage("https://placedog.net/400/300");
                imageLabel.setIcon(icon);
            } catch (IOException ex) {
                imageLabel.setText("Ошибка при загрузке изображения.");
            }
        });

        foxButton.addActionListener(e -> {
            try {
                ImageIcon icon = loadImage("https://randomfox.ca/floof/");
                imageLabel.setIcon(icon);
            } catch (IOException ex) {
                imageLabel.setText("Ошибка при загрузке изображения.");
            }
        });

        frame.setVisible(true);
    }

    public static ImageIcon loadImage(String imageURL) throws IOException {
        URL url = new URL(imageURL);
        BufferedImage image = ImageIO.read(url);
        return new ImageIcon(image);
    }
}

