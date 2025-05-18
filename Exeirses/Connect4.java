import java.util.Scanner;
/**
 * 
 *
 * @author  (Kashan)
 * @version (24/03/2025)
 */
class Connect4 {
 public static void main(String[] args) {
        int[][] board = new int[6][7]; // 6-row, 7-column game board
         Scanner input = new Scanner(System.in);

         // Welcome message
           System.out.println("Welcome to Connect 4!");
            System.out.println("Do you want to be Player 1 or Player 2? ");

         // Choosing player
         int player = 0; // Declare player variable here
        String choice;
        while (true) {
            
            choice = input.next().toLowerCase();
            if (choice.equals("1") || choice.equals("1")) {
                player = 1;
                break;
            } else if (choice.equals("2") || choice.equals("2")) {
                player = 2;
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, one, or two.");
            }
        }

        int opponent = (player == 1) ? 2 : 1; // Opponent is the other player
        int turn = 1;
        boolean gameOver = false;

        while (!gameOver) {
            printBoard(board); // Display board before each turn
            int currentPlayer = (turn % 2 == 1) ? player : opponent; // Determine current player

            int column;
            while (true) {
                // Ask user for column input
                System.out.print("Player " + currentPlayer + "'s turn. Enter a column (0-6): ");
                if (input.hasNextInt()) {
                    column = input.nextInt();
                    if (column >= 0 && column < 7) break; // Valid input
                } else {
                    input.next(); // Consume invalid input
                }
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
            }

            // Place the piece in the board
            int row = -1;
            for (int r = 5; r >= 0; r--) { // Start from the bottom row
                if (board[r][column] == 0) {
                    row = r;
                    board[row][column] = currentPlayer; // Place the piece
                    break;
                }
            }
            if (row == -1) { // Column is full
                System.out.println("Column full. Try another column.");
                continue;
            }

            // Check if the game is won
            if (checkWin(board, currentPlayer)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins");
                gameOver = true;
            }

            turn++; // Switch turn
        }
        input.close(); // Close scanner
    }

    // Check if a player has won
    static boolean checkWin(int[][] board, int player) {
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 7; c++) {
                // Check horizontal win
                if (c + 3 < 7 && board[r][c] == player && board[r][c + 1] == player && board[r][c + 2] == player && board[r][c + 3] == player)
                    return true;

                // Check vertical win
                if (r + 3 < 6 && board[r][c] == player && board[r + 1][c] == player && board[r + 2][c] == player && board[r + 3][c] == player)
                    return true;

                // Check diagonal (top-left to bottom-right)
                if (r + 3 < 6 && c + 3 < 7 && board[r][c] == player && board[r + 1][c + 1] == player && board[r + 2][c + 2] == player && board[r + 3][c + 3] == player)
                    return true;

                // Check diagonal (bottom-left to top-right)
                if (r - 3 >= 0 && c + 3 < 7 && board[r][c] == player && board[r - 1][c + 1] == player && board[r - 2][c + 2] == player && board[r - 3][c + 3] == player)
                    return true;
            }
        }
        return false;
    }

    // Print the board in a table format
    static void printBoard(int[][] board) {
        System.out.println("\nCurrent Board:");
        System.out.println("  0   1   2   3   4   5   6 ");
        System.out.println("+---+---+---+---+---+---+---+");
        for (int[] row : board) {
            System.out.print("|");
            for (int cell : row) {
                System.out.print(" " + (cell == 0 ? " " : (cell == 1 ? "X" : "O")) + " |");
            }
            System.out.println("\n+---+---+---+---+---+---+---+");
        }
    }
}
