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
        Node<E> newest = new Node(datum, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
        return true;
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
        Node<E> curr = head;
        boolean negIndex = false;
        // if negative index
        if (index < 0)
            negIndex = true;
        // start from tail
        if (negIndex) {
            curr = tail;
            // reverse list to traverse 'backwards'
            reverse();
            // get positive index for for loop
            index *= -1;
        }
        //Traverse list up to node at index
        for (int i = 0; curr != null && i < index; i++) {
            curr = curr.getNext();
        }

        // put list back in proper order
        if (negIndex) {
            reverse();
        }
        return curr;
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
       Node<E> curr = head;
       Node<E> prev = null;

        boolean negIndex = false;
        // if negative index
        if (index < 0)
            negIndex = true;
        // start from tail
        if (negIndex) {
            curr = tail;
            // reverse list to traverse 'backwards'
            reverse();
            // get positive index for for loop
            index *= -1;
        }

       // if removing head
        if (index == 0){
            head = curr.getNext();
            size--;
            return curr.datum;
        }

        //Traverse list up to node before index
        for (int i = 0; curr != null && i < index - 1; i++) {
            curr = curr.getNext();
        }

        //if index outside of range
        if (curr == null || curr.getNext() == null)
            return -1;

        // store previous node to return node removed
        prev = curr.getNext();

        // update curr node's next pointer
        curr.setNext(curr.getNext().getNext());
        size--;
        // put list back in proper order
        if (negIndex) {
            reverse();
        }
        return prev.datum;
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
        // set head ref pointer
        Node<E> curr = head;
        boolean negIndex = false;
        // if negative index
        if (index < 0)
            negIndex = true;
        // start from tail
        if (negIndex) {
            curr = tail;
            // reverse list to traverse 'backwards'
            reverse();
            // get positive index for for loop
            index *= -1;
        }
        // traverse list up to index
        for (int i = 0; curr != null && i < index; i++) {
            curr = curr.getNext();
        }
        // store curr value
        Object prev = curr.datum;
        // update datum
        curr.datum = (E)value;

        // put list back in proper order
        if (negIndex) {
            reverse();
        }
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
        
    }

    // helpers
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

    public Object getHead(){
        return head.getDatum();
    }

    public Object getTail(){
        return tail.getDatum();
    }
}
