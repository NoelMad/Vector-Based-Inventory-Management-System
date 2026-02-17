import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ThreadSafetyDemo {

    private static final int THREAD_COUNT = 5;
    private static final int OPERATIONS = 1000;

    public static void main(String[] args) throws InterruptedException {

        // Use your existing Product class from Product.java
        Vector<Product> vectorProducts = new Vector<>();
        List<Product> arrayListProducts = new ArrayList<>();

        System.out.println("===== VECTOR TEST =====");
        testCollection(vectorProducts);

        System.out.println("\n===== ARRAYLIST TEST =====");
        // Wrap ArrayList with synchronizedList to prevent crashes
        testCollection(java.util.Collections.synchronizedList(arrayListProducts));
    }

    /**
     * Generic test method for any List<Product>.
     * Can accept Vector, ArrayList, or synchronizedList.
     */
    public static void testCollection(List<Product> list) throws InterruptedException {

        Random random = new Random();

        // Task to add products
        Runnable addTask = () -> {
            for (int i = 0; i < OPERATIONS; i++) {
                list.add(new Product("P" + i, "Product" + i, null, random.nextDouble() * 100, i, null));
            }
        };

        // Task to remove products
        Runnable removeTask = () -> {
            for (int i = 0; i < OPERATIONS; i++) {
                synchronized (list) { // ensure safe removal
                    if (!list.isEmpty()) {
                        list.remove(0);
                    }
                }
            }
        };

        // Task to read products
        Runnable readTask = () -> {
            for (int i = 0; i < OPERATIONS; i++) {
                synchronized (list) { // ensure safe reading
                    if (!list.isEmpty()) {
                        list.get(list.size() - 1);
                    }
                }
            }
        };

        Thread[] threads = new Thread[THREAD_COUNT * 3];

        long startTime = System.currentTimeMillis();

        // Create threads
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(addTask);
            threads[i + THREAD_COUNT] = new Thread(removeTask);
            threads[i + (THREAD_COUNT * 2)] = new Thread(readTask);
        }

        // Start threads
        for (Thread t : threads) {
            t.start();
        }

        // Wait for threads to finish
        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Final size: " + list.size());
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }
}
