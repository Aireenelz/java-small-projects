/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import javax.swing.JFrame;

/**
 *
 * @author Aireen
 */
public class App {
    public static void main(String[] args) {
        int boardWidth = 360;
        int boardHeight = 640;
        
        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FlappyBird flappyBird = new FlappyBird();
        frame.add(flappyBird);
        frame.pack();
        flappyBird.requestFocus(); // enable game to immediately respond to key event when it starts running
        
        // Set visible after done setup frame and added the canvas 
        frame.setVisible(true);
    }
}
