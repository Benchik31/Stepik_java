package swing4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class CustomCursorExample extends JPanel {

    private BufferedImage cursorImage;

    public CustomCursorExample() {
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.WHITE);

        try {
            cursorImage = ImageIO.read(new File("image.png"));
        } catch (Exception e) {
            System.out.println("Ошибка загрузки изображения курсора: " + e.getMessage());
        }

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor customCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "custom cursor");
        setCursor(customCursor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(100, 100, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Кастомный курсор");
        CustomCursorExample panel = new CustomCursorExample();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

