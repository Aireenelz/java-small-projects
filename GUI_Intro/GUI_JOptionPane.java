/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI_Intro;
import javax.swing.JOptionPane;
/**
 *
 * @author Aireen
 */
public class GUI_JOptionPane {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name"); // to get input
        JOptionPane.showMessageDialog(null, "Hello " + name); // to display
        
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age")); // when use input dialog box, it'll return String, therefore need to convert to int
        JOptionPane.showMessageDialog(null, "You are " + age + " years old");
        
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));
        JOptionPane.showMessageDialog(null, "You are " + height + " cm tall");
    }
}
