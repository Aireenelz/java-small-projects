/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AsciiArt;

/**
 *
 * @author Aireen
 */
public class StickAnimation {
    public static void main(String[] args) throws InterruptedException {
        // A movie or animation is where a lot of frames being played in one second
        // Eg. a movie usually plays 24-30 frames per second
        // For this running stickman animation, we will do 2 frames
        
        while (true) {
            System.out.println("   O   ");
            System.out.println("  /|\\/ ");
            System.out.println(" \\/\\    ");
            System.out.println("   /  ");
            Thread.sleep(100); // to delay before printing the next frame (100ms)

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println("   O   ");
            System.out.println("  /|\\/ ");
            System.out.println("   /\\    ");
            System.out.println("  /  |   ");
            Thread.sleep(100);

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}

// Ascii characters total 128
// 95 displayable ascii characters are: 
// abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ 1234567890 !@#$%^&*()_+-=|~`\[]{};',./:"<>? space
// 26 + 26 + 10 + 33 = 95
