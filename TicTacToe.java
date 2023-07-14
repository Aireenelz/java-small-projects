/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TicTacToe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.List;
/**
 *
 * @author Aireen
 */
public class TicTacToe {

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    
    public static void main(String[] args) {
        
        // Print out the gameboard
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, 
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        printGameBoard(gameBoard);
        
        // Continously run the game
        while(true) {
            // Get user input
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter placement (1-9): ");
            int posPlayer = sc.nextInt();
            
            // Make sure user input doesn't overlap with cpu input
            while (playerPositions.contains(posPlayer) || cpuPositions.contains(posPlayer)) {
                System.out.print("Position taken! Enter a correct position: ");
                posPlayer = sc.nextInt();
            }

            // Put X at user inputted placement
            placePiece(gameBoard, posPlayer, "player");
            
            // Check result
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            // Computer's turn
            Random rand = new Random();
            int posCpu = rand.nextInt(9) + 1;
            
            // Make sure cpu input doesn't overlap with user input
            while (playerPositions.contains(posCpu) || cpuPositions.contains(posCpu)) {
                posCpu = rand.nextInt(9) + 1;
            }
            
            // Put O at cpu placement
            placePiece(gameBoard, posCpu, "cpu");
            
            // Check result
            result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
        
    }
    
    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row : gameBoard) {
            for(char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void placePiece(char[][] gameBoard, int position, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(position);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(position);
        }
        
        switch(position) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default :
                break;
        }
        
        printGameBoard(gameBoard);
    }
    
    public static String checkWinner() {
        // Check conditions:
        // 3 adjacent cols / rows / diagonals
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List posDiagonal = Arrays.asList(3, 5, 7);
        List negDiagonal = Arrays.asList(1, 5, 9);
        
        // List of winning conditions
        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(posDiagonal);
        win.add(negDiagonal);
        
        // Check winner
        for(List l : win) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!\n";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins! Sorry :(\n";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "It's a tie!\n";
            }
        }
        
        return ""; // if no winner yet (game is still ongoing)
    }
}
