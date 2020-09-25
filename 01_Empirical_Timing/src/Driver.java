/***
 * Driver to run tests and time performance
 * of SortedArrayList
 *
 * @author Ryan Young
 */

public class Driver {
    public static final String FORMAT = "%-10s%s%20s%s%20s%s%n";

    public static void main(String[] args) {
       testAdd(5000, 6);
       testAddReverse(5000, 6);
       testRemove(5000, 6);
       testClear(5000, 6);

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
        long prevTime = 0;
        System.out.println("Adding in order [O(n)]");
        System.out.println("----------------");
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
                factor = totalTime / prevTime;
            prevTime = totalTime;
            System.out.printf(FORMAT, "Test Size: ",n , "Time (ms): ", totalTime, "Factor: ", factor);
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
        long prevTime = 0;
        System.out.println("Adding in reverse [O(n^2)]");
        System.out.println("----------------");
        for (int i = 0; i < numRounds; i++){
            SortedArrayList<Integer> list = new SortedArrayList<>(n);
            long startTime = System.currentTimeMillis();
            for (int j = n - 1 ; j >= 0; j--){
                list.add(j);
            }
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            double factor = 0;
            if (i != 0)
                factor = totalTime / prevTime;
            prevTime = totalTime;
            System.out.printf(FORMAT, "Test Size: ",n , "Time (nano): ", totalTime, "Factor: ", factor);
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
        long prevTime = 0;
        System.out.println("Removing elements [O(n^2)]");
        System.out.println("----------------");
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
                factor = totalTime / prevTime;
            prevTime = totalTime;
            System.out.printf(FORMAT, "Test Size: ",n , "Time (ms): ", totalTime, "Factor: ", factor);
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
        long prevTime = 0;
        System.out.println("Clearing list [O(1)]");
        System.out.println("----------------");
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
                factor = totalTime / prevTime;
            prevTime = totalTime;
            System.out.printf(FORMAT, "Test Size: ",n , "Time (ms): ", totalTime, "Factor: ", factor);
            n *= 2;
        }
        System.out.println();
    }
}
