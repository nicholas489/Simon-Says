import javax.swing.JButton;
public class Button extends JButton {
    private static int numOfButtons = 0;
    private final String name;
    public Button() {
        setBounds(numOfButtons * 140 + 40, 250, 100, 100); // Sets the orientation of this object in the GUI
        numOfButtons++; // Keeps track of how many Buttons are instantiated
        this.name = "Button " + numOfButtons; // Sets the name of this Button to "Button " + numOfButtons
    }
    @Override
    public String toString() {return name;} // Overrides toString() to return the name of this button
}
