package dk.easv.tictactoe.bll;
import javafx.scene.control.Button;

public class GameButton extends Button {
    private boolean playerID = true;
    private boolean status = false;

    public GameButton() {
        super();  // Call the constructor of Button class
    }


    // Set the player id to true/false
    public void setPlayerId(boolean setPlayerId){
        this.playerID = setPlayerId;
    }

    // Get the PlayerId for the button
    public boolean getPlayerId(){
        return this.playerID;
    }

    // Set the status of the button to true/false
    public void setStatus(boolean setStatus){
        this.status = setStatus;
    }

    // Get the status of the button
    public boolean getStatus() {
        return this.status;
    }

    // Reset the button to its default state
    public void reset() {
        this.setText("");
        this.status = false;
        this.playerID = true;  // Reset playerID if needed, or handle it elsewhere
    }
}
