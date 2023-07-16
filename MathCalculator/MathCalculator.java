/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MathCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Aireen
 */
public class MathCalculator implements ActionListener {
    
    JFrame frame;
    JPanel panel;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10]; // digits 1-9
    JButton[] functionButtons = new JButton[9]; // operators
    JButton addButton, subButton, mulButton, divButton;
    JButton decimalButton, equalButton, deleteButton, clearButton, negButton;
    
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;
    
    public MathCalculator() {
        
        // Frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
        
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        // Function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negButton = new JButton("(-)");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negButton;
        
        for (int i=0 ; i<9 ; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        
        // Number buttons
        for (int i=0 ; i<10 ; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        
        negButton.setBounds(50, 430, 100, 50);
        deleteButton.setBounds(150, 430, 100, 50);
        clearButton.setBounds(250, 430, 100, 50);
        
        // Panel (layout plan)
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4, 10 pixel spaces between buttons
        
        // Add function buttons & number buttons to the panel (row by row)
        // Row 1
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        // Row 2
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        // Row 3
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        // Row 4
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);
        
        frame.add(textfield);
        frame.add(negButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(panel);
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i=0 ; i<10 ; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textfield.getText());
            
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            
            textfield.setText(String.valueOf(result));
            num1 = result;
        }
        
        if (e.getSource() == clearButton) {
            textfield.setText("");
        }
        if (e.getSource() == deleteButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i=0 ; i<string.length()-1 ; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText());
            temp *= -1;
            textfield.setText(String.valueOf(temp));
        }
        
    }
    
    public static void main(String[] args) {
        
        MathCalculator calc = new MathCalculator();
        
    }
    
}
