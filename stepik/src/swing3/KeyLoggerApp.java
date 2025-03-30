package swing3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class KeyLoggerApp extends JFrame implements KeyListener {

    private BufferedWriter writer;

    public KeyLoggerApp() {
        setTitle("KeyLogger (учебный пример)");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea("Начни печатать что-нибудь...");
        area.setFont(new Font("Arial", Font.PLAIN, 16));
        area.setFocusable(true);
        area.addKeyListener(this);

        add(new JScrollPane(area), BorderLayout.CENTER);

        try {
            writer = new BufferedWriter(new FileWriter("log.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try {
            writer.write(e.getKeyChar());
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override public void keyPressed(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KeyLoggerApp::new);
    }
}

