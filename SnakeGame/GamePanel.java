/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.Random;

/**
 *
 * @author Aireen
 */
public class GamePanel extends JPanel implements ActionListener {
    
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25; // size of object in the game 
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE; // how many objects per screen
    static final int DELAY = 100; // determine how often timer will trigger program action
    
    // Store coordinates of segments of the snake
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    
    int bodyParts = 6;
    int applesEaten = 0; // it is the score
    int appleX; // x coordinate of apple location 
    int appleY; // y coordinate of apple location 
    char direction = 'R'; // snake start with moving to the right 
    boolean running = false;
    
    Timer timer;
    Random random;
    
    GamePanel() {
        random = new Random();
        
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }
    
    public void startGame() {
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {
        if (running) {
            // Draw grid on the game screen  
            for (int i = 0 ; i < SCREEN_HEIGHT / UNIT_SIZE ; i ++) {

                // Vertical lines along the x axis
                // | | |
                // | | |
                g.drawLine(i*UNIT_SIZE, 
                        0, 
                        i*UNIT_SIZE, 
                        SCREEN_HEIGHT); // (x1, y1, x2, y2)

                // Horizontal lines along the y axis
                // ------------
                // ------------
                g.drawLine(0, 
                        i*UNIT_SIZE, 
                        SCREEN_WIDTH, 
                        i*UNIT_SIZE);
            }

            // Draw the apple
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

            // Draw the snake 
            for (int i = 0 ; i < bodyParts ; i++) {
                if (i == 0) {
                    // Snake head
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);

                } else {
                    // Snake body
                    g.setColor(new Color(45, 180, 0));
                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))); // snake can change colors
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }
            
            // Display currect score
            g.setColor(Color.red);
            g.setFont(new Font("Ink Free", Font.BOLD, 40));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
            
        } else {
            gameOver(g);
        }
    }
    
    public void newApple() {
        // Randomly generate x and y coordincates of apple 
        appleX = random.nextInt((int)(SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE; // limit is the number of columns (SCREEN_WIDTH / UNIT_SIZE), then multiple UNIT_SIZE to determine which box to put apple in
        appleY = random.nextInt((int)(SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE; // limit is the number of rows 
    }
    
    // Method to move the snake during the game 
    public void move () {
        for (int i = bodyParts ; i > 0 ; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        switch(direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
        }
    }
    
    // Method to check if snake run into the apple
    public void checkApple() {
        
        // Check if coordinate of snake head == coordinaate of apple
        if ((x[0] == appleX) && (y[0] == appleY)) {
            bodyParts++;
            applesEaten++;
            
            // Generate new apple after previous apple has been eaten
            newApple();
        }
    }
    
    // Method to check if snake's head collides with something
    public void checkCollisions() {
        
        // Check if head collides with body
        for (int i = bodyParts ; i > 0 ; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false; // trigger gameOver method
            }
        }
        
        // Check if head touches left border 
        if (x[0] < 0) {
            running = false;
        }
        
        // Check if head touches right border 
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }
        
        // Check if head touches top border
        if (y[0] < 0) {
            running = false;
        }
        
        // Check if head touches bottom border
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
        }
        
        // Stop game if running == false 
        if (!running) {
            timer.stop();
        }
    }
    
    // Game Over screen
    public void gameOver(Graphics g) {
        // Display final score
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics1 = getFontMetrics(g.getFont());
        g.drawString("Score: " + applesEaten, (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2, g.getFont().getSize());
            
        // Game Over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free", Font.BOLD, 75));
        
        // Align Game Over text to center of screen
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2, SCREEN_HEIGHT / 2);
    }

    // Method to update the game state 
    // Is called each time the timer triggers (DELAY = 100)
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();
    }
    
    public class MyKeyAdapter extends KeyAdapter {
        
        // Method to handle events when user press a key
        // i.e. change direction of snake movement when user press arrow key
        @Override
        public void keyPressed(KeyEvent e) {
            
            // Get the arrow key code that was pressed by user
            switch(e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
            // Note: to move to left, if currently moving to Right direction, means no action will be triggered, and direction of snake remain unchanged
            // To prevent snake head from colliding with its body
        }
    }
}
