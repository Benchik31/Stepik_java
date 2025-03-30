package swing2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class SquarePathImage extends JPanel implements ActionListener {

    private BufferedImage originalImage;
    private Image scaledImage;
    private int x = 0;
    private int y = 0;
    private final int SIZE = 50;
    private final int STEP = 2;
    private final Timer timer;
    private String direction = "RIGHT";

    public SquarePathImage() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        try {
            originalImage = ImageIO.read(new File("image.png"));
            scaledImage = originalImage.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки изображения: " + e.getMessage());
        }

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (scaledImage != null) {
            g.drawImage(scaledImage, x, y, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int panelSize = 400 - SIZE;

        switch (direction) {
            case "RIGHT":
                x += STEP;
                if (x >= panelSize) {
                    x = panelSize;
                    direction = "DOWN";
                }
                break;
            case "DOWN":
                y += STEP;
                if (y >= panelSize) {
                    y = panelSize;
                    direction = "LEFT";
                }
                break;
            case "LEFT":
                x -= STEP;
                if (x <= 0) {
                    x = 0;
                    direction = "UP";
                }
                break;
            case "UP":
                y -= STEP;
                if (y <= 0) {
                    y = 0;
                    direction = "RIGHT";
                }
                break;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Квадратная траектория");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SquarePathImage());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
