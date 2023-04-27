import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MouseInput implements MouseListener {
    private final ArrayList<Button> userInputs;
    public MouseInput() {
        userInputs = new ArrayList<>(); // Initializes userInputs
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Button buttonSource = (Button) e.getSource(); // Gets the button that was just pressed by the mouse
        // Creates a new SwingWorker object needed for a background thread
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                TimeUnit.MILLISECONDS.sleep(1500);
                return null;
            }
            @Override
            public void done() {
                buttonSource.setBackground(null);
            }
        };
        if (buttonSource.toString().equals("Button 1")) { // If buttonSource.toString returns Button 1
            buttonSource.setBackground(new Color(220, 20, 60)); // Set buttonSource to rgb(220, 20, 60)
        } else if (buttonSource.toString().equals("Button 2")) { // Else if buttonSource.toString returns Button 2
            buttonSource.setBackground(new Color(255, 215, 0)); // Set buttonSource to rgb(255, 215, 0)
        } else if (buttonSource.toString().equals("Button 3")) { // Else if buttonSource.toString returns Button 3
            buttonSource.setBackground(new Color(65, 105, 225)); // Set buttonSource to rgb(65, 105, 225)
        } else if (buttonSource.toString().equals("Button 4")) { // Else if buttonSource.toString returns Button 4
            buttonSource.setBackground(new Color(9, 121, 105)); // Set buttonSource to rgb(9, 121, 105)
        }
        worker.execute(); // executes the background thread
        userInputs.add(buttonSource); // adds the buttonSource to userInput
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    public ArrayList<Button> getUserInputs() {return userInputs;}
}
