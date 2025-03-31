package swing4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class MouseAddObject extends JPanel implements MouseListener {

    private BufferedImage rawImage;
    private Image objectImage;
    private final int SIZE = 50;

    private final java.util.List<Point> objectPositions = new ArrayList<>();

    public MouseAddObject() {
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.WHITE);
        addMouseListener(this);

        try {
            rawImage = ImageIO.read(new File("image.png"));
            objectImage = rawImage.getScaledInstance(SIZE, SIZE, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки изображения: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Point p : objectPositions) {
            g.drawImage(objectImage, p.x - SIZE / 2, p.y - SIZE / 2, null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            objectPositions.add(e.getPoint());
            repaint();
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Добавление по клику");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MouseAddObject());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

