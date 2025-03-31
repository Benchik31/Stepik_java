package swing4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class DraggableObject extends JPanel implements MouseListener, MouseMotionListener {

    private BufferedImage rawImage;
    private Image objectImage;

    private final int SIZE = 50;
    private int x = 100;
    private int y = 100;
    private boolean isDragging = false;

    private int offsetX, offsetY;

    public DraggableObject() {
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.WHITE);

        addMouseListener(this);
        addMouseMotionListener(this);

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
        if (objectImage != null) {
            g.drawImage(objectImage, x, y, null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            if (e.getX() >= x && e.getX() <= x + SIZE && e.getY() >= y && e.getY() <= y + SIZE) {
                isDragging = true;
                offsetX = e.getX() - x;
                offsetY = e.getY() - y;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDragging = false;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (isDragging) {
            x = e.getX() - offsetX;
            y = e.getY() - offsetY;
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Перетаскивание объекта");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DraggableObject());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

