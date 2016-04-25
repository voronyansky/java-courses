package ru.vrnsky.clinic;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;


/**
 * Test class for user
 * @author Egor Voronyansky
 * @since 17.04.2016
 */
public class UserTest extends TestCase {

    private List<User> users = new ArrayList<User>();
    private Set<User> setUser = new HashSet<User>();
    private Map<User, User> userMap = new HashMap<User, User>();

    /**
     * Add
     * Explanation of adding operation in array list
     * ArrayList push element to the end of array, if last element in array is empty, else
     * It increasing it's size and this give push element to the end
     *
     * Contains work next method:
     * If element == null find element which equals null and return it's position
     * Otherwise find element by for across each element and compare by equals with
     * searching object
     *
     *
     */
    @Test
    public void testlistContains()
    {
        User user = new User(1,"Egor");
        users.add(user);
        assertTrue(users.contains(user));
    }

    /**
     * Inside set using HashMap, set created by key from map
     * It is provide unique elements in set
     * Find elements in set - by equals and hashCode
     */
    @Test
    public void testSetContains()
    {
        User Egor = new User(1,"Egor");
        User Nastya = new User(2, "Nastya");
        User Vasya = new User(1, "Vasya");

        setUser.add(Egor);
        setUser.add(Nastya);
        setUser.add(Vasya);

        assertTrue(setUser.contains(Egor));
    }

    /**
     * In HashMap realized method containsValue seems next
     * If object for searching == null, then call helper - method containsNullValue
     * which across all elements in map and searching for null elements
     * If it find it, return true, otherwise return false
     *
     * Otherwise, in loop we across all value in map
     * And compare this and parameter by equals
     * If equals give true we return true,
     * Otherwise we return false
     *
     *
     */
    @Test
    public void testMapContains()
    {
        User Egor = new User(1,"Egor");
        User Nastya = new User(2, "Nastya");
        User Vasya = new User(1, "Vasya");

        userMap.put(Egor,Egor);
        userMap.put(Nastya, Nastya);
        userMap.put(Egor, Vasya);
        assertTrue(userMap.containsValue(Vasya));
    }

    /**
     * ArrayList have a special field for store of it elements in array
     * By calling size method we get size of all elements including
     * cell which have null
     */
    @Test
    public void testListSize()
    {
        User user = new User(1,"Egor");
        users.add(user);
        assertEquals(1,users.size());
    }

    /**
     * Inside HashSet using Map
     * By calling size method we call size - method from map
     *
     */
    @Test
    public void testSetSize()
    {
        User Egor = new User(1,"Egor");
        User Nastya = new User(2, "Nastya");
        User Vasya = new User(1, "Vasya");

        setUser.add(Egor);
        setUser.add(Nastya);
        setUser.add(Vasya);

        assertEquals(3, setUser.size());
    }

    /**
     * HashMap have a special field which store count of pair key-value
     */
    @Test
    public void testMapSize()
    {

        User Egor = new User(1,"Egor");
        User Nastya = new User(2, "Nastya");
        User Vasya = new User(1, "Vasya");

        userMap.put(Egor,Egor);
        userMap.put(Nastya, Nastya);
        userMap.put(Egor, Vasya);

        assertEquals(2, userMap.size());
    }




}