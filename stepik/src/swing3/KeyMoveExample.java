package swing3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class KeyMoveExample extends JPanel implements KeyListener {

    private BufferedImage rawImage;
    private Image objectImage;

    private final int SIZE = 50;
    private int x = 100;
    private int y = 100;

    public KeyMoveExample() {
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

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (x - SIZE >= 0) x -= SIZE;
                break;
            case KeyEvent.VK_RIGHT:
                if (x + SIZE * 2 <= panelWidth) x += SIZE;
                break;
            case KeyEvent.VK_UP:
                if (y - SIZE >= 0) y -= SIZE;
                break;
            case KeyEvent.VK_DOWN:
                if (y + SIZE * 2 <= panelHeight) y += SIZE;
                break;
        }

        repaint();
    }
    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Управление по стрелкам");
        KeyMoveExample panel = new KeyMoveExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

