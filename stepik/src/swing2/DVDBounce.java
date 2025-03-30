package swing2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class DVDBounce extends JPanel implements ActionListener {

    private BufferedImage originalImage;
    private Image dvdImage;
    private final int SIZE = 80;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private final Timer timer;

    public DVDBounce() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);

        try {
            originalImage = ImageIO.read(new File("image.png"));
            dvdImage = originalImage.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки изображения: " + e.getMessage());
        }

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (dvdImage != null) {
            g.drawImage(dvdImage, x, y, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += dx;
        y += dy;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        if (x <= 0 || x + SIZE >= panelWidth) {
            dx = -dx;
        }

        if (y <= 0 || y + SIZE >= panelHeight) {
            dy = -dy;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DVD Bounce");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DVDBounce());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

