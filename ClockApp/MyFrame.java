/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClockApp;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Aireen
 */
public class MyFrame extends JFrame {
    
    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    
    MyFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock App");
        this.setLayout(new FlowLayout());
        this.setSize(350, 250);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        
        timeFormat = new SimpleDateFormat("hh:mm:ss a"); // time in format of hourhour:minmin:secondsecond am/pm
        dayFormat = new SimpleDateFormat("EEEE"); // day name spelled fully usign four E's
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy"); // use five M's to display the month name
        
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(Color.black);
        timeLabel.setBackground(Color.pink);
        timeLabel.setOpaque(true);
        
        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
        
        // Add the labels to the frame
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        
        // Set visibility
        this.setVisible(true);
        
        // Call method setTime to update ui every second
        setTime();
    }
    
    public void setTime() {
        while(true) {
            // Get the current time and store it in the string var "time"
            time = timeFormat.format(Calendar.getInstance().getTime());
            // Set timeLabel with the time acquired
            timeLabel.setText(time);

            // Get the current day and store it in the string var "day"
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            
            // Get the current date and store it in the string var "date"
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
        
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
}
