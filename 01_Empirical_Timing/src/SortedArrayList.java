/***
 Dynamic, array-backed data structure which adds
 elements in natural order and maintains propercapacity for number of elements to store.
*
* @author Ryan Young
 */

import java.util.AbstractList;
public class SortedArrayList<E extends Comparable<E>> extends AbstractList<E> {

    private E[] data;
    private int size = 0;
    public int CAP = 16;

    /***
     * Initializes generic array with capacity of 16.
     */
    public SortedArrayList(){
        this(CAP);
    }

    /***
     * Initializes generic array with defined capacity.
     * @param cap initial capacity of array
     */
    public SortedArrayList(int cap) {
       data = (E[]) new Comparable[cap];

    }

    /***
     * Inserts an item in the array while keeping natural
     * ordering. Dynamically doubles capacity if adding
     * element would go over capacity.
     * @param item to be inserted
     * @return true if successful
     */
    public boolean add(E item){
        if (size() == capacity())
            resize(2 * capacity());
        int i;
        for (i = size() - 1; (i >= 0 &&get(i).compareTo(item) > 0); i--)
            data[i + 1] = get(i);

        data[i + 1] = item;
        size++;
        return true;
    }

    /***
     * Removes element from the array list.
     * Shrinks capacity if size less than 1/4 capacity.
     * Never shrinks lower than initial capacity.
     * @param i index of element to remove
     * @return element being removed
     * @throws IndexOutOfBoundsException
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        double factor = 0.5 * capacity();

        if (size - 1 < (capacity() * 0.25)) {
            if ( factor < CAP)
                resize(CAP);
            else resize((int)factor);
        }

        E temp = data[i];
        for (int k=i; k < size - 1; k++)
            data[k] = data[k + 1];
        data[size-1] = null;
        size--;
        return temp;
    }

    /***
     * The capacity of the array
     * @return max number of items in array
     */
    public int capacity(){
        return data.length;
    }

    /***
     * Resets the size of array to 0 and
     * sets all values to null.
     */
    public void clear(){
        E[] temp = (E[]) new Comparable[CAP];
        data = temp;
        size = 0;
    }

    /***
     * Value lookup for item
     * @param index of item stored in array
     * @return value of item at index
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }

    /***
     * Checks if the array is empty
     * @return True if size is 0, else false
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /***
     * Size of the data structure
     * @return number of items in array
     */
    @Override
    public int size() {
        return size;
    }

    /// UTILITY METHODS
    /***
     * Resizes the capacity of array list by
     * initializing a new array of defined size
     * and copying elements over.
     * @param cap intended capacity for new list
     */
    protected void resize(int cap) {
        E[] temp = (E[]) new Comparable[cap];
        for (int k = 0; k < size; k++)
            temp[k] = data[k];
        data = temp;
    }

    /***
     * Checks if valid index
     * @param i index of element
     * @param n number of elements
     * @throws IndexOutOfBoundsException
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }
}
