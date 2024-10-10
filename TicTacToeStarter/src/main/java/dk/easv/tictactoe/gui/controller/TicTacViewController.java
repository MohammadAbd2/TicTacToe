package dk.easv.tictactoe.gui.controller;

// Java imports
import dk.easv.tictactoe.bll.GameButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

// Project imports
import dk.easv.tictactoe.bll.GameBoard;
import dk.easv.tictactoe.bll.IGameBoard;

public class TicTacViewController implements Initializable {

    @FXML
    public GameButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    @FXML
    public Label lblPlayer;

    @FXML
    public Label lblPlayerOScore;
    private int Oscore = 0;
    @FXML
    public Label lblPlayerXScore;
    private int Xscore = 0;

    @FXML
    public Label lblTieScore;
    private int Tiescore = 0;



    @FXML
    private GameButton btnNewGame;

    @FXML
    private GridPane gridPane;

    private static final String TXT_PLAYER = "Player: ";
    private IGameBoard game;
    private boolean xOrO = false; // Keeps track of which player is playing (X or O)
    private boolean gameended = false;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        GameButton btn = (GameButton) event.getSource();
        Integer row = GridPane.getRowIndex((Node) event.getSource());
        Integer col = GridPane.getColumnIndex((Node) event.getSource());
        int r = (row == null) ? 0 : row;
        int c = (col == null) ? 0 : col;

        if (game.play(c, r)) {
            String imagePath = xOrO ? "images/xPhoto.png" : "images/oPhoto.png";
            Image img = new Image(imagePath);
            ImageView imageView = new ImageView(img);

            // Resize the image if needed
            imageView.setFitWidth(140);  // Adjust as per your button size
            imageView.setFitHeight(115);  // Adjust as per your button size
            btn.setGraphic(imageView);
            btn.setStatus(true);
            xOrO = !xOrO; // Switch player

            if (game.isGameOver() ) {
                if(!gameended){
                    int winner = game.getWinner();
                    displayWinner(winner);
                    gameended = true;
                }


            } else {
                lblPlayer.setText(TXT_PLAYER + game.getNextPlayer()); // Update player text
            }
        }
    }

    @FXML
    private void handleNewGame(ActionEvent event) {
        game.newGame();
        clearBoard();
        lblPlayer.setText(TXT_PLAYER + "0"); // Reset text to Player 0
        gameended = false;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new GameBoard();
        lblPlayer.setText(TXT_PLAYER + "1"); // Initialize with Player 0
    }

    public void displayWinner(int winner) {
        String message = "";
        if(winner == 2){
            message = "It's a draw :-(";
            Tiescore++;
            lblTieScore.setText("Tie: " + Tiescore);
        } else if (winner == 1) {
            message = "Player " + winner + " wins!!!";
            Oscore++;
            lblPlayerOScore.setText("Player O: " + Oscore);
        }else if (winner == 0) {
            message = "Player " + winner + " wins!!!";
            Xscore++;
            lblPlayerXScore.setText("Player X: " + Xscore);
        }

        lblPlayer.setText(message);
    }

    private void clearBoard() {
        for (Node n : gridPane.getChildren()) {
            if (n instanceof GameButton) {
                GameButton btn = (GameButton) n;
                btn.setGraphic(null);
                btn.setStatus(false);
            }
        }
    }
}
