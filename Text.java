import javax.swing.*;
public class Text extends JLabel {
    private static int level = 1;
    public Text() {
        this.setsText(level); // Calls setsText of this label with a value of 1 initially
        this.setVisible(true); // Makes Text visible on the GUI
    }
    // Getter method for the level that the player is currently on
    public int getLevel() {return level;}
    private void setsText(int level) {
        this.setText("Level " + level); // Sets the text displayed on the GUI to "Level" + level
        this.setBounds(275, 100, 150, 150); // Sets the orientation of this object in the GUI
    }
    // Method for moving onto the next level of the game
    public void nextLevel() {
        level++; // Increments level
        setsText(level); // Updates the Text of thus label with the updated level number
    }
}
