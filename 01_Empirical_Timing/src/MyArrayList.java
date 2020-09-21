import java.util.AbstractList;

public class MyArrayList<E> extends AbstractList<E> implements Comparable {

    private E[] data; //internal array
    private int size = 0; //initial size
    public static final int CAP = 16;

    public MyArrayList() {
        this(CAP);
    }

    public MyArrayList(int cap) {
        data = (E[]) new Object[cap];

    }
    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

//    need to make it so elements get added in order
//    implement some sort at the end of this method
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);

        if (size == data.length)
            resize(2 * capacity());
        for (int k = size - 1; k >= i; k--)
            data[k + 1] = data[k];
        data[i] = e;
        size++;
    }


    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        double factor = 0.5 * capacity();
        int inititalCapacity = capacity();

        if (size - 1 < (capacity() * 0.25)) {// check if size is < 1/4 of cap
            resize((int) factor); // if yes, resize (0.5 * cap)

        }
        E temp = data[i];
        for (int k=i; k < size - 1; k++)
            data[k] = data[k + 1];
        data[size-1] = null;
        size--;
        return temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    // Utility methods
    public int capacity(){
        return data.length;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    protected void resize(int cap) {
        E[] tempArray = (E[]) new Object[cap];
        for (int k = 0; k < size; k++)
            tempArray[k] = data[k];
        data = tempArray;
    }



    public void clear(){
        int n = size;
        for (int i = 0; i < n ; i++) {
            data[i] = null;
            size--;
        }
    }
}
