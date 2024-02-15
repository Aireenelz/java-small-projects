/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Aireen
 */
public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    
    int boardWidth = 360;
    int boardHeight = 640;
    
    // Images
    Image backgroundImg;
    Image birdImg;
    Image topPipeImg;
    Image bottomPipeImg;
    
    // Bird
    int birdX = boardWidth / 8; 
    int birdY = boardHeight / 2;
    int birdWidth = 34;
    int birdHeight = 24;
    
    // Pipes
    int pipeX = boardWidth;
    int pipeY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;
    
    // Game logic
    Bird bird;
    
    int velocityY = -15; // game starts with the bird falling downwards because of gravity
    int gravity = 1; // bird is pulled downwards by gravity, player has to press up key to maintain bird's flying movement
    int velocityX = -4; // move pipes to the left (simulates bird moving right)
    
    ArrayList<Pipe> pipes;
    Random random = new Random();
    
    Timer gameLoop;
    Timer placePipesTimer;
    boolean gameOver = false;
    double score = 0;
    
    FlappyBird() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.cyan);
        
        // Enable this particular class to be listening to key events
        setFocusable(true);
        // Respond to key events
        addKeyListener(this);

        // Load images
        backgroundImg = new ImageIcon("src/main/java/flappybirdbg.png").getImage();
        birdImg = new ImageIcon("src/main/java/flappybird.png").getImage();
        topPipeImg = new ImageIcon("src/main/java/toppipe.png").getImage();
        bottomPipeImg = new ImageIcon("src/main/java/bottompipe.png").getImage();

        // Bird 
        bird = new Bird(birdImg);
        
        // Place pipes timer
        // Call the placePipes function to add new pipe every 1.5 seconds
        pipes = new ArrayList<Pipe>();
        placePipesTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipes();
            }
        });
        placePipesTimer.start();
        
        // Game timer
        gameLoop = new Timer(1000/60, this); // action is performed by paintComponent, 60 times per second (1 action every 16.6 ms)
        gameLoop.start();
    }
    
    public void placePipes() {
        
        // Randomise pipes' upward shifts
        // Math.random give values between (0-1)
        // (0-1) * pipeHeight/2 = (0-256)
        // pipeHeight/4 = 128
        // (0-128) - (0-256) = 1/4 pipeHeight --> 3/4 pipeHeight
        int randomPipeY = (int)(pipeY - pipeHeight/4 - Math.random()*(pipeHeight/2));
        
        int openingSpace = boardHeight / 4;
        
        // Top pipe
        Pipe topPipe = new Pipe(topPipeImg);
        topPipe.y = randomPipeY;
        pipes.add(topPipe);
        
        // Bottom pipe
        Pipe bottomPipe = new Pipe(bottomPipeImg);
        bottomPipe.y = topPipe.y + pipeHeight + openingSpace;
        pipes.add(bottomPipe);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g) {
        // Debug statement
        //System.out.println("draw()");
        
        // Background
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
        
        // Bird
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
        
        // Pipes
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }   
        
        // Score
        g.setColor(Color.white);
        g.setFont(new Font("Ink Free", Font.PLAIN, 32));
        if (gameOver) {
            g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
        } else {
            g.drawString(String.valueOf((int) score), 10, 35);
        }
    }
    
    public void move() {
        
        velocityY += gravity;
        
        // Bird movement upwards
        bird.y += velocityY; // update y coordinate of bird by 6
        
        // Prevent bird from moving beyond window's top edge
        bird.y = Math.max(bird.y, 0);
        
        // Pipes movement
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i); // get the pipe at the current position
            pipe.x += velocityX; // move the pipe by 4 pixels to the left
        
            if (!pipe.passed && bird.x > pipe.x + pipe.width) {
                pipe.passed = true;
                score += 0.5; // 0.5 because there are 2 pipes. so 0.5*2 = 1, 1 point for each set of pipes
            }
            
            if (collision(bird, pipe)) {
                gameOver = true;
            }
        }
        
        // Game Over if bird fall down
        if (bird.y > boardHeight) {
            gameOver = true;
        }
    } 
    
    public boolean collision(Bird a, Pipe b) {
        return a.x < b.x + b.width &&   // a's top left corner doesn't reach b's top right corner
               a.x + a.width > b.x &&   // a's top right corner passes b's top left corner
               a.y < b.y + b.height &&  // a's top left corner doesn't reach b's bottom left corner
               a.y + a.height > b.y;    // a's bottom left corner passes b's top left corner
    }

    // ActionListener
    // To update ui every fixed interval
    @Override
    public void actionPerformed(ActionEvent e) {
        // Update position of bird
        move();
        
        // Call paintComponent function to update ui
        repaint();
        
        if (gameOver) {
            placePipesTimer.stop();
            gameLoop.stop();
        }
    }

    // KeyListener
    // Listen to key pressed by player and take actions
    // Note: not using keyTyped and keyReleased
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_UP) {
            velocityY = -10; // when player press key, bird go up by 10 pixels

            // Restart the game after game over
            // By resetting all variables to their default value
            if (gameOver) {
                bird.y = birdY;
                velocityY = 0;
                pipes.clear();
                score = 0;
                gameOver = false;
                gameLoop.start();
                placePipesTimer.start();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    // Class Bird
    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;
        
        Bird(Image img) {
            this.img = img;
        }
    }
    
    // Class Pipe
    class Pipe {
        int x = pipeX;
        int y = pipeY;
        int width = pipeWidth;
        int height = pipeHeight;
        Image img;
        boolean passed = false; // check if bird has passed the pipe to keep track of score
        
        Pipe(Image img) {
            this.img = img;
        }
    }
}
