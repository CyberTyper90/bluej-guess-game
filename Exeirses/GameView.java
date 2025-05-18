// GameView.java
import javax.swing.*;
import java.awt.*;

public class GameView extends JFrame {
    JTextField guessField;
    JButton guessButton, restartButton;
    JLabel messageLabel, triesLabel, titleLabel;
    JPanel panel;

    public GameView() {
        setTitle("🎮 Number Guessing Game");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        panel = new JPanel();
        panel.setBackground(new Color(50, 50, 100));
        panel.setLayout(null);
        add(panel);

        titleLabel = new JLabel("🎯 Guess The Number!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(Color.CYAN);
        titleLabel.setBounds(100, 30, 400, 50);
        panel.add(titleLabel);

        messageLabel = new JLabel("Guess 1-100...", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setBounds(100, 100, 400, 30);
        panel.add(messageLabel);

        guessField = new JTextField();
        guessField.setFont(new Font("Arial", Font.PLAIN, 24));
        guessField.setBounds(200, 150, 200, 40);
        panel.add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Arial", Font.BOLD, 20));
        guessButton.setBackground(Color.GREEN);
        guessButton.setBounds(150, 220, 120, 40);
        panel.add(guessButton);

        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.setBackground(Color.ORANGE);
        restartButton.setBounds(320, 220, 120, 40);
        panel.add(restartButton);

        triesLabel = new JLabel("Tries: 0", SwingConstants.CENTER);
        triesLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        triesLabel.setForeground(Color.WHITE);
        triesLabel.setBounds(100, 300, 400, 30);
        panel.add(triesLabel);
    }
}
