import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class GameWindow extends JFrame{
    public GameWindow() {
        this.setTitle("Simon Says Memory Game by Nicholas Caro Lopez"); // Makes the Title at the top of the window
        this.setSize(610,610); // Makes the GUI 610 pixels by 610 pixels
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This line lets the user properly exit the window
        this.setResizable(false); // Makes it so you can't resize the window
        this.setVisible(true); // Makes the GUI visible to the user
        this.setLayout(null); // Sets the components in the GUI to absolute positioning
        this.setLocationRelativeTo(null); // The window will be displayed at the center of the screen
        ImageIcon image = new ImageIcon("Icon.jpg"); // Creates an Image object of Icon.jpg
        this.setIconImage(image.getImage()); // Sets the upper left icon in the window to be Icon.jpg
    }

    // Method to add all of our buttons to GameWindow at once
    public void addAllButtons(Button b1, Button b2, Button b3, Button b4) {
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);
    }

    public void delay(int time) {
        try { // Encapsulates the code in a try-catch block
            TimeUnit.MILLISECONDS.sleep(time); // slows down the GUI for time number of milliseconds
        } catch (InterruptedException ie) { // Catches the InterruptedException that TimeUnit throws
            ie.printStackTrace(); // Prints the entire stackTrace of the exception
        }
    }
}
