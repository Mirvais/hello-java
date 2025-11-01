import javax.swing.*;
import java.awt.*;

/**
 * Executable example showing a JFrame with BorderLayout:
 * - NORTH: a top bar with two buttons
 * - CENTER: a main area panel (stretches to fill)
 * - SOUTH: a bottom bar with three buttons, padding, and background color
 */
public class LayoutEx {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LayoutEx().createAndShow());
    }

    private void createAndShow() {
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the content pane (BorderLayout by default)
        Container pane = frame.getContentPane();

        //-----------------
        // NORTH PANEL: a simple top bar with two buttons (FlowLayout by default)
        JPanel northPanel = new JPanel();
        northPanel.add(new JButton("one"));
        northPanel.add(new JButton("two"));
        pane.add(northPanel, BorderLayout.NORTH);

        //-----------------
        // CENTER PANEL: the main area; preferred size affects pack() but it will expand to fill
        JPanel center = new JPanel();
        center.setPreferredSize(new Dimension(100, 50));
        pane.add(center, BorderLayout.CENTER);

        //-----------------
        // SOUTH PANEL: a bottom bar with three buttons, extra padding, and background color
        JPanel southPanel = new JPanel();
        southPanel.add(new JButton("three"));
        southPanel.add(new JButton("four"));
        southPanel.add(new JButton("five"));
        southPanel.setBackground(new Color(173, 202, 184));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        pane.add(southPanel, BorderLayout.SOUTH);

        //-----------------
        frame.pack();                      // size to preferred sizes
        frame.setLocationByPlatform(true); // let the OS choose a good location
        frame.setVisible(true);            // show the window
    }
}
