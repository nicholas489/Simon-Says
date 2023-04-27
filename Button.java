import javax.swing.JButton;

public class Button extends JButton {
    private static int numOfButtons = 0;
    private final String name;
    public Button() {
        setBounds(numOfButtons * 140 + 40, 250, 100, 100);
        numOfButtons++;
        this.name = "Button " + numOfButtons;
    }
    @Override
    public String toString() {return name;}

}
