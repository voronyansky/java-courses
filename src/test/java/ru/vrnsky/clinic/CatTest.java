package ru.vrnsky.clinic;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 29.02.16
 * Time: 15:20
 * This class for test cat
 */
//Todo write docs
public class CatTest extends TestCase {

    private Cat cat  = new Cat("Manny");
    @Test
    public void testSetName() throws Exception {
        cat.setName("Google");
        assertEquals("Google", cat.getName());
    }

    @Test
    public void testGetName() throws Exception {
        cat.setName("Peter");
        assertEquals("Peter", cat.getName());
    }

    @Test
    public void testIsHungry() throws Exception {
        assertEquals(true, cat.isHungry());
    }
}
