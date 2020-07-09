import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SquareTester.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SquareTester
{
    @Test
    public void test() {
        JunitTesting test = new JunitTesting();
        int output = test.squareNum(5);
        assertEquals(25, output);
        output = test.squareNum(6);
        assertEquals(36, output);
        output = test.squareNum(-4);
        assertEquals(16, output);
        output = test.squareNum(0);
        assertEquals(0, output);
    }
    
}
