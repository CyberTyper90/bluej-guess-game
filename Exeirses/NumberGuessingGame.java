import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumberGuessingGame extends JFrame implements ActionListener {

    private JTextField guessField;
    private JButton guessButton, restartButton;
    private JLabel messageLabel, triesLabel;
    private int numberToGuess, numberOfTries;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        messageLabel = new JLabel("Guess a number between 1 and 100:");
        messageLabel.setBounds(50, 20, 300, 25);
        add(messageLabel);

        guessField = new JTextField();
        guessField.setBounds(50, 50, 100, 25);
        add(guessField);

        guessButton = new JButton("Guess");
        guessButton.setBounds(170, 50, 80, 25);
        guessButton.addActionListener(this);
        add(guessButton);

        restartButton = new JButton("Restart");
        restartButton.setBounds(260, 50, 90, 25);
        restartButton.addActionListener(e -> restartGame());
        add(restartButton);

        triesLabel = new JLabel("Tries: 0");
        triesLabel.setBounds(50, 90, 300, 25);
        add(triesLabel);

        restartGame();
        setVisible(true);
    }

    private void restartGame() {
        Random rand = new Random();
        numberToGuess = rand.nextInt(1000) + 1; // 1-100
        numberOfTries = 0;
        messageLabel.setText("Guess a number between 1 and 100:");
        triesLabel.setText("Tries: 0");
        guessField.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int guess = Integer.parseInt(guessField.getText());
            numberOfTries++;
            if (guess < numberToGuess) {
                messageLabel.setText("Too low! Try again:");
            } else if (guess > numberToGuess) {
                messageLabel.setText("Too high! Try again:");
            } else {
                messageLabel.setText("Correct! The number was " + numberToGuess + "!");
                JOptionPane.showMessageDialog(this, "Congratulations! You guessed it in " + numberOfTries + " tries.");
                restartGame();
            }
            triesLabel.setText("Tries: " + numberOfTries);
            guessField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        new NumberGuessingGame();
    }
}
