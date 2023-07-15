/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI_Intro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Aireen
 */
public class GUI1 implements ActionListener {
    
    // put these variables outside so that all methods can know about the var
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;
    
    // Constructor
    public GUI1() {
        frame = new JFrame(); // a window
        
        // Button
        JButton button = new JButton("Click me");
        button.addActionListener(this);
        
        // Label
        label = new JLabel("Number of clicks: 00");
        
        // Window layout (panel)
        panel = new JPanel(); // layout of the window
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100)); // 100 pixels of space at top, left, right, and 30 pixels of space at bottom
        panel.setLayout(new GridLayout(0, 1)); // unspecified rows (to dynamically adjust based on num of components added to panel), 1 column (to accommodate for button and label vertically)
        panel.add(button); // add button to the panel after creating object button
        panel.add(label); // add label to panel after creating label object
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ur mom");
        frame.pack();
        frame.setVisible(true);
        
        panel.setBackground(new Color(244, 194, 194)); // set the background color of panel directly, ensuring that only the panel's background is colored, and not the entire content pane of the frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++; // increment count when u click button
        label.setText("Number of clicks: " + count);// show updated number of clicks
    }
    
    public static void main(String[] args) {
        new GUI1(); // create a gui object from the gui class
        // when run the main method, it will call the constructor of GUI1 class
    }
}

// notes

// implements = means u have to take all the methods from ActionListener and put code in them

// when click button
// button.addActionListener(this); --> public class GUI implements ActionListener --> public void actionPerformed(ActionEvent e)
// button listens to click event from the user, then runs codes which changes other object