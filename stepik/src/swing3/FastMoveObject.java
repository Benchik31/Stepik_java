package swing3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FastMoveObject extends JPanel implements KeyListener {

    private BufferedImage rawImage;
    private Image objectImage;

    private final int SIZE = 50;
    private int x = 100;
    private int y = 100;

    public FastMoveObject() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(this);

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
    public void keyReleased(KeyEvent e) {
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        // Проверка: Shift зажат?
        int step = e.isShiftDown() ? SIZE * 2 : SIZE;

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (x - step >= 0) x -= step;
                break;
            case KeyEvent.VK_RIGHT:
                if (x + SIZE + step <= panelWidth) x += step;
                break;
            case KeyEvent.VK_UP:
                if (y - step >= 0) y -= step;
                break;
            case KeyEvent.VK_DOWN:
                if (y + SIZE + step <= panelHeight) y += step;
                break;
        }

        repaint();
    }

    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Быстрое перемещение (Shift)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new FastMoveObject());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
