// Create a ProductInventory class that uses a Vector<Product> to manage products:
import java.util.Vector;

public class ProductInventory {
    // Vector<Product> products - stores all products
    private Vector<Product> products = new Vector<>();

    //Method
    // void addProduct(Product product) - adds a product (check for duplicates by productId)
    public void addProduct(Product product) {

        if(product == null) {
            System.out.println("Cannot add null product.");
            return;
        }

        //Iterate through the vector to check for existing productID
        for (Product existingProduct : products) {
            if(existingProduct.getProductId().equals(product.getProductId())) {
                System.out.println("Error: Product with ID " + product.getProductId() 
            + " already exists.");
                return;
            }
        }

        products.add(product);
        System.out.println("Product added successfully: " + product.getName());
    }

    // boolean removeProduct(String productId) - removes product by ID, returns true if found
    public boolean removeProduct(String productId) {
        for(int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.remove(i);
                System.out.println("Product with ID " + productId + " removed successfully.");
                return true;
            }
        }

        System.out.println("Error: Product with ID " + productId + " not found.");
        return false;
    }

    // Product findProduct(String productId) - finds and returns product, or null if not found
    public Product findProduct(String productId) {
        for (Product product : products) {
            if (productId != null && product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    // Vector<Product> getProductsByCategory(String category) - returns Vector of products in category
    public Vector<Product> getProductsByCategory(String category) {
        Vector<Product> result = new Vector<>();

        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                result.add(product);
            }
        }

        return result;
    }

    // Vector<Product> getLowStockProducts(int threshold) - returns products with quantity < threshold
    public Vector<Product> getLowStockProducts(int threshold) {
        Vector<Product> lowStock = new Vector<>();

        for (Product product : products) {
            if (product.getQuantityInStock() < threshold) {
                lowStock.add(product);
            }
        }

        return lowStock;
    }

    //double getTotalInventoryValue() - calculates total value (price × quantity for all products)
    public double getTotalInventoryValue() {
        double total = 0;

        for (Product product : products) {
            total += product.getPrice() * product.getQuantityInStock();
        }

        return total;
    }

    // void updateStock(String productId, int quantityChange) - updates stock (can be positive or negative)
    public void updateStock(String productId, int quantityChange) {
        Product product = findProduct(productId);

        if(product == null) {
            System.out.println("Product not found.");
            return;
        }

        int newQuantity = product.getQuantityInStock() + quantityChange;

        if(newQuantity < 0) {
            System.out.println("Error: Stock cannot be negative.");
            return;
        }

        product.setQuantityInStock(newQuantity);
        System.out.println("Stock updated. New quantity " + newQuantity);
    }

    // void printAllProducts() - prints all products in a formatted table
    public void printAllProducts() {

        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.printf("%-10s %-20s %-15s %-10s %-10s%n" ,
            "ID", "Name", "Category", "Price", "Quantity");

        System.out.println("-----------------------------------------------------------------------");

        for (Product p : products) {
            System.out.printf("%-10s %-20s %-15s %-10.2f %-10d%n",
                p.getProductId(),
                p.getName(),
                p.getCategory(),
                p.getPrice(),
                p.getQuantityInStock());
        }
    }

    //int getTotalProducts() - returns number of products
    public int getTotalProducts() {
        return products.size();
    }

    //void printCapacityInfo() - prints current size and capacity of the Vector
    public void printCapacityInfo() {
        System.out.println("Current Size: " + products.size());
        System.out.println("Current Capacity: " + products.capacity());
    }

    //void optimizeCapacity() - uses trimToSize() to reduce capacity to match size
    public void optimizeCapacity() {
        products.trimToSize();
        System.out.println("Vector capacity optimized to match current size.");
    }

    //void ensureCapacity(int minCapacity) - ensures Vector has at least minCapacity
    public void ensureCapacity(int minCapacity) {
        products.ensureCapacity(minCapacity);
        System.out.println("Vector capacity ensured to be at least " + minCapacity);
    }

    //void printCapacityReport() - prints detailed capacity information
    // Current size ,Current capacity, Capacity utilization percentage, How many elements can be added before resize
    public void printCapacityReport() {

        // Number of elements
        int size = products.size();   
        // Total storage capacity           
        int capacity = products.capacity();      

        double utilization = 0;
        if (capacity > 0) {
            utilization = ((double) size / capacity) * 100;
        }

        // Remaining elements before resize
        int remaining = capacity - size;   

        System.out.println("----- Capacity Report -----");
        System.out.println("Current Size: " + size);
        System.out.println("Current Capacity: " + capacity);
        System.out.printf("Capacity Utilization: %.2f%%%n", utilization);
        System.out.println("Elements Before Resize: " + remaining);
    }

    /**
    * Prints all products using Enumeration.
    * Enumeration is an older way to loop through collections like Vector.
    * It is considered legacy because Iterator is more flexible and supports removal.
    * Enumeration is mainly used when working with older (legacy) code or APIs that require it.
    */
    public void printProductsUsingEnumeration() {

        // Check if inventory is empty
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        // elements() returns an Enumeration object for the Vector
        java.util.Enumeration<Product> enumeration = products.elements();

        // Print table header
        System.out.printf("%-10s %-20s %-15s %-10s %-10s%n",
            "ID", "Name", "Category", "Price", "Quantity");

        System.out.println("-----------------------------------------------------------------------");

        // Loop through Vector using Enumeration
        while (enumeration.hasMoreElements()) {

        // Get next product from Enumeration
        Product p = enumeration.nextElement();

        // Print product details
        System.out.printf("%-10s %-20s %-15s %-10.2f %-10d%n",
                p.getProductId(),
                p.getName(),
                p.getCategory(),
                p.getPrice(),
                p.getQuantityInStock());
        }
    }

}
