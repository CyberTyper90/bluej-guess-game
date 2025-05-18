// GameController.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private GameModel model;
    private GameView view;

    public GameController(GameModel model, GameView view) {
        this.model = model;
        this.view = view;

        view.guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleGuess();
            }
        });

        view.restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
    }

    private void handleGuess() {
        try {
            int guess = Integer.parseInt(view.guessField.getText());
            int result = model.guess(guess);

            if (result == -1) {
                view.messageLabel.setText("Too low! Try again ⬇️");
            } else if (result == 1) {
                view.messageLabel.setText("Too high! Try again ⬆️");
            } else {
                view.messageLabel.setText("🎉 Correct! You win!");
                JOptionPane.showMessageDialog(view, "🏆 You guessed it in " + model.getTries() + " tries!");
            }

            view.triesLabel.setText("Tries: " + model.getTries());
            view.guessField.setText("");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "🚫 Please enter a valid number!", "Error", JOptionPane.ERROR_MESSAGE);
            view.guessField.setText("");
        }
    }

    private void restartGame() {
        model.resetGame();
        view.messageLabel.setText("Game restarted! Guess 1-100...");
        view.triesLabel.setText("Tries: 0");
        view.guessField.setText("");
    }
}
