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
public class CountTest
{
    @Test
    public void test() {
        JunitTesting test = new JunitTesting();
        int output = test.countAs("hello world");
        assertEquals(0, output);
        output = test.countAs("Alabama");
        assertEquals(4, output);
        output = test.countAs("This is a test");
        assertEquals(1, output);
        output = test.countAs("Have a nice day!");
        assertEquals(3, output);
    }
    
}
