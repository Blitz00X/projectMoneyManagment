import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class GUI {

    public GUI(){
        
        JFrame frame = new JFrame();
        
        JButton button = new JButton("Click");
        JLabel label = new JLabel("Number of clicks");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GroupLayout(panel)); // Corrected this line
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true); // Added this line to make the frame visible
    }

    public static void main(String[] args) {
        new GUI(); // Create an instance of GUI
    }
}
