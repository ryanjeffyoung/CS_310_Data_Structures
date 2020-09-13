import java.util.AbstractList;

public class SortedArrayList<E> extends AbstractList<E> implements Comparable{

    SortedArrayList(){

    }

    /***
     * Constructor.
     * @param size initial capacity of array
     */
    SortedArrayList(int size) {
        E[] original = (E[])new Object[size];
    }

    /***
     * Inserts an item in the array.
     * Dynamically sizes and sorts to place
     * in the correct position.
     * @param item to be inserted
     * @return true if successful, else false
     */
    @Override
    public boolean add(E item){

        return false;
    }

    /***
     The capacity of the array
     @return max number of items in array
     */
    int capacity(){

        return 0;
    }

    /***
     * Resets the size of array to 0
     */
    public void clear(){

    }

    /***
     * Value lookup for item
     * @param index of item stored in array
     * @return value of item at index
     */
    @Override
    public E get(int index) {
        return null;
    }

    /***
     * Checks if the array is empty
     * @return True if size is 0, else false
     */
    public boolean isEmpty(){

        return false;
    }

//    /***
//     * Deletes item from array.
//     * May shift other items left.
//     * @param index of item to remove
//     * @return value of item being removed
//     */
//    public E remove(int index){
//
//    }

    /***
     * Size of the data structure
     * @return number of items in array
     */
    @Override
    public int size() {
        return 0;
    }

    /***
     * Compares two objects
     * @param o the object being compared to
     * @return -1, if object A
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
