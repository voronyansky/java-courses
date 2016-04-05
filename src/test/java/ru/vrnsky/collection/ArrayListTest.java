package ru.vrnsky.collection;

import org.junit.Test;
import ru.vrnsky.clinic.Client;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Egor on 02.04.2016.
 */
public class ArrayListTest {

    List<Client> clients = new ArrayList<Client>();

    @Test
    public void testSize() throws Exception {
        assertEquals(10,clients.size());

    }

    @Test
    public void testContains() throws Exception {
        Client client = new Client("Egor");
        clients.add(client);
        assertEquals(true, clients.contains(client));

    }

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
     * Не проходит тесты
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