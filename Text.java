import javax.swing.*;

public class Text extends JLabel {
    private static int level = 1;
    public Text() {
        this.setsText(level); //
        this.setVisible(true); // Makes Text visible on the GUI
    }
    // Getter method for the level that the player is currently on
    public int getLevel() {return level;}
    private void setsText(int level) {
        this.setText("Level " + level);
        this.setBounds(275, 100, 150, 150);
    }
    // Method
    public void nextLevel() {
        level++;
        setsText(level);
    }
}
