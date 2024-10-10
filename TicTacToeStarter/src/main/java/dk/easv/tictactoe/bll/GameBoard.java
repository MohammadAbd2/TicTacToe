package dk.easv.tictactoe.bll;

import dk.easv.tictactoe.bll.GameButton;
import java.util.ArrayList;
import java.util.List;

public class GameBoard implements IGameBoard {
    private ArrayList<String>[][] gameBoard; // The game board array
    private int currentPlayer; // Current player

    public GameBoard() {
        gameBoard = new ArrayList[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameBoard[i][j] = new ArrayList<>();
            }
        }
        currentPlayer = 0; // Start with player 0
    }

    public int checkBoard() {
        // Check for a win
        // Check rows
        for (int i = 0; i < gameBoard.length; i++) {
            if (gameBoard[i][0].contains("X") && gameBoard[i][1].contains("X") && gameBoard[i][2].contains("X")) {
                return 1; // Player X wins
            }
            if (gameBoard[i][0].contains("O") && gameBoard[i][1].contains("O") && gameBoard[i][2].contains("O")) {
                return 0; // Player O wins
            }
        }

        // Check columns
        for (int j = 0; j < gameBoard[0].length; j++) {
            if (gameBoard[0][j].contains("X") && gameBoard[1][j].contains("X") && gameBoard[2][j].contains("X")) {
                return 1; // Player X wins
            }
            if (gameBoard[0][j].contains("O") && gameBoard[1][j].contains("O") && gameBoard[2][j].contains("O")) {
                return 0; // Player O wins
            }
        }

        // Check diagonals
        if (gameBoard[0][0].contains("X") && gameBoard[1][1].contains("X") && gameBoard[2][2].contains("X")) {
            return 1; // Player X wins
        }
        if (gameBoard[0][2].contains("X") && gameBoard[1][1].contains("X") && gameBoard[2][0].contains("X")) {
            return 1; // Player X wins
        }
        if (gameBoard[0][0].contains("O") && gameBoard[1][1].contains("O") && gameBoard[2][2].contains("O")) {
            return 0; // Player O wins
        }
        if (gameBoard[0][2].contains("O") && gameBoard[1][1].contains("O") && gameBoard[2][0].contains("O")) {
            return 0; // Player O wins
        }

        // Check for a draw
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j].isEmpty()) {
                    return -1; // Game is ongoing
                }
            }
        }

        return 2; // Draw
    }

    public int getNextPlayer() {
        return currentPlayer;
    }

    public boolean play(int col, int row) {
        if (col >= 0 && col < 3 && row >= 0 && row < 3 && gameBoard[row][col].isEmpty()) {
            gameBoard[row][col].add(currentPlayer == 0 ? "X" : "O");
            currentPlayer = (currentPlayer + 1) % 2; // Switch player
            return true;
        }
        return false; // Move not accepted
    }

    public boolean isGameOver() {
        return checkBoard() != -1;
    }

    @Override
    public int getWinner() {
        return checkBoard();
    }

    public void newGame() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                gameBoard[i][j].clear();
            }
        }
        currentPlayer = 0; // Reset current player
    }
}
