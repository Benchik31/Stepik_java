package swing2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class OrbitAnimation extends JPanel implements ActionListener {

    private BufferedImage sunImageRaw;
    private BufferedImage earthImageRaw;
    private Image sunImage;
    private Image earthImage;

    private final int EARTH_SIZE = 50;
    private final int SUN_SIZE = 80;

    private double angle = 0;
    private final double delta = 0.01; // скорость вращения
    private final int radius = 120;

    private Timer timer;

    public OrbitAnimation() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);

        try {
            earthImageRaw = ImageIO.read(new File("image1.png"));
            sunImageRaw = ImageIO.read(new File("image2.png"));

            earthImage = earthImageRaw.getScaledInstance(EARTH_SIZE, EARTH_SIZE, Image.SCALE_SMOOTH);
            sunImage = sunImageRaw.getScaledInstance(SUN_SIZE, SUN_SIZE, Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки изображений: " + e.getMessage());
        }

        timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2 - SUN_SIZE / 2;
        int centerY = getHeight() / 2 - SUN_SIZE / 2;

        g.drawImage(sunImage, centerX, centerY, null);

        int earthX = (int) (getWidth() / 2 + radius * Math.cos(angle)) - EARTH_SIZE / 2;
        int earthY = (int) (getHeight() / 2 + radius * Math.sin(angle)) - EARTH_SIZE / 2;

        g.drawImage(earthImage, earthX, earthY, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += delta;
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Солнечная система");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OrbitAnimation());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

