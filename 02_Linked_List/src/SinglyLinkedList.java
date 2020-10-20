/***
 * Implements List interface to provide
 * singly linked list data structure.
 *
 * @author Ryan Young
 */

public class SinglyLinkedList<E> implements List {
    /***
     * Nested node class
     * @param <E>
     */
    private static class Node<E> {
        private E element;
        private Node<E> next;
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next = n;
        }
    }

//    instance variables
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    /***
     * Appends datum to end of list
     * @param datum to be added to list
     * @return true if successfully added
     */
    @Override
    public boolean add(Object datum) {
        return false;
    }

    /***
     * Appends every datum from list,
     * in order, to current list
     * @param other list to add
     * @return true if successful
     */
    @Override
    public boolean add(List other) {
        return false;
    }

    /***
     * Adds to front of list
     * @param datum to be added
     * @return true if successful
     */
    @Override
    public boolean addFirst(Object datum) {

        return false;
    }

    /***
     * Adds to end of list
     * @param datum to be added
     * @return true if successful
     */
    @Override
    public boolean addLast(Object datum) {
        return false;
    }

    /***
     * Resets list to empty state
     */
    @Override
    public void clear() {

    }

    /***
     * Counts number of instances of target
     * in list
     * @param target value to check for occurrences
     * @return number of occurrences
     */
    @Override
    public int count(Object target) {
        return 0;
    }

    /***
     * Get element at specified index in list
     * @param index to get element from
     * @return the element
     */
    @Override
    public Object get(int index) {
        return null;
    }

    /***
     * Checks if no elements in list
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /***
     * Removes item from list
     * @param index to remove item
     * @return element removed
     */
    @Override
    public Object remove(int index) {
        return null;
    }

    /***
     * Reverses the list direction
     */
    @Override
    public void reverse() {

    }

    /***
     * Changes value of specified index
     * @param index of element to change
     * @param value to change element to
     * @return original value of element
     */
    @Override
    public Object set(int index, Object value) {
        return null;
    }

    /***
     * Number of items in list
     * @return number of items in list
     */
    @Override
    public int size() {
        return 0;
    }

    /***
     * Places list in natural order
     */
    @Override
    public void sort() {

    }
}
