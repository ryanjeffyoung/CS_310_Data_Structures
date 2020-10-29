/***
 * Driver to run tests and time performance
 * of SinglyLinkedList.
 * Performs 6 increments for each method,
 * starting with defined size and doubling
 * for each increment.
 *
 * @author Ryan Young
 */

public class Driver {
    private static final int INITIAL_TEST_SIZE = 500;
    private static final int TEST_ROUNDS = 3;

    private static final String FORMAT = "%-15s %-15s %-15s\n";

    public static void main(String[] args) {
//        runTestSuite();
        testRemoveNegative(80);

    }

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
    public static void testAddList(int listSize){
        System.out.println("__________________________");
        System.out.println("| Add List |");
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
    public static void testRemoveNegative(int listSize){
        System.out.println("__________________________");
        System.out.println("| Remove Negative Index |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            list.add(i);
        }
        System.out.println("2nd to last element: " + list.get(list.size() - 2));
        System.out.println("Removing 2nd to last element at index -1");
        System.out.println("2nd to last element: " + list.remove(-1));
    }

    public static void testClear(int listSize){
        System.out.println("__________________________");
        System.out.println("| Clear List |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            list.add(i);
        }
        System.out.println("List size: " + list.size());
        System.out.println("List cleared: " + list.isEmpty());
        System.out.println("Calling clear()...");
        list.clear();
        System.out.println("List size: " + list.size());
        System.out.println("List cleared: " + list.isEmpty());
    }

    public static void testSort(int listSize){
        System.out.println("__________________________");
        System.out.println("| Sort List |");
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
    public static void testSet(int listSize, Object target){
        System.out.println("__________________________");
        System.out.println("| Set Element in List |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < listSize; i++){
            list.add(i);
        }
        System.out.println("Count of " + target + ": " + list.count((Integer)target));
        System.out.println("Setting element 1 to " + target);
        list.set(1, (Integer)target);
        System.out.println("Count of " + target + ": " + list.count((Integer)target));
    }

    public static void testReverseEmptyList(){
        System.out.println("__________________________");
        System.out.println("| Reverse Empty List |");
        System.out.println("--------------------------");
        List<Integer> list = new SinglyLinkedList<>();
        list.reverse();
    }

    // Utility methods
    private static <E extends Comparable> boolean isSorted(List<E> listOfT) {
        E previous = null;
        for (int i = 0; i < listOfT.size(); i++){
            E curr = listOfT.get(i);
            if (previous != null && curr.compareTo(previous) < 0) return false;
            previous = curr;
        }
        return true;
    }
}
