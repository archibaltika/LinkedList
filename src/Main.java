import Exceptions.EmptyListException;
import Exceptions.ValueNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            methodsTest();
            System.out.println();
            timeTests();
        } catch (EmptyListException | ValueNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void methodsTest() throws EmptyListException, ValueNotFoundException{
        List<String> list0 = new List<>();
        System.out.println("----------Methods tests----------");
        System.out.print("Adding 2 and 1 to the beginning of list:  ");
        list0.addFirst("2");
        list0.addFirst("1");
        list0.printList();
        System.out.print("Adding 5 and 6 to the end of list:  ");
        list0.addLast("5");
        list0.addLast("6");
        list0.printList();
        System.out.print("Inserting 3 and 4 in the middle of list:  ");
        list0.addMiddle("3", 2);
        list0.addMiddle("4", 3);
        list0.printList();
        System.out.println("Searching index of 3:  " + list0.getIndexByValue("3"));
        System.out.println("List size:  " + list0.getSize());
        System.out.print("Replacing 3 and 4 by three and four in the middle of list:  ");
        list0.replaceMiddle("three", 2);
        list0.replaceMiddle("four", 3);
        list0.printList();
        System.out.print("Replacing first element by one:  ");
        list0.replaceFirst("one");
        list0.printList();
        System.out.print("Replacing last element by six:  ");
        list0.replaceLast("six");
        list0.printList();
        System.out.print("Removing three and four in the middle of list:  ");
        list0.removeMiddle(2);
        list0.removeMiddle(2);
        list0.printList();
        System.out.print("Removing one and 2 in the beginning of list:  ");
        list0.removeFirst();
        list0.removeFirst();
        list0.printList();
        System.out.print("Removing six in the end of list:  ");
        list0.removeLast();
        list0.printList();
    }
    public static void timeTests() throws EmptyListException, ValueNotFoundException {
        List<String> list1 = new List<>();
        System.out.println("----------Time tests----------");
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list1.addFirst(Double.toString(Math.random()));
        }
        long stop = System.nanoTime();
        System.out.println("Adding 10K elements in the beginning: " + (stop - start) / 1000000 + " ms");

        List<String> list2 = new List<>();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list2.addLast(Double.toString(Math.random()));
        }
        stop = System.nanoTime();
        System.out.println("Adding 10K elements in the end: " + (stop - start) / 1000000 + " ms");

        List<String> list3 = new List<>();
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list3.addMiddle(Double.toString(Math.random()), (int) (Math.random() * i));
        }
        stop = System.nanoTime();
        System.out.println("Adding 10K elements in the middle: " + (stop - start) / 1000000 + " ms");

        List<String> list4 = new List<>();
        for (int i = 0; i < 10000; i++) {
            list4.addLast(Double.toString(Math.random()));
        }
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list4.removeFirst();
        }
        stop = System.nanoTime();
        System.out.println("Removing 10K elements from the beginning: " + (stop - start) / 1000000 + " ms");

        List<String> list5 = new List<>();
        for (int i = 0; i < 10000; i++) {
            list5.addLast(Double.toString(Math.random()));
        }
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list5.removeLast();
        }
        stop = System.nanoTime();
        System.out.println("Removing 10K elements from the end: " + (stop - start) / 1000000 + " ms");

        List<String> list6 = new List<>();
        for (int i = 0; i < 10000; i++) {
            list6.addLast(Double.toString(Math.random()));
        }
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            list6.removeMiddle((int) (Math.random() * (10000 - i)));
        }
        stop = System.nanoTime();
        System.out.println("Removing 10K elements from the middle: " + (stop - start) / 1000000 + " ms");

    }
}
