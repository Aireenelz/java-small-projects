/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PingPongGame;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Aireen
 */
public class GameFrame extends JFrame {
    
    GamePanel panel;
    
    GameFrame() {
        panel = new GamePanel();
        this.add(panel);
        
        this.setTitle("Ping Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // adjust the frame to fit exactly to the game panel components
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
