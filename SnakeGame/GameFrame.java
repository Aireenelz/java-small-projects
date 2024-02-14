/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SnakeGame;

import javax.swing.JFrame;

/**
 *
 * @author Aireen
 */
public class GameFrame extends JFrame {
    
    GameFrame() {
        
        GamePanel panel = new GamePanel();
        this.add(panel);
        
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit program when press close
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }
}
