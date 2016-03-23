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
        field = new Structure(4, 64);
    }
    
    public Game(int size) {
        field = new Structure(size, 64);
    }
    
    public void setToField(int i, int j, int value) {
        field.setValue(i, j, value);
    }
    
    public void process() {
        field.generateNewNumbers();
        System.out.println(field);
        while(true) {
            int choice = scanner.nextInt();
            MoveResults result = MoveResults.CONTINUE;
            switch(choice) {
                case 0: result = moveUp(); break;
                case 1: result = moveRight(); break;
                case 2: result = moveDown(); break;
                case 3: result = moveLeft(); break;
                case -1: result = MoveResults.WIN; break;
                default: System.out.println("Вы нажали не ту клавишу");
            }
            switch(result) {
                case WIN: System.out.println("VICTORY!"); return;
                case LOSE: System.out.println("lose ;C"); return;
                default: break;
            }
        }
    }
    
    public String getField() {
        return field.toString();
    }
    
    public MoveResults moveRight() {
        MoveResults result = field.pushRight();
        afterStep();
        return result;
    }
    
    public MoveResults moveLeft() {
        MoveResults result = field.pushLeft();
        afterStep();
        return result;
    }
    
    public MoveResults moveDown() {
        MoveResults result = field.pushDown();
        afterStep();
        return result;
    }
    
    public MoveResults moveUp() {
        MoveResults result = field.pushUp();
        afterStep();
        return result;
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
