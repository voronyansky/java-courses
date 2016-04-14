package ru.vrnsky.collection;

import org.junit.Test;
import ru.vrnsky.clinic.Client;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Test for my implementation of linked list
 * @author Egor Voronyansky
 * @since 14.04.2016
 */
public class LinkedListTest {

    private List<Client>  list = new LinkedList<Client>();

    @Test
    public void testSize() throws Exception {

        assertEquals(0,list.size());
    }

    @Test
    public void testIsEmpty() throws Exception {

        assertEquals(true,list.isEmpty());

    }

    /**
     * Fail
     * @throws Exception
     */
    @Test
    public void testContains() throws Exception {

        Client client = new Client("Egor");
        list.add(client);
        assertEquals(true, list.contains(client));
    }

    @Test
    public void testIterator() throws Exception {

    }

    @Test
    public void testToArray() throws Exception {

    }

    @Test
    public void testToArray1() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testContainsAll() throws Exception {

    }

    @Test
    public void testAddAll() throws Exception {

    }

    @Test
    public void testAddAll1() throws Exception {

    }

    @Test
    public void testRemoveAll() throws Exception {

    }

    @Test
    public void testRetainAll() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testSet() throws Exception {

    }

    @Test
    public void testAdd1() throws Exception {

    }

    @Test
    public void testRemove1() throws Exception {

    }

    @Test
    public void testIndexOf() throws Exception {

    }

    @Test
    public void testLastIndexOf() throws Exception {

    }

    @Test
    public void testListIterator() throws Exception {

    }

    @Test
    public void testListIterator1() throws Exception {

    }

    @Test
    public void testSubList() throws Exception {

    }
}