package game;

import java.util.Scanner;
import logic.Structure;

/**
 *
 * @author gea
 */
public class Game {
    private Structure field;
    private Scanner scanner;
    
    public Game() {
        field = new Structure(4);
        scanner = new Scanner(System.in);
    }
    
    public void process() {
        field.generateNewNumbers();
        field.generateNewNumbers();
        System.out.println(field);
        while(true) {
            int choice = scanner.nextInt();
            switch(choice) {
                case 0: moveUp(); break;
                case 1: moveRight(); break;
                case 2: moveDown(); break;
                case 3: moveLeft(); break;
                default: return;
            }
        }
    }
    
    public String getField() {
        return field.toString();
    }
    
    public void moveRight() {
        field.pushRight();
        afterStep();
    }
    
    public void moveLeft() {
        field.pushLeft();
        afterStep();
    }
    
    public void moveDown() {
        field.pushDown();
        afterStep();
    }
    
    public void moveUp() {
        field.pushUp();
        afterStep();
    }
    
    private void afterStep() {
        System.out.flush();
        System.out.println(field);
    }
    
    public static void main(String[] args) {
        new Game().process();
        System.out.println("game over");
    }
}
