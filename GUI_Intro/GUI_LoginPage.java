/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI_Intro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Aireen
 */
public class GUI_LoginPage implements ActionListener {
    
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel pwLabel;
    private static JPasswordField pwText;
    private static JButton button;
    private static JLabel success;
    
    public static void main(String[] args) {
        
        JFrame frame = new JFrame(); // frame is the window
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login page");
        
        ImageIcon icon = new ImageIcon("src/GUI_Intro/ranpo.jpg");
        frame.setIconImage(icon.getImage());
        
        JPanel panel = new JPanel(); // panel is the layout (sort of like the invisible border guidelines for the elements that we're gonna put on it
        frame.add(panel);   
        
        panel.setLayout(null); // for the rows/columns etc
        
        userLabel = new JLabel("User"); // instantiate label object
        userLabel.setBounds(10, 20, 80, 25); // set bound (x, y, width, height) (x,y start from top left corner)
        panel.add(userLabel); // add to panel so that it can be displayed
        
        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
        
        pwLabel = new JLabel("Password");
        pwLabel.setBounds(10, 50, 80, 25);
        panel.add(pwLabel);
        
        pwText = new JPasswordField(); // use JPasswordField for privacy instead of display plain text it will show dots
        pwText.setBounds(100, 50, 165, 25);
        panel.add(pwText);
        
        button = new JButton("Login");
        button.setBounds(130, 80, 80, 25);
        button.addActionListener(new GUI_LoginPage()); // to add action to the button (check if username and pw correct)
        panel.add(button);
        
        // Check if username & password correct, then show success mssg
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);
        
        
        frame.setVisible(true); // display entire frame
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String pw = pwText.getText();
        System.out.println(user + ", " + pw);
        
        // Check if username and password are correct
        if (user.equals("aireen") && pw.equals("urmom")) {
            success.setText("Login successful!");
        } else {
            success.setText("Wrong credentials :(");
        }
    }
}
