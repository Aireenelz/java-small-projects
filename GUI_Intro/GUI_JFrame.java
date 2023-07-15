/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI_Intro;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author Aireen
 */
public class GUI_JFrame {
    
    public static void main(String[] args) {
        
        // JFrame = a GUI window to add components to
        
        JFrame frame = new JFrame(); // create a frame
        
        frame.setTitle("Title goes here"); // set title of frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when display frame, then u press X button it'll only hide it without exiting the program, therefore this line of code is to exit it instead of just hiding the frame
        
        frame.setResizable(false); // prevent frame from being resized
        frame.setSize(420, 420); // set dimension of frame
        frame.setVisible(true); // make frame visible (if no set to true, won't be visible)
        
        // Default icon on top left frame is java mug, to change, do this
        ImageIcon image = new ImageIcon("src/GUI_Intro/inumaki.jpg"); // create an ImageIcon
        frame.setIconImage(image.getImage()); // change icon of frame

        // Change colour of panel
        frame.getContentPane().setBackground(new Color(255, 229, 180)); // RGB 1-255, or can also use hexadecimal value
    }
}

/*
* or instead of putting everything in main, can do in separate java class files:

public class Main {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
    }
}

public class MyFrame extends JFrame {
    MyFrame() {
        this.setTitle("Title goes here"); // set title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // when display frame, then u press X button it'll only hide it without exiting the program, therefore this line of code is to exit it instead of just hiding the frame
        
        this.setResizable(false); // prevent frame from being resized
        this.setSize(420, 420); // set dimension of frame
        this.setVisible(true); // make frame visible (if no set to true, won't be visible)
        
        // Default icon on top left frame is java mug, to change, do this
        ImageIcon image = new ImageIcon("src/GUI_Intro/inumaki.jpg"); // create an ImageIcon
        this.setIconImage(image.getImage()); // change icon of frame

        // Change colour of panel
        this.getContentPane().setBackground(new Color(255, 229, 180));
    }
}

*/