/***
 * Driver to run tests and time performance
 * of edu.sdsu.cs.datastructures.SinglyLinkedList.
 * Performs 6 increments for each method,
 * starting with defined size and doubling
 * for each increment.
 *
 * @author Ryan Young
 */
import edu.sdsu.cs.datastructures.List;
import edu.sdsu.cs.datastructures.SinglyLinkedList;

public class Driver {
    private static final int INITIAL_TEST_SIZE = 500;
    private static final int TEST_ROUNDS = 3;

    private static final String FORMAT = "%-15s %-15s %-15s\n";

    public static void main(String[] args) {
        runTestSuite();
    }

    /***
     * Runs all tests below
     */
    public static void runTestSuite(){
        testAddFirst(5000, 6);
        testAddLast(5000, 6);
        testRemoveFirst(5000, 6);
        testRemoveLast(5000, 6);
        testAddList(100);
        testRemoveNegative(80);
        testClear(100);
        testSort(100);
        testSet(100, 50);
        testReverseEmptyList();
    }

    /***
     * Adds element to front of list and times
     * how long it takes. edu.sdsu.cs.datastructures.List size doubles each
     * iteration.
     * @param initialSize of list
     * @param numRounds to add to list
     */
    public static void testAddFirst(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("__________________________");
        System.out.println("| Add First |");
        System.out.println("--------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            List<Integer> list = new SinglyLinkedList();
            long startTime = System.nanoTime();
            for (int j = 0; j < n; j++){
                list.addFirst(j);
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            double factor = 0;
            if (i != 0)
                factor = (double)totalTime / prevTime;
            prevTime = totalTime;
            String strFactor = String.format("%.2f", factor);
            System.out.printf(FORMAT,n, totalTime, strFactor);
            n *= 2;
        }
        System.out.println();
    }
    /***
     * Adds element to end of list and times
     * how long it takes. edu.sdsu.cs.datastructures.List size doubles each
     * iteration.
     * @param initialSize of list
     * @param numRounds to add to list
     */
    public static void testAddLast(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("__________________________");
        System.out.println("| Add Last |");
        System.out.println("--------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            List<Integer> list = new SinglyLinkedList();
            long startTime = System.nanoTime();
            for (int j = 0; j < n; j++){
                list.addLast(j);
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            double factor = 0;
            if (i != 0)
                factor = (double)totalTime / prevTime;
            prevTime = totalTime;
            String strFactor = String.format("%.2f", factor);
            System.out.printf(FORMAT,n, totalTime, strFactor);
            n *= 2;
        }
        System.out.println();
    }
    /***
     * Removes element from front of list and
     * times how long it takes. edu.sdsu.cs.datastructures.List size doubles
     * each iteration.
     * @param initialSize of list
     * @param numRounds to add to list
     */
    public static void testRemoveFirst(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("__________________________");
        System.out.println("| Remove First |");
        System.out.println("--------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            List<Integer> list = new SinglyLinkedList();

            for (int j = 0; j < n; j++){
                list.add(j);
            }
            long startTime = System.nanoTime();
            for (int j = 0; j < n; j++){
                list.remove(0);
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            double factor = 0;
            if (i != 0)
                factor = (double)totalTime / prevTime;
            prevTime = totalTime;
            String strFactor = String.format("%.2f", factor);
            System.out.printf(FORMAT,n, totalTime, strFactor);
            n *= 2;
        }
        System.out.println();
    }
    /***
     * Removes element from end of list and
     * times how long it takes. edu.sdsu.cs.datastructures.List size doubles
     * each iteration.
     * @param initialSize of list
     * @param numRounds to add to list
     */
    public static void testRemoveLast(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("__________________________");
        System.out.println("| Remove Last |");
        System.out.println("--------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            List<Integer> list = new SinglyLinkedList<>();

            for (int j = 0; j < n; j++){
                list.add(j);
            }
            long startTime = System.nanoTime();
            for (int j = 0; j < n; j++){
                list.remove(list.size());
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            double factor = 0;
            if (i != 0)
                factor = (double)totalTime / prevTime;
            prevTime = totalTime;
            String strFactor = String.format("%.2f", factor);
            System.out.printf(FORMAT,n, totalTime, strFactor);
            n *= 2;
        }
        System.out.println();
    }
    /***
     * Adds a list to the end of an
     * existing list
     * @param listSize size of list to create
     */
    public static void testAddList(int listSize){
        System.out.println("__________________________");
        System.out.println("| Add edu.sdsu.cs.datastructures.List |");
        System.out.println("--------------------------");

        List<Integer> baseList = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            baseList.add(i);
        }
        int originalSize = baseList.size();
        List<Integer> newList = new SinglyLinkedList<>();
        for (int i = listSize; i > 0; i--){
            newList.add(i);
        }
        int newSize = newList.size();
        System.out.println("Original list size: " + originalSize + " | " +
                "Last element in original list: " + baseList.get((baseList.size())-1));
        System.out.println("Size of list to add: " + newSize + " | " +
                "Last element in new list: " + newList.get((newList.size())-1));
        System.out.println("Combining lists...");
        baseList.add(newList);
        int finalSize = baseList.size();
        System.out.println("Final size of combined list: " + finalSize + " | " +
                "Last element in combined list: " + baseList.get((baseList.size())-1));
        System.out.println("Middle element in combined list (last element of original): " +
                baseList.get(((baseList.size() - 1) / 2)));

    }
    /***
     * Removes an element from list using
     * a negative index.
     * @param listSize size of list to create
     */
    public static void testRemoveNegative(int listSize){
        System.out.println("__________________________");
        System.out.println("| Remove Negative Index |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            list.add(i);
        }
        System.out.println("Last element: " + list.get(list.size() - 1));
        System.out.println("Removing last element at index -1");
        list.remove(-1);
        System.out.println("Last element: " + list.get(list.size() - 1));
    }
    /***
     * Clears the list of all elements.
     * @param listSize size of list to create
     */
    public static void testClear(int listSize){
        System.out.println("__________________________");
        System.out.println("| Clear edu.sdsu.cs.datastructures.List |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            list.add(i);
        }
        System.out.println("edu.sdsu.cs.datastructures.List size: " + list.size());
        System.out.println("edu.sdsu.cs.datastructures.List cleared: " + list.isEmpty());
        System.out.println("Calling clear()...");
        list.clear();
        System.out.println("edu.sdsu.cs.datastructures.List size: " + list.size());
        System.out.println("edu.sdsu.cs.datastructures.List cleared: " + list.isEmpty());
    }
    /***
     * Sorts list in natural order
     * @param listSize size of list to create
     */
    public static void testSort(int listSize){
        System.out.println("__________________________");
        System.out.println("| Sort edu.sdsu.cs.datastructures.List |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            list.add(i);
        }
        for (int i = 0; i < listSize / 2; i++){
            list.addFirst(i);
        }
        System.out.println("Sorted: " + isSorted(list));
        System.out.println("Calling sort()...");
        list.sort();
        System.out.println("Sorted: " + isSorted(list));
    }
    /***
     * Sets the value of a specified element
     * @param listSize size of list to create
     * @param newValue to set
     */
    public static void testSet(int listSize, Object newValue){
        System.out.println("__________________________");
        System.out.println("| Set Element in edu.sdsu.cs.datastructures.List |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            list.add(i);
        }
        System.out.println("Count of " + newValue + ": " + list.count((Integer)newValue));
        System.out.println("Setting element 1 to " + newValue);
        list.set(1, (Integer)newValue);
        System.out.println("Count of " + newValue + ": " + list.count((Integer)newValue));
    }
    /***
     * Reverses an empty list.
     */
    public static void testReverseEmptyList(){
        System.out.println("__________________________");
        System.out.println("| Reverse Empty edu.sdsu.cs.datastructures.List |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        list.reverse();
    }
    // Utility methods
    /***
     * Checks if a list is sorted in
     * natural ordering.
     * @param list to check if sorted
     */
    private static <E extends Comparable> boolean isSorted(List<E> list) {
        E previous = null;
        for (int i = 0; i < list.size(); i++){
            E curr = list.get(i);
            if (previous != null && curr.compareTo(previous) < 0) return false;
            previous = curr;
        }
        return true;
    }
}
