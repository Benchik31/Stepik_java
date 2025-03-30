package swing2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;

public class CarRace extends JPanel implements ActionListener {

    private final int NUM_CARS = 5;
    private final int CAR_WIDTH = 100;
    private final int CAR_HEIGHT = 50;
    private final int START_X = 0;
    private final int START_Y = 50;
    private final int GAP = 60;
    private final int FINISH_LINE;

    private BufferedImage[] carImages = new BufferedImage[NUM_CARS];
    private Image[] scaledCars = new Image[NUM_CARS];
    private int[] carX = new int[NUM_CARS];
    private boolean raceStarted = false;
    private boolean raceOver = false;
    private int winnerIndex = -1;

    private Timer raceTimer;
    private Random rand = new Random();

    public CarRace() {
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.WHITE);
        FINISH_LINE = 700;

        try {
            carImages[0] = ImageIO.read(new File("car1.png"));
            carImages[1] = ImageIO.read(new File("car1.png"));
            carImages[2] = ImageIO.read(new File("car1.png"));
            carImages[3] = ImageIO.read(new File("car1.png"));
            carImages[4] = ImageIO.read(new File("car1.png"));

            for (int i = 0; i < NUM_CARS; i++) {
                scaledCars[i] = carImages[i].getScaledInstance(CAR_WIDTH, CAR_HEIGHT, Image.SCALE_SMOOTH);
                carX[i] = START_X;
            }
        } catch (Exception e) {
            System.out.println("Ошибка загрузки изображений: " + e.getMessage());
        }

        raceTimer = new Timer(30, this);
        raceTimer.setInitialDelay(3000); // 3 секунды ожидание
        raceTimer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Рисуем финишную черту
        g.setColor(Color.RED);
        g.fillRect(FINISH_LINE, 0, 5, getHeight());

        // Рисуем машинки
        for (int i = 0; i < NUM_CARS; i++) {
            g.drawImage(scaledCars[i], carX[i], START_Y + i * GAP, null);
        }

        // Победитель
        if (raceOver && winnerIndex != -1) {
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.setColor(Color.BLUE);
            String text = "Победитель: Машинка " + (winnerIndex + 1);
            int textWidth = g.getFontMetrics().stringWidth(text);
            g.drawString(text, (getWidth() - textWidth) / 2, getHeight() / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (raceOver) return;

        raceStarted = true;

        for (int i = 0; i < NUM_CARS; i++) {
            int step = rand.nextInt(5) + 1; // от 1 до 5
            carX[i] += step;

            if (carX[i] + CAR_WIDTH >= FINISH_LINE) {
                raceOver = true;
                winnerIndex = i;
                raceTimer.stop();
                break;
            }
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Гонки Машинок");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CarRace());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

