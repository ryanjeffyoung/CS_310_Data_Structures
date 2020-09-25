/***
 * Driver to run tests and time performance
 * of SortedArrayList.
 * Performs 6 increments for each method,
 * starting with defined size and doubling
 * for each increment.
 *
 * @author Ryan Young
 */

public class ArrayDriver {
    private static final int INITIAL_TEST_SIZE = 500;
    private static final int TEST_ROUNDS = 6;

    private static final String FORMAT = "%-15s %-15s %-15s\n";

    public static void main(String[] args) {


       testAdd(INITIAL_TEST_SIZE, TEST_ROUNDS);
       testAddReverse(INITIAL_TEST_SIZE, TEST_ROUNDS);
       testRemove(INITIAL_TEST_SIZE, TEST_ROUNDS);
       testClear(INITIAL_TEST_SIZE, TEST_ROUNDS);
    }

    /***
     * Adds elements to array in order & times performance
     * defined number of runs. Doubles size of array after each run.
     * Linear runtime.
     * @param initialSize initial number of elements in array
     * @param numRounds number of times to double test size
     */
    public static void testAdd(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("__________________________");
        System.out.println("| Adding in order [O(n)] |");
        System.out.println("--------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            SortedArrayList<Integer> list = new SortedArrayList<>(n);
            long startTime = System.nanoTime();
            for (int j = 0; j < n; j++){
                list.add(i);
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            double factor = 0;
            if (i != 0)
                factor = (double)totalTime / prevTime;
            prevTime = totalTime;
            String strFactor = String.format("%.2f", factor);
//            System.out.printf(FORMAT, "Test Size: ",n, "Time (nano): ", totalTime, "Factor: ", strFactor);
            System.out.printf(FORMAT,n, totalTime, strFactor);
            n *= 2;
        }
        System.out.println();
    }

    /***
     * Adds elements to array in reverse order & times
     * performance defined number of runs. Doubles size of array after each run.
     * Quadratic runtime.
     * @param initialSize initial number of elements in array
     * @param numRounds number of times to double test size
     */
    public static void testAddReverse(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("______________________________");
        System.out.println("| Adding in reverse [O(n^2)] |");
        System.out.println("------------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            SortedArrayList<Integer> list = new SortedArrayList<>(n);
            long startTime = System.nanoTime();
            for (int j = n - 1 ; j >= 0; j--){
                list.add(j);
            }
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;

            double factor = 0.0;
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
     * Adds elements to array in order.
     * Then removes elements individually & times performance
     * defined number of times. Doubles size of array after each run.
     * Quadratic runtime.
     * @param initialSize initial number of elements in array
     * @param numRounds number of times to double test size
     */
    public static void testRemove(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("_____________________________");
        System.out.println("| Removing elements [O(n^2)] |");
        System.out.println("-----------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            SortedArrayList<Integer> list = new SortedArrayList<>(n);

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
     * Adds elements to array in order.
     * Clears the array & times performance defined number of times.
     * Doubles size of array after each run.
     * Constant runtime.
     * @param initialSize initial number of elements in array
     * @param numRounds number of times to double test size
     */
    public static void testClear(int initialSize, int numRounds){
        int n = initialSize;
        long prevTime = 0L;
        System.out.println("________________________");
        System.out.println("| Clearing list [O(1)] |");
        System.out.println("------------------------");
        System.out.printf(FORMAT, "Test Size", "Time (nano)", "Factor");
        System.out.printf(FORMAT, "---------", "-----------", "--------");
        for (int i = 0; i < numRounds; i++){
            SortedArrayList<Integer> list = new SortedArrayList<>(n);
            for (int j = 0; j < n; j++){
                list.add(j);
            }
            long startTime = System.nanoTime();
            list.clear();
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

}
