/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AsciiArt;

/**
 *
 * @author Aireen
 */
public class BouncyBall {
    public static void main(String[] args) throws InterruptedException {
        // 6 frames
        
        // while(true) to make it run infinitely until u press terminate program
        while (true) {
            System.out.println(" O "); // ball
            System.out.println("   "); // distance
            System.out.println("___"); // floor
            Thread.sleep(100);
            addSpace();

            System.out.println(" | ");
            System.out.println(" O ");
            System.out.println("___");
            Thread.sleep(100);
            addSpace();

            System.out.println("   ");
            System.out.println("   ");
            System.out.println("_O_");
            Thread.sleep(100);
            addSpace();

            System.out.println("   ");
            System.out.println("   ");
            System.out.println("_<>_");
            Thread.sleep(100);
            addSpace();

            System.out.println("   ");
            System.out.println("   ");
            System.out.println("_O_");
            Thread.sleep(100);
            addSpace();

            System.out.println("   ");
            System.out.println(" O ");
            System.out.println("_|_");
            Thread.sleep(100);
            addSpace();
        }
    }
    
    public static void addSpace() {
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
