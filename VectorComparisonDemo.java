import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class VectorComparisonDemo {

    public static void main(String[] args) {

        Vector<Product> vectorProducts = new Vector<>();
        ArrayList<Product> arrayListProducts = new ArrayList<>();

        int totalProducts = 10000;
        int randomAccessCount = 1000;

      
        // Measure time to ADD 10,000 items
        long vectorAddStart = System.nanoTime();
        for (int i = 0; i < totalProducts; i++) {
            vectorProducts.add(createProduct(i));
        }
        long vectorAddEnd = System.nanoTime();

        long arrayAddStart = System.nanoTime();
        for (int i = 0; i < totalProducts; i++) {
            arrayListProducts.add(createProduct(i));
        }
        long arrayAddEnd = System.nanoTime();

        // Measure time to ACCESS random elements
        Random rand = new Random();

        long vectorAccessStart = System.nanoTime();
        for (int i = 0; i < randomAccessCount; i++) {
            vectorProducts.get(rand.nextInt(totalProducts));
        }
        long vectorAccessEnd = System.nanoTime();

        long arrayAccessStart = System.nanoTime();
        for (int i = 0; i < randomAccessCount; i++) {
            arrayListProducts.get(rand.nextInt(totalProducts));
        }
        long arrayAccessEnd = System.nanoTime();

        // Approximate memory usage
        Runtime runtime = Runtime.getRuntime();

        runtime.gc(); // Suggest garbage collection
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        Vector<Product> memoryVector = new Vector<>();
        for (int i = 0; i < totalProducts; i++) {
            memoryVector.add(createProduct(i));
        }

        long memoryAfterVector = runtime.totalMemory() - runtime.freeMemory();
        long vectorMemoryUsed = memoryAfterVector - memoryBefore;

        runtime.gc();
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        ArrayList<Product> memoryArray = new ArrayList<>();
        for (int i = 0; i < totalProducts; i++) {
            memoryArray.add(createProduct(i));
        }

        long memoryAfterArray = runtime.totalMemory() - runtime.freeMemory();
        long arrayMemoryUsed = memoryAfterArray - memoryBefore;

        // Print comparison report
    
        System.out.println("===== Vector vs ArrayList Comparison Report =====");

        System.out.println("\n--- Add 10,000 Products ---");
        System.out.println("Vector Time (ms): " + (vectorAddEnd - vectorAddStart) / 1_000_000.0);
        System.out.println("ArrayList Time (ms): " + (arrayAddEnd - arrayAddStart) / 1_000_000.0);

        System.out.println("\n--- Access 1,000 Random Elements ---");
        System.out.println("Vector Time (ms): " + (vectorAccessEnd - vectorAccessStart) / 1_000_000.0);
        System.out.println("ArrayList Time (ms): " + (arrayAccessEnd - arrayAccessStart) / 1_000_000.0);

        System.out.println("\n--- Approximate Memory Usage ---");
        System.out.println("Vector Memory Used (bytes): " + vectorMemoryUsed);
        System.out.println("ArrayList Memory Used (bytes): " + arrayMemoryUsed);
    }
    
    // Helper method to create sample products
    // Used to avoid repeating product creation code in loops
    private static Product createProduct(int index) {
        return new Product(
                "P" + index,
                "Product" + index,
                "Category" + (index % 5),
                10.0 + index,
                index % 50 + 1,
                "Supplier" + index
        );
    }
}
