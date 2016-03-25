package ru.vrnsky.clinic;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 29.02.16
 * Time: 15:19
 * This test class for test dog class
 */
//TODO write docs
public class DogTest extends TestCase {

    private Dog dog = new Dog("Argus");


    @Test
    public void testSetName() throws Exception {
        dog.setName("Harding");
        assertEquals("Harding", dog.getName());
    }

    @Test
    public void testGetName() throws Exception {
        dog.setName("Gaus");
        assertEquals("Gaus", dog.getName());
    }

    @Test
    public void testIsHungry() throws Exception {
        assertEquals(false, dog.isHungry());
    }
}
