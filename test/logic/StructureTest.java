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
        instance.setValue(3, 2, 2);
        instance.pushRight();
        Structure sample = new Structure(size);
        sample.setValue(0, 1, 4);
        sample.setValue(0, 2, 4);
        sample.setValue(0, 3, 4);
        sample.setValue(1, 3, 4);
        sample.setValue(3, 3, 2);
        System.err.println(instance);
        System.err.println(sample);
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
        instance.setValue(0, 0, 8);
        instance.setValue(0, 1, 8);
        instance.setValue(1, 1, 4);
        instance.setValue(1, 2, 4);
        instance.setValue(2, 2, 2);
        instance.setValue(3, 3, 16);

        instance.pushLeft();
        Structure sample = new Structure(size);
        sample.setValue(0, 0, 16);
        sample.setValue(1, 0, 4);
        sample.setValue(1, 1, 4);
        sample.setValue(2, 1, 2);
        sample.setValue(3, 2, 16);
        
        System.err.println(instance);
        System.err.println(sample);
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
        System.out.println("pushDown");
        Structure instance = null;
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pushUp method, of class Structure.
     */
    @Test
    public void testPushUp() {
        System.out.println("pushUp");
        Structure instance = null;
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
