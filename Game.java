import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
public class Game {
    public static void main(String[] args){
        GameWindow window = new GameWindow();// Creates the game window object
        Button button1 = new Button(); // Creates the first button
        Button button2 = new Button(); // Creates the second button
        Button button3 = new Button(); // Creates the third button
        Button button4 = new Button(); // Creates the fourth button
        Color red = new Color(220, 20, 60); // Creates the red colour object
        Color yellow = new Color(255, 215, 0); // Creates the yellow colour object
        Color blue = new Color(65, 105, 225); // Creates the blue colour object
        Color green = new Color(9, 121, 105); // Creates the green colour object
        Text textLevel = new Text(); // Creates the label that tells the player what level they're on
        MouseInput clicker = new MouseInput(); // Creates the object that will handle user inputs
        window.addAllButtons(button1, button2, button3, button4); // Adds all buttons to game window
        window.add(textLevel); // Adds the label to the game window
        Button[] buttons = {button1, button2, button3, button4}; // Creates an array containing all of our buttons
        Random randBIndex = new Random(); // Creates the Random object to randomly select the game pattern
        ArrayList<Button> pattern = new ArrayList<>(); // Creates the pattern that the user must memorize
        // Game loop
        while (true) {
            Button nextButton = buttons[randBIndex.nextInt(buttons.length)]; // Grabs a random button from the buttons array
            pattern.add(nextButton); // Adds this button to the pattern
            // Displays pattern to user
            for (Button button : pattern) {
                window.delay(1000); // Causes the Thread to sleep for 1 second
                if (button == button1) { // If the button is button1
                    button1.setBackground(red); // Sets the colour background of the button in question to red
                } else if (button == button2) { // Else if the button is button2
                    button2.setBackground(yellow); // Sets the colour background of the button in question to yellow
                } else if (button == button3) { // Else if the button is button3
                    button3.setBackground(blue); // Sets the colour background of the button in question to blue
                } else { // Else the button is button4
                    button4.setBackground(green); // Sets the colour background of the button in question to green
                }
                window.delay(1000); // Causes the Thread to sleep for 1 second
                button.setBackground(null); // Resets the colour of the button to the original colour
            }
            window.delay(1500); // Causes the Thread to sleep for 1.5 seconds
            // Adds the possibility of user inputs being read by the game
            for (Button button : buttons){
                button.addMouseListener(clicker);
            }
            // Loops while the series of inputs by the user doesn't equal the size of the pattern
            while (clicker.getUserInputs().size() < pattern.size()) {
                System.out.println("Please press a button");
            }
            // Removes the possibility of user inputs being read by the game
            for (Button button : buttons){
                button.removeMouseListener(clicker);
            }
            // Checks if the pattern matches the series of inputs done by the user
            if (clicker.getUserInputs().equals(pattern)) {
                textLevel.nextLevel(); // Moves onto the next level
                clicker.getUserInputs().clear(); // Clears the inputs just done by the user
            } else { // Else the user made a mistake and the game loop is to be terminated
                break;
            }
        }
        // Erases anything written in the terminal of the user
        try {
            String userOS = System.getProperty("os.name"); // Grabs the name of the user's OS
            if (userOS.equalsIgnoreCase("Windows")) { // If the user is running this on Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // This will clear the terminal
            } else { // Else the user is most likely running a UNIX OS
                // This clears their terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
        catch (Exception e) {e.printStackTrace();} // Catches the general Exception
        System.out.println("Nice job, you got to Level " + textLevel.getLevel() + "!"); // Prints out to the console how far the user got
        System.exit(0); // Closes the GUI
    }
}
