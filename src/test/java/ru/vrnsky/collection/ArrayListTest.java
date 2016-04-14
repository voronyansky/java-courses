package ru.vrnsky.collection;

import org.junit.Test;
import ru.vrnsky.clinic.Client;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing my array list
 * @author Egor Voronyansky
 * @since 14.04.2016
 */
public class ArrayListTest {

    //Instance of list
    List<Client> clients = new ArrayList<Client>();


    /**
     * Test size of list
     * @throws Exception
     */
    @Test
    public void testSize() throws Exception {
        assertEquals(10,clients.size());

    }

    /**
     * Check have list object
     * @throws Exception
     */
    @Test
    public void testContains() throws Exception {
        Client client = new Client("Egor");
        clients.add(client);
        assertEquals(true, clients.contains(client));

    }

    /**
     * Test convert list to array
     * @throws Exception
     */
    @Test
    public void testToArray() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

        clients.clear();
        Client client = new Client("Egor");
        clients.add(client);
        assertEquals(client,clients.get(0));
    }


    /**
     * Testing remove object from list
     * @throws Exception
     */
    @Test
    public void testRemove() throws Exception {

        clients.clear();
        Client client = new Client("Egor");
        clients.add(client);
        assertEquals(false,clients.remove(client));
    }
}