package ru.vrnsky.collection;

import java.util.*;

/**
 *
 * This is realization of array list, list which based on array
 * It also dynamic resizable, but may not support features
 * from origiginal ArrayList
 */
public class ArrayList<T> implements List<T> {

    private Object[] values;

    /**
     * Create new array for holding objects
     * By default length of array is 10
     */
    public ArrayList()
    {
        values = new Object[10];
    }

    /**
     * Return a lenght of array without considering
     * what in object in array - client or null
     * @return length of array
     */
    @Override
    public int size() {
        return values.length;
    }

    /**
     * Passes through the array and count null elements
     * @return true if all elements in array null, and false if one or more not null
     */
    @Override
    public boolean isEmpty() {

        int countNull = 0;
        for(int index = 0; index < values.length; index++)
        {
            if(values[index] == null) countNull++;
        }

        return countNull == size();
    }

    /**
     * Passes through the array and search an element
     * @param o - object for search
     * @return true if object exist in array, and false if object doesn't exist in array
     */
    @Override
    public boolean contains(Object o) {

        for(Object value : values)
        {
            if(o.equals(value))
                return true;
        }
        return false;
    }

    /**
     * While we do not use iterator
     * @return iterator object
     */
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * Method for convert our list to array
     * @return array view of list
     */
    @Override
    public Object[] toArray() {
        return values;
    }


    /**
     * Don't use this method
     * @param a
     * @param <T1>
     * @return
     */
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    /**
     * Adding an element in the end of array
     * @param t - it is element
     * @return true if operation success, and false if get stuck
     */
    @Override
    public boolean add(T t) {

        for(int index = 0; index < values.length; index++)
        {
            if(values[index] == null)
            {
                values[index] = t;
                return true;
            }
        }
        return false;
    }


    /**
     * Remove an object in array by set reference to null
     * @param o - object which must be deleted
     * @return - true if operation success, and false if get stuck
     */
    @Override
    public boolean remove(Object o) {

        for(int index = 0; index < values.length; index++)
        {
            Object current = values[index];
            if(current != null && current.equals(o)) values[index] = null;
        }

        return contains(o);
    }

    /**
     * Will be fix
     * @param c - collection which must be to exist array
     * @return - true if operations success, and false if it get stuck
     */
    @Override
    public boolean containsAll(Collection<?> c) {

        return false;
    }

    /**
     * Add all elements from Collection instance c to this array
     * @param c - instance of collection interface
     * @return true if operation success, and false if it get stuck
     */
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    /**
     * Add to object array by start index and copy all elements form collection instance
     * @param index - position for insert
     * @param c - collections instance, it hold data to copy
     * @return true if operation success and get stuck if fail
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    //TODO write docs
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    //TODO write docs
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    //TODO write docs
    @Override
    public void clear() {

        for(int index = 0; index < values.length; index++)
        {
            values[index] = null;
        }
    }

    //TODO write docs
    @Override
    public T get(int index)
    {
        Object value;
        if(index <= 0 || index > size()) value = null;
        value = values[index];
        return (T)value;
    }

    //TODO write docs
    @Override
    public T set(int index, T element) {

        if(index >= 0 && index < values.length)
        {
            values[index] = element;
        }

        return element;
    }

    //TODO write docs
    @Override
    public void add(int index, T element) {

        if(index < values.length)
            values[index] = element;
        else
        {
            Object[] newArray = new Object[(values.length+2*index)];
            System.arraycopy(values,0,newArray,0,values.length);
            newArray[index] = element;
            values = newArray;
        }


    }

    //TODO write docs
    @Override
    public T remove(int index) {

        T tempClient = (T)values[index];
        values[index] = null;
        return tempClient;
    }

    //TODO write docs and code
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    //TODO write docs and code
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    //TODO write docs and code
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    //TODO write docs and code
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    //TODO write docs and code
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


}
