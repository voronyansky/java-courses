package ru.vrnsky.clinic;

import junit.framework.TestCase;
import org.junit.Test;
import ru.vrnsky.exception.UserException;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 29.02.16
 * Time: 14:41
 * This is test of client
 */
//TODO write docs
public class ClientTest extends TestCase {

    private Client client = new Client("Google");

    @Test(expected=UserException.class)
    public void testBadClient()
    {
        Client client = new Client("");
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("Google", client.getName());
    }

    @Test
    public void testSetName() throws Exception {
        client.setName("Peter");
        assertEquals("Peter", client.getName());
    }

    @Test
    public void testGetPet() throws Exception {
        assertEquals(null,client.getPet());

    }

    @Test
    public void testSetPet() throws Exception {
        client.setPet(new Cat("Manny"));
        assertEquals("Manny",client.getPet().getName());
    }
}
