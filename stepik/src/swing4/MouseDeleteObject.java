package swing4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class MouseDeleteObject extends JPanel implements MouseListener, MouseWheelListener {

    private BufferedImage rawImage;
    private Image objectImage;
    private final int SIZE = 50;

    private final java.util.List<Point> objectPositions = new ArrayList<>();

    public MouseDeleteObject() {
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseWheelListener(this);

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

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Point clickPoint = e.getPoint();
        for (int i = 0; i < objectPositions.size(); i++) {
            Point obj = objectPositions.get(i);

            double distance = Math.sqrt(Math.pow(clickPoint.x - obj.x, 2) + Math.pow(clickPoint.y - obj.y, 2));

            if (distance <= SIZE / 2) {
                objectPositions.remove(i);
                repaint();
                break;
            }
        }
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Удаление объекта по колесику мыши");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MouseDeleteObject());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

