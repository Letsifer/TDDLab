package game;

import java.util.Scanner;
import logic.MoveResults;
import logic.Structure;

/**
 *
 * @author gea
 */
public class Game {
    private Structure field;
    private Scanner scanner = new Scanner(System.in);
    
    public Game() {
        field = new Structure(4, 128);
    }
    
    public Game(int size) {
        field = new Structure(size, 128);
    }
    
    public void setToField(int i, int j, int value) {
        field.setValue(i, j, value);
    }
    
    public void process() {
        field.generateNewNumbers(false);
        System.out.println(field);
        MoveResults result = MoveResults.CONTINUE;
        while(result == MoveResults.CONTINUE) {
            int choice = scanner.nextInt();            
            switch(choice) {
                case 0: result = moveUp(); break;
                case 1: result = moveRight(); break;
                case 2: result = moveDown(); break;
                case 3: result = moveLeft(); break;
                case -1: return;
                default: System.out.println("Вы нажали не ту клавишу");
            }
        }
        if (result == MoveResults.WIN) {
            System.out.println("VICTORY!");
        } else {
            System.out.println("lose ;C");
        }
    }
    
    public String getField() {
        return field.toString();
    }
    
    public MoveResults moveRight() {
        MoveResults result = field.pushRight(false);
        afterStep();
        return result;
    }
    
    public MoveResults moveLeft() {
        MoveResults result = field.pushLeft(false);
        afterStep();
        return result;
    }
    
    public MoveResults moveDown() {
        MoveResults result = field.pushDown(false);
        afterStep();
        return result;
    }
    
    public MoveResults moveUp() {
        MoveResults result = field.pushUp(false);
        afterStep();
        return result;
    }
    
    private void afterStep() {
        
        System.out.println(field);
    }
    
    public static void main(String[] args) {
        new Game().process();
        System.out.println("game over");
    }
}
