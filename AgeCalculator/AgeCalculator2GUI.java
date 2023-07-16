/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgeCalculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Aireen
 */
public class AgeCalculator2GUI implements ActionListener {
    
    private static JLabel promptLabel;
    private static JLabel dayLabel;
    private static JLabel monthLabel;
    private static JLabel yearLabel;
    private static JTextField dayText;
    private static JTextField monthText;
    private static JTextField yearText;
    private static JButton button;
    private static JLabel output;
    
    public AgeCalculator2GUI() {
        // Frame
        JFrame frame = new JFrame();
        frame.setSize(500, 500); // set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close operation
        frame.setTitle("Age calculator"); // set title
        
        // Background
        ImageIcon img = new ImageIcon("src/AgeCalculator/aki.jpg");
        JLabel background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(0, 0, 500, 500);
        frame.add(background);
        
        // Panel
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        
        // Prompt
        promptLabel = new JLabel("Enter your date of birth");
        promptLabel.setBounds(10, 20, 200, 25);
        background.add(promptLabel);
        
        // dayLabel and input
        dayLabel = new JLabel("Day");
        dayLabel.setBounds(10, 50, 80, 25);
        background.add(dayLabel);
        dayText = new JTextField();
        dayText.setBounds(100, 50, 165, 25);
        background.add(dayText);
        
        // monthLabel and input
        monthLabel = new JLabel("Month");
        monthLabel.setBounds(10, 80, 80, 25);
        background.add(monthLabel);
        monthText = new JTextField();
        monthText.setBounds(100, 80, 165, 25);
        background.add(monthText);
        
        // yearLabel and input
        yearLabel = new JLabel("Year");
        yearLabel.setBounds(10, 110, 80, 25);
        background.add(yearLabel);
        yearText = new JTextField();
        yearText.setBounds(100, 110, 165, 25);
        background.add(yearText);
        
        // Button
        button = new JButton("Calculate age");
        button.setBounds(10, 160, 160, 25);
        button.addActionListener(this);
        background.add(button);
        
        // Show output
        output = new JLabel();
        output.setBounds(10, 200, 250, 25);
        background.add(output);
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked"); // check functionality
        
        LocalDate today = LocalDate.now();
        
        if (dayText.getText().isEmpty() || monthText.getText().isEmpty() || yearText.getText().isEmpty()) {
            output.setText("Please enter a complete date of birth");
            return;
        }
        
        int day, month, year;
        try {
            year = Integer.parseInt(yearText.getText());
            month = Integer.parseInt(monthText.getText());
            day = Integer.parseInt(dayText.getText());
        } catch (NumberFormatException ex) {
            output.setText("Please enter a valid numeric date of birth");
            return;
        }
        
        LocalDate birthDate;
        try {
            birthDate = LocalDate.of(year, month, day);
        } catch (DateTimeException ex) {
            output.setText("Please enter a valid date");
            return;
        }
        
        int age = Period.between(birthDate, today).getYears(); // Period.between(startDateInclusive, endDateExclusive);
        output.setText("You are " + age + " years old :3");
        
        System.out.println("You are " + age + " years old"); // for debugging
    }
    
    public static void main(String[] args) {
        AgeCalculator2GUI gui = new AgeCalculator2GUI();
    }
}
