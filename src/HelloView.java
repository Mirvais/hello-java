import javax.swing.*;     // For Swing components (JFrame, JButton, JLabel, etc.)
import java.awt.*;        // For layouts, colors, fonts, and drawing
import java.awt.event.*;  // For event handling (like button clicks)


public class HelloView {

    public HelloView() {
        // Swing runs in the background and this tells Swing to create the view.
        SwingUtilities.invokeLater(() -> createWindow());
    }
    
    //-----------------
    // create the window (JFrame) 
    // and add components.
    private void createWindow() {

        // Create a new window 
        // Name: frame
        // title: "Hello" where title is just a tag
        JFrame frame = new JFrame("Hello");

        // A setter function:
        // The program will end when the user closes the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Getter
        // Gets the container that holds all other components.
        Container pane = frame.getContentPane();

        // Create a label and set its text to "Hello World!".
        JLabel label = new JLabel("Hello World!");
        pane.add(label);

        // Adjust the window size and make it visible.
        frame.pack();
        frame.setVisible(true);
    }

    //-----------------
    public static void main(String[] args) {
        new HelloView();
    }
}