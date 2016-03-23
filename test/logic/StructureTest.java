package logic;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Евгений
 */
public class StructureTest {

    public StructureTest() {
    }

    /**
     * Test of pushRight method, of class Structure.
     */
    @Test
    public void testPushRight() {
        System.err.println("pushRight");
        final int size = 4;
        Structure instance = new Structure(size);
        instance.setValue(0, 0, 4);
        instance.setValue(0, 1, 4);
        instance.setValue(0, 2, 4);
        instance.setValue(1, 2, 2);
        instance.setValue(1, 3, 2);
        instance.setValue(2, 0, 8);
        instance.setValue(2, 1, 16);
        instance.setValue(3, 1, 8);
        instance.setValue(3, 2, 8);
        instance.setValue(3, 3, 16);
        instance.pushRight(true);
        Structure sample = new Structure(size);
        sample.setValue(0, 2, 4);
        sample.setValue(0, 3, 8);
        sample.setValue(1, 3, 4);
        sample.setValue(2, 2, 8);
        sample.setValue(2, 3, 16);
        sample.setValue(3, 3, 32);
//        System.err.println(instance);
//        System.err.println(sample);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertTrue(instance.getCell(i, j) == sample.getCell(i, j));
            }
        }
    }

    /**
     * Test of pushLeft method, of class Structure.
     */
    @Test
    public void testPushLeft() {
        System.err.println("pushLeft");
        final int size = 4;
        Structure instance = new Structure(size);
        instance.setValue(0, 0, 2);
        instance.setValue(0, 1, 2);
        instance.setValue(0, 2, 2);
        instance.setValue(0, 3, 2);
        instance.setValue(1, 1, 4);
        instance.setValue(1, 2, 8);
        instance.setValue(1, 3, 4);
        instance.setValue(2, 0, 16);
        instance.setValue(2, 2, 16);
        instance.setValue(3, 0, 4);
        instance.setValue(3, 1, 8);
        instance.setValue(3, 3, 8);

        instance.pushLeft(true);
        Structure sample = new Structure(size);
        sample.setValue(0, 0, 8);
        sample.setValue(1, 0, 4);
        sample.setValue(1, 1, 8);
        sample.setValue(1, 2, 4);
        sample.setValue(2, 0, 32);
        sample.setValue(3, 0, 4);
        sample.setValue(3, 1, 16);

//        System.err.println(instance);
//        System.err.println(sample);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertTrue(instance.getCell(i, j) == sample.getCell(i, j));
            }
        }
    }

    /**
     * Test of pushDown method, of class Structure.
     */
    @Test
    public void testPushDown() {
        System.err.println("pushDown");
        final int size = 4;
        Structure instance = new Structure(size);
        instance.setValue(2, 0, 32);
        instance.setValue(3, 0, 16);
        instance.setValue(1, 1, 32);
        instance.setValue(2, 1, 16);
        instance.setValue(0, 2, 8);
        instance.setValue(1, 2, 8);
        instance.setValue(0, 3, 2);
        instance.setValue(2, 3, 2);
        instance.setValue(3, 3, 4);
        instance.pushDown(true);

        Structure sample = new Structure(size);
        sample.setValue(2, 0, 32);
        sample.setValue(3, 0, 16);
        sample.setValue(2, 1, 32);
        sample.setValue(3, 1, 16);
        sample.setValue(3, 2, 16);
        sample.setValue(3, 3, 8);

        System.err.println(instance);
        System.err.println(sample);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertTrue(instance.getCell(i, j) == sample.getCell(i, j));
            }
        }
    }

    /**
     * Test of pushUp method, of class Structure.
     */
    @Test
    public void testPushUp() {
        System.err.println("pushUp");

        final int size = 4;
        Structure instance = new Structure(size);
        instance.setValue(1, 0, 2);
        instance.setValue(2, 0, 4);
        instance.setValue(0, 1, 4);
        instance.setValue(1, 1, 4);
        instance.setValue(0, 2, 8);
        instance.setValue(1, 2, 8);
        instance.setValue(2, 2, 16);
        instance.setValue(3, 2, 32);
        instance.setValue(0, 3, 4);
        instance.setValue(1, 3, 4);
        instance.setValue(2, 3, 8);
        instance.pushUp(true);

        Structure sample = new Structure(size);
        sample.setValue(0, 0, 2);
        sample.setValue(1, 0, 4);
        sample.setValue(0, 1, 8);
        sample.setValue(0, 2, 64);
        sample.setValue(0, 3, 16);

        System.err.println(instance);
        System.err.println(sample);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                assertTrue(instance.getCell(i, j) == sample.getCell(i, j));
            }
        }
    }
    
    @Test
    public void testForWin() {
        System.err.println("from test win");
        final int size = 3;
        Structure instance = new Structure(size);
        for (int i = 0, value = 2; i < size; i++) {
            for (int j = 0; j < size; j++, value *= 2) {
                instance.setValue(i, j, value);
            }
        }
//        System.err.println(instance);
        assertTrue(instance.checkForFinish(true) == MoveResults.WIN);
    }
    
    @Test
    public void testForLose() {
        System.err.println("from test lose");
        final int size = 3;
        Structure instance = new Structure(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch(i + j) {
                    case 1: case 3: instance.setValue(i, j, 4); break;
                    case 0: instance.setValue(i, j, 16); break;
                    case 2: instance.setValue(i, j, 8); break;
                    default: instance.setValue(i, j, 2); break;
                        
                }
            }
        }
        MoveResults answer = instance.checkForFinish(true);
        System.err.println(answer);
        assertTrue(answer == MoveResults.LOSE);
    }
    
    @Test
    public void testForContinueWithMerge() {
        System.err.println("from test merge continue");
        final int size = 3;
        Structure instance = new Structure(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch(i + j) {
                    case 1: case 3: instance.setValue(i, j, 4); break;
                    case 0: instance.setValue(i, j, 4); break;
                    case 2: instance.setValue(i, j, 8); break;
                    default: instance.setValue(i, j, 2); break;
                        
                }
            }
        }
        MoveResults answer = instance.checkForFinish(true);
        System.err.println(answer);
        assertTrue(answer == MoveResults.CONTINUE);
    }
    
    @Test
    public void testForContinueWithoutMerge() {
        System.err.println("from test push continue");
        final int size = 3;
        Structure instance = new Structure(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch(i + j) {
                    case 1: case 3: instance.setValue(i, j, 4); break;
                    case 0: instance.setValue(i, j, 16); break;
                    case 2: instance.setValue(i, j, 8); break;
                    default: instance.setValue(i, j, 0); break;
                        
                }
            }
        }
        MoveResults answer = instance.checkForFinish(true);
        System.err.println(answer);
        assertTrue(answer == MoveResults.CONTINUE);
    }
    
}
