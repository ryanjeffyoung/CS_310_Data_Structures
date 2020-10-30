package edu.sdsu.cs.datastructures;
/***
 * Implements edu.sdsu.cs.datastructures.List interface to provide
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
        private E datum;
        private Node<E> next;
        public Node(E d, Node<E> n){
            datum = d;
            next = n;
        }

        public E getDatum(){
            return datum;
        }
        public void setDatum(E d){
            datum = d;
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

    // constructors
    public SinglyLinkedList(){ }
    public SinglyLinkedList(List<E> list){
        this.add(list);
    }

      /***
     * Appends datum to end of list
     * @param datum to be added to list
     * @return true if successfully added
     */
    @Override
    public boolean add(Object datum) {
        return addLast(datum);
    }

    /***
     * Appends every datum from list,
     * in order, to current list
     * @param other list to add
     * @return true if successful
     */
    @Override
    public boolean add(List other) {
        for (int i = 0; i < other.size(); i++){
            add(other.get(i));
        }
        return true;
    }

    /***
     * Adds to front of list
     * @param datum to be added
     * @return true if successful
     */
    @Override
    public boolean addFirst(Object datum) {
        head = new Node(datum, head);
        if (isEmpty())
            tail = head;
        size++;
        return true;
    }

    /***
     * Adds to end of list
     * @param datum to be added
     * @return true if successful
     */
    @Override
    public boolean addLast(Object datum) {
        // create new node with null next pointer
        Node<E> newNode = new Node(datum, null);
        // if list empty, make new node head
        if (isEmpty())
            head = newNode;
        // else set new node as next for tail node
        else
            tail.setNext(newNode);
        // set new node as tail
        tail = newNode;
        size++;
        return true;
    }

    /***
     * Resets list to empty state
     */
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /***
     * Counts number of instances of target
     * in list
     * @param target value to check for occurrences
     * @return number of occurrences
     */
    @Override
    public int count(Object target) {
        int count = 0;
        // start at head
        Node<E> curr = this.head;
        while(curr != null){
            // check if match target
            if (((Comparable)target).compareTo((Comparable)curr.getDatum()) == 0){
                count++;
            }
            // update current node
            curr = curr.getNext();
        }

        return count;
    }

    /***
     * Get element at specified index in list
     * @param index to get element from
     * @return the element
     */
    @Override
    public Object get(int index) throws IndexOutOfBoundsException{
        // check if valid index
        if (!validIndex(index))
            throw new IndexOutOfBoundsException("Invalid index");
        // set ref pointer
        Node<E> curr = head;
        // if negative index
        if (index < 0){
            // traverse list up to node at index before tail
            for (int i = 0; curr != null && i < (size() + index) - 1; i++) {
                curr = curr.getNext().getNext();
            }
        }
        else {
            //Traverse list up to node at index
            for (int i = 0; curr != null && i < index; i++) {
                curr = curr.getNext();
            }
        }
        return curr.getDatum();
    }

    /***
     * Checks if no elements in list
     * @return true if empty
     */
    @Override
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else return false;
    }

    /***
     * Removes item from list
     * @param index to remove item
     * @return element removed
     */
    @Override
    public Object remove(int index){
        // set reference pointers
        Node<E> curr = head;
        Node<E> prev = null;

        // check if negative index
        if (index < 0) {
            // check if invalid index
            if (!validNegIndex(index))
                return "Invalid index, nothing removed";
            // if removing -1 (tail)
            if (index == -1){
                return removeLast();
            } // if removing -size (head)
            else if (index == (size * -1)){
                return removeFirst();
            } // else removing middle node
            else {
                for (int i =0; i < (size() + index); i++){
                    prev = curr;
                    curr = curr.getNext();
                }
                prev.setNext(curr.getNext());
                size--;
                return curr.getDatum();
            }
        } else {
            // check if invalid index
            if (!validIndex(index))
                return "Invalid index, nothing removed";
            // check if removing head
            if (index == 0){
                return removeFirst();
            } // check if removing tail
            else if (index == size -1){
                return removeLast();
            }
            // else removing middle node
            else {
                for (int i = 0; i < index; i++){
                    prev = curr;
                    curr = curr.getNext();
                }
                prev.setNext(curr.getNext());
                size--;
                return curr.getDatum();
            }
        }
    }

    /***
     * Reverses the list direction
     */
    @Override
    public void reverse() {
        // set reference pointers
        Node<E> prev  = null;
        Node<E> curr = head;
        Node<E> next = null;
        //traverse list
        while (curr != null){
            // store next
            next = curr.getNext();
            // reverse next pointer of curr
            curr.setNext(prev);
            // step forward prev & curr
            prev = curr;
            curr = next;
        }
        // update header
        head = prev;
    }

    /***
     * Changes value of specified index
     * @param index of element to change
     * @param value to change element to
     * @return original value of element
     */
    @Override
    public Object set(int index, Object value) {
        //check if valid index
        if (!validIndex(index))
            return "Invalid index";
        // set head ref pointer
        Node<E> curr = head;
        // if negative index
        if (index < 0){
            // traverse list up to node at index before tail
            for (int i = 0; curr != null && i < (size() + index) - 1; i++) {
                curr = curr.getNext();
            }
        }
        else {
            // traverse list up to index
            for (int i = 0; curr != null && i < index; i++) {
                curr = curr.getNext();
            }
        }
        // store curr value
        Object prev = curr.getDatum();
        // update datum
        curr.datum = (E)value;
        // return prev value
        return prev;
    }

    /***
     * Number of items in list
     * @return number of items in list
     */
    @Override
    public int size() {
        return size;
    }

    /***
     * Places list in natural order
     */
    @Override
    public void sort() {
        Node<E> curr = head;
        Node<E> index = null;
        Object temp;

        while (curr != null){
            index = curr.getNext();

            while (index != null){
                //if curr data > index data, swap data
                if (((Comparable)curr.getDatum()).compareTo((Comparable)index.getDatum()) > 0){
                    temp = curr.getDatum();
                    curr.setDatum(index.getDatum());
                    index.setDatum((E) temp);
                }
                index = index.getNext();
            }
            curr = curr.getNext();
        }
    }

    // helpers

    /***
     * Checks if given index
     * exists within list
     * @param index to check
     * @return true if valid, else false
     */
    private boolean validIndex(int index){
        // if negative index, change to positive value
        if (index < 0)
            index *= -1;

        // check if index within bounds
        if (index < size())
            return true;
        else return false;
    }

    /***
     * Checks if given negative index
     * exists within list
     * @param index to check
     * @return true if valid, else false
     */
    private boolean validNegIndex(int index){
        // if negative index, change to positive value
        if (index < 0)
            index *= -1;

        // check if index within bounds
        if (index <= size())
            return true;
        else return false;
    }

    /***
     * Removes the last node in
     * linked list. Updating tail
     * node pointer as necessary.
     * @return Datum of node removed.
     */
    private Object removeLast() {
        // set pointers
        Node<E> curr = head;
        Node<E> prev = null;
        while (curr.getNext() != null){
            prev = curr;
            curr = curr.getNext();
        }
        tail = prev;
        prev.setNext(null);
        size--;
        return curr.getDatum();
    }

    /***
     * Removes the first node in
     * linked list. Updating head
     * node pointer as necessary.
     * @return Datum of node removed.
     */
    private Object removeFirst() {
        Node<E> curr = head;
        Node<E> prev = null;

        head = curr.getNext();
        size--;
        return curr.getDatum();
    }
}
