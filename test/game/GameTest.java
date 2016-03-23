/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import logic.MoveResults;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gea
 */
public class GameTest {
    
    public GameTest() {
    }
    
    /**
     * Test of moveRight method, of class Game.
     */
    @Test
    public void testMoveRight() {
        System.out.println("moveRight");
        Game instance = new Game(3);
        instance.setToField(0, 1, 4);
        instance.setToField(1, 2, 8);
        instance.setToField(2, 1, 32);
        instance.setToField(2, 2, 32);
        MoveResults expResult = MoveResults.WIN;
        MoveResults result = instance.moveRight();
        assertEquals(expResult, result);
    }

    /**
     * Test of moveLeft method, of class Game.
     */
    @Test
    public void testMoveLeft() {
        System.out.println("moveLeft");
        Game instance = new Game(3);
        instance.setToField(0, 1, 4);
        instance.setToField(2, 1, 4);
        instance.setToField(1, 0, 4);
        instance.setToField(1, 2, 4);
        instance.setToField(0, 0, 8);
        instance.setToField(0, 2, 8);
        instance.setToField(1, 1, 8);
        instance.setToField(2, 0, 2);
        MoveResults expResult = MoveResults.LOSE;
        MoveResults result = instance.moveLeft();
        assertEquals(expResult, result);
    }

    /**
     * Test of moveDown method, of class Game.
     */
    @Test
    public void testMoveDown() {
        System.out.println("moveDown");
        Game instance = new Game(3);
        instance.setToField(1, 0, 8);
        instance.setToField(2, 0, 16);
        instance.setToField(1, 1, 4);
        instance.setToField(2, 1, 4);
        instance.setToField(0, 2, 2);
        
        MoveResults expResult = MoveResults.CONTINUE;
        MoveResults result = instance.moveDown();
        assertEquals(expResult, result);
    }

    /**
     * Test of moveUp method, of class Game.
     */
    @Test
    public void testMoveUp() {
        System.out.println("moveUp");
        Game instance = new Game(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                instance.setToField(i, j, 32);
            }
        }
        instance.setToField(0, 0, 2);
        MoveResults expResult = MoveResults.WIN;
        MoveResults result = instance.moveUp();
        assertEquals(expResult, result);
    }

}
