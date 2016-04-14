package ru.vrnsky.collection;

import java.util.*;

/**
 *
 * This is realization of array list, list which based on array
 * It also dynamic resizable, but may not support features
 * from origiginal ArrayList
 */
public class ArrayList<T> implements List<T> {

    private Object[] values; //Hold data
    private int pointer; //Pointer for adding element

    /**
     * Create new array for holding objects
     * By default length of array is 10
     */
    public ArrayList()
    {
        values = new Object[10];
        pointer = 0;
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

        if(pointer >= 0 && pointer < values.length) {
            values[pointer] = t;
            pointer++;
        }
        else
        {
            Object[] newArray = new Object[(values.length*3)/2+1];
            System.arraycopy(values,0,newArray,values.length,values.length);

            pointer = 0;
            while(newArray[pointer] != null)
            {
                pointer++;
            }
            newArray[pointer] = t;
            pointer++;
            values = newArray;
        }

        return true;
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

    /**
     * Delete all elements of arg in originally array object
     * @param c - elements for remove
     * @return true if success and false if elements not found
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    /**
     * Delete all elements which does not find at arg
     * @param c - elements for excluding
     * @return true if it success and false if elements not found
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Set all array cell to null object
     */
    @Override
    public void clear() {

        for(int index = 0; index < values.length; index++)
        {
            values[index] = null;
        }
    }

    /**
     * Get an element from array
     * @param index - position at the array
     * @return instance of T class
     */
    @Override
    public T get(int index)
    {
        Object value;
        if(index <= 0 || index > size()) value = null;
        value = values[index];
        return (T)value;
    }

    /**
     * Set existing an element in index position next value element
     * @param index - position of element in array
     * @param element - instance of T class
     * @return instance of T class
     */
    @Override
    public T set(int index, T element) {

        if(index >= 0 && index < values.length)
        {
            values[index] = element;
        }

        return get(index);
    }

    /**
     * Add an element at the index position
     * If index bigger than values.length create new array and
     * Copy old data into new array, after it put element in new array
     * @param index
     * @param element
     */
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

    /**
     * Remove element in array by set reference in null
     * @param index - position at the array
     * @return copy of deleted object
     */
    @Override
    public T remove(int index) {

        T deleteClient = (T)values[index];
        values[index] = null;
        return deleteClient;
    }

    /**
     * Find position of object
     * @param o - object for search
     * @return position of object in array
     */
    @Override
    public int indexOf(Object o) {

        int position = -1;
        for(int index = 0; index < values.length; index++)
        {
            if(o.equals(values[index]))
            {
                position = index;
                break;
            }
        }

        return position;
    }

    /**
     * Return last index of object
     * @param o object for search
     * @return last index of object
     */
    @Override
    public int lastIndexOf(Object o) {

        int lastIndex = -1;
        for(int index = 0;index < values.length; index++)
        {
            if(o.equals(values[index])) lastIndex = index;
        }

        return lastIndex;
    }

    /**
     * For passes through
     * @return instance of ListIterator class
     */
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    /**
     * For passes through
     * @param index someone know:)
     * @return
     */
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    /**
     * Create new list from fromIndex position to toIndex
     * @param fromIndex - start for new list
     * @param toIndex - finish for new list
     * @return instance of list with data from old list
     */
    @Override
    public List<T> subList(int fromIndex, int toIndex) {

        List<T> newList = new ArrayList<T>();
        for(int index = fromIndex; fromIndex < values.length && fromIndex <= toIndex; index++)
        {
            newList.add((T) values[index]);
        }

        return newList;
    }


}
