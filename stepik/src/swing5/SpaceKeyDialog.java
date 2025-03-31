package swing5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SpaceKeyDialog extends JPanel implements KeyListener {

    public SpaceKeyDialog() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            JOptionPane.showMessageDialog(this, "Ben", "Информация", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Простое окно");
        SpaceKeyDialog panel = new SpaceKeyDialog();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

