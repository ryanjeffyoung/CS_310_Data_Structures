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
    public Object get(int index) {
        // check if valid index
        if (!validIndex(index))
            return "Invalid Index";
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
       // check if invalid index
        if (!validIndex(index))
            return "Invalid index, nothing removed";
        // set reference pointers
        Node<E> curr = head;
        Node<E> prev = null;
       // if removing head
        if (index == 0){
            head = curr.getNext();
            size--;
            return curr.getDatum();
        }
        // if negative index
        if (index < 0){
            // traverse list up to node at index before tail
            for (int i = 0; curr != null && i < (size() + index) - 1; i++) {
                curr = curr.getNext();
            }
            prev = curr;
        }
        else {
            //Traverse list up to node before index
            for (int i = 0; curr != null && i < index - 1; i++) {
                curr = curr.getNext();
            }
            // store previous node to return node removed
            prev = curr.getNext();
        }
        // update curr node's next pointer
        curr.setNext(curr.getNext().getNext());
        size--;
        return prev.getDatum();
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
    private boolean validIndex(int index){
        // if negative index, change to positive value
        if (index < 0)
            index *= -1;

        // check if index within bounds
        if (index < size())
            return true;
        else return false;
    }

    public void printList(){
        Node<E> curr = this.head;

        System.out.print("Singly Linked List: ");

        // traverse list
        while(curr != null){
            System.out.print(curr.getDatum() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
}
