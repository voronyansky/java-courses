package ru.vrnsky.collection;

import java.util.*;

/**
 * Implementation of linked list
 * @see Collection
 * @see java.util.LinkedList
 */
public class LinkedList<T> implements List<T> {

    Element<T> start; //Start list
    Element<T> finish; //Finish list

    /**
     * Default constructor create empty list
     */
    public LinkedList()
    {
        start = new Element<T>(null,null,0);
        finish = new Element<T>((T)start, null,1);
        start.next = finish.prev;
    }

    /**
     * Compute size of list by cross through all elements
     * @return count of elements in list
     */
    @Override
    public int size() {

        int countElements = 0;
        for(Element<T> current = start; current.next != null;)
        {
            countElements++;
            current = (Element<T>)current.next;
        }

        return countElements;
    }

    /**
     * Check if array empty or non empty
     * @return true if list is empty and false if list is empty
     */
    @Override
    public boolean isEmpty() {

        boolean isEmpty = start.next == finish.prev;
        return isEmpty;
    }

    /**
     * Fail on test. Doesn't work
     * @param o - object for find in list
     * @return - true if list have this object and false otherwise
     */
    @Override
    public boolean contains(Object o) {

        boolean contains = false;
        for(Element<T> current = start; current.next != null;)
        {
            if(current.equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    /**
     * All elements in array view
     * @return Object[] which contains all elements of list
     */
    @Override
    public Object[] toArray() {

        Object[] array = new Object[size()];
        for(int index = 0; index < array.length; index++)
        {
            array[index] = get(index);
        }

        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    /**
     * Push element to the end of list
     * @param t - element for adding
     * @return true if ok otherwise false
     */
    @Override
    public boolean add(T t) {

        boolean result = false;
        return result;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    /**
     * Return element which placed at the index position
     * @param index
     * @return
     */
    @Override
    public T get(int index) {

        if(index >= 0 && index <= size()) {
            for (Element<T> current = start; current != null; ) {
                if (current.index == index)
                    return (T) current;
            }
        }

        return null;
    }

    //TODO write docs and implementation
    @Override
    public T set(int index, T element) {
        return null;
    }

    //TODO write docs and implementation
    @Override
    public void add(int index, T element) {

    }

    //TODO write docs and implementation
    @Override
    public T remove(int index) {

       return null;
    }

    //TODO write docs and implementation
    @Override
    public int indexOf(Object o) {
        return 0;
    }

    //TODO write docs
    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    //TODO write docs
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    //TODO write docs
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    //TODO write docs
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    //TODO write docs
    protected class Element<T>
    {
        T prev;
        T next;
        int index;

        public Element(T prev, T next, int index)
        {
            this.prev = prev;
            this.next = next;
            this.index = index;
        }

    }
}
