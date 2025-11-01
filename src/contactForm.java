//==============
/* Contact Form — Swing + AWT demo using GridBagLayout and BorderLayout.
   Formats and separators adjusted as requested. */
//==============

 //--- Abstract Window Toolkit (AWT)
// Provides layout manager for arranging components in five regions: 
// north, south, east, west, and center.
import java.awt.BorderLayout;

// Grid layout - Specifies constraints for components that are laid out using the GridBagLayout.
import java.awt.GridBagConstraints;

// Grid - layout manager that aligns components vertically and horizontally, 
// without requiring the components to be of the same size.
import java.awt.GridBagLayout;

// Gird padding - Specifies the space (padding) between components and their borders.
import java.awt.Insets;

// Button - Provides the capability to handle action events like button clicks.
import java.awt.event.ActionEvent;

// Button event - Allows handling of action events, such as button clicks.
import java.awt.event.ActionListener;

//--- swing GUI
// Button - Provides a button component that can trigger actions when clicked.
import javax.swing.JButton;

// Frame - Provides a window with decorations 
// such as a title, border, and buttons for closing and minimizing.
import javax.swing.JFrame;

// Labels - Provides a display area for a short text string or an image, or both.
import javax.swing.JLabel;

// Submition Message - Provides standard dialog boxes such as message, input, and confirmation dialogs.
import javax.swing.JOptionPane;

// Panel - Provides a generic container for grouping components together.
import javax.swing.JPanel;

// Scroll user message - Provides to the a scrollable view of a lightweight component.
import javax.swing.JScrollPane;

// User message - Provides a multi-line area to display/edit plain text.
import javax.swing.JTextArea;

// Name & Email - Provides a single-line text field for user input.
import javax.swing.JTextField;

 /* This class generates a simple contact form. The form includes fields for the
   user's name, email, and message, and a submit button to submit the form. */

 public class contactForm {

 //The main method to create and display the contact form.
  public static void main(String[] args) {

     //==============
    // Frame 
    //==============

     JFrame frame = new JFrame("Contact Form");
    // Initializes frame

     frame.setSize(400, 300);  
    // Set the size of the frame

     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Close the application when the frame is closed

     frame.setLayout(new BorderLayout());  
    // Use BorderLayout for the frame

     //==============
    // Panel 
    //==============

     
    JPanel panel = new JPanel(new GridBagLayout());
    // Initializes panel

     GridBagConstraints gridForm = new GridBagConstraints();

     
    gridForm.insets = new Insets(5, 5, 5, 5);  
    // Add padding around components

     //----------------
    // Creates and adds grid components to the panel

     JLabel nameLabel = new JLabel("Name:");

     gridForm.gridx = 0;  
    // Position at column 0

     gridForm.gridy = 0;  
    // Position at row 0

     panel.add(nameLabel, gridForm);

     
    //----------------
    // Add text field for name input
    JTextField nameField = new JTextField(20);

     gridForm.gridx = 1;  
    // Position at column 1

     gridForm.gridy = 0;  
    // Position at row 0

     panel.add(nameField, gridForm);

     
    //----------------
    // Email
    JLabel emailLabel = new JLabel("Email:");

     gridForm.gridx = 0;  
    // Position at column 0

     gridForm.gridy = 1;  
    // Position at row 1

     panel.add(emailLabel, gridForm);

     
    //----------------
    // Adds text field for email input
    JTextField emailField = new JTextField(20);

     gridForm.gridx = 1;  
    // Position at column 1

     gridForm.gridy = 1;  
    // Position at row 1

     panel.add(emailField, gridForm);


     
    //----------------
    // Adds "Message" label
    JLabel messageLabel = new JLabel("Message:");

     gridForm.gridx = 0;  
    // Position at column 0

     gridForm.gridy = 2;  
    // Position at row 2

     panel.add(messageLabel, gridForm);


     
    //----------------
    // Message area with scroll pane
    JTextArea messageArea = new JTextArea(5, 20);

     JScrollPane scrollPane = new JScrollPane(messageArea);

     gridForm.gridx = 1;  
    // Position at column 1

     gridForm.gridy = 2;  
    // Position at row 2

     panel.add(scrollPane, gridForm);


     
    //----------------
    // Adds "Submit" button
    JButton submitButton = new JButton("Submit");

     gridForm.gridx = 1;  
    // Position at column 1

     gridForm.gridy = 3;  
    // Position at row 3

     panel.add(submitButton, gridForm);


     
    //----------------
    // Add the panel to the frame's center
    frame.add(panel, BorderLayout.CENTER);

     
    //----------------
    // Make the frame visible
    frame.setVisible(true);

     
    //==============
    // JDialog
    //==============

     
    //----------------
    // Add action listener to the submit button
    ActionListener submitBtnClicked = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

         // Display a message dialog when the submit button is clicked
        JOptionPane.showMessageDialog(frame, "Message was sent!");


       }
    };

     
    //----------------
    // Wire listener to the button
    submitButton.addActionListener(submitBtnClicked);
  }
}
