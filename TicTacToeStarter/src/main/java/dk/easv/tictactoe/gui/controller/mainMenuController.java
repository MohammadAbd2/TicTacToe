package dk.easv.tictactoe.gui.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class mainMenuController {



    @FXML
    private RadioButton rBtnSinglePlayer;
    @FXML
    private RadioButton rBtnMultiPlayer;
    @FXML
    private Button btnPlay;

    public void onPlayAct(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/views/TicTacView.fxml"));
        Parent scene = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        stage.centerOnScreen();

        stage.show();
    }

    public void onRBtnSinglePlayerAct(ActionEvent actionEvent) {
    }

    public void onRBtnMultiPlayerAct(ActionEvent actionEvent) {

    }




    /*
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainMenuController.class.getResource("mainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
     */


}
