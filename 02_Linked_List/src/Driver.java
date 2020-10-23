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
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> newList = new SinglyLinkedList<>();


        for (int i = 0; i < 5; i++){
            newList.add(i);
        }

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);
        list.printList();
        System.out.println(list.count(10));


    }
}
