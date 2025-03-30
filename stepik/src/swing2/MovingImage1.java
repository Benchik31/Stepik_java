package swing2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class MovingImage1 extends JPanel implements ActionListener {

    private BufferedImage image;
    private int x = 0;
    private int y = 0;
    private final int STEP = 2;
    private final Timer timer;

    public MovingImage1() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);

        try {
            image = ImageIO.read(new File("image.png"));
        } catch (Exception e) {
            System.out.println("Не удалось загрузить изображение: " + e.getMessage());
        }

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, x, y, null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += STEP;
        y += STEP;

        if (x > getWidth() || y > getHeight()) {
            x = 0;
            y = 0;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Движущееся изображение");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MovingImage1());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

