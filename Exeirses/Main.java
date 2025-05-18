// Main.java
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameModel model = new GameModel(100); // default 1-100
            GameView view = new GameView();
            new GameController(model, view);
            view.setVisible(true);
        });
    }
}
