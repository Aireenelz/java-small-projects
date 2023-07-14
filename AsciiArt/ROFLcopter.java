/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AsciiArt;

/**
 *
 * @author Aireen
 */
public class ROFLcopter {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            addSpace();
            
            System.out.println("         :LOL:ROFL:ROFL                       ");
            System.out.println("           |            ");
            System.out.println("       /--------                     ");
            System.out.println(" LOL=====     []\\                      ");
            System.out.println("  L     \\        \\               ");
            System.out.println("         \\________]              ");
            System.out.println("         ___I____I__       ");
            System.out.println("         ----------/             ");
            System.out.println("                       ");
            System.out.println("                       ");
            Thread.sleep(100); // add delay after each frame
            
            addSpace();

            System.out.println("ROFL:ROFL:LOL:                       ");
            System.out.println("           |            ");
            System.out.println("  L    /--------                     ");
            System.out.println(" LOL=====     []\\                      ");
            System.out.println("        \\        \\               ");
            System.out.println("         \\________]              ");
            System.out.println("         ___I____I__       ");
            System.out.println("         ----------/             ");
            System.out.println("                       ");
            System.out.println("                       ");
            Thread.sleep(100);
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
