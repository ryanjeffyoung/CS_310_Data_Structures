package edu.sdsu.cs.datastructures;
/***
 * Interface containing methods
 * for a list
 * @author Ryan Young
 */

public interface List<E> {
    public boolean add(E datum);
    public boolean add(List<E> other);
    public boolean addFirst(E datum);
    public boolean addLast(E datum);
    public void clear();
    public int count(E target);
    public E get(int index);
    public boolean isEmpty();
    public E remove(int index);
    public void reverse();
    public E set(int index, E value);
    public int size();
    public void sort();
}
