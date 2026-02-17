import java.util.Scanner;
import java.util.Vector;

public class InventorySystemMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create system objects
        ProductInventory inventory = new ProductInventory();
        OrderManager orderManager = new OrderManager();

        // Add sample products
        inventory.addProduct(new Product("P001", "Laptop", null, 999.99, 10, null));
        inventory.addProduct(new Product("P002", "Keyboard", null, 49.99, 25, null));
        inventory.addProduct(new Product("P003", "Mouse", null, 29.99, 50, null));

        // Vector capacity demo
        System.out.println("=== VECTOR CAPACITY DEMO ===");
        Vector<Product> vec = new Vector<>(2, 2);
        System.out.println("Initial Capacity: " + vec.capacity());

        vec.add(new Product("PX1", "Test1", null, 10, 1, null));
        vec.add(new Product("PX2", "Test2", null, 20, 1, null));
        vec.add(new Product("PX3", "Test3", null, 30, 1, null));

        System.out.println("Capacity After Adding 3 Elements: " + vec.capacity());
        System.out.println();

        // Generic utility demo
        System.out.println("=== GENERIC UTILITY DEMO ===");
        Vector<Integer> numbers = new Vector<>();
        numbers.add(5);
        numbers.add(15);
        numbers.add(10);

        System.out.println("Numbers Before Swap: " + numbers);
        VectorUtils.swap(numbers, 0, 1);
        System.out.println("Numbers After Swap: " + numbers);

        Integer maxNumber = VectorUtils.findMax(numbers);
        System.out.println("Max Number: " + maxNumber);
        System.out.println();

        // Menu loop
        boolean running = true;
        while (running) {
            System.out.println("\n===== INVENTORY SYSTEM MENU =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Find Product");
            System.out.println("4. List All Products");
            System.out.println("5. Create Order");
            System.out.println("6. View Orders");
            System.out.println("7. Process Order");
            System.out.println("8. Generate Reports");
            System.out.println("9. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1: // Add Product
                    System.out.print("Product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();

                    inventory.addProduct(new Product(id, name, "General", price, qty, "DefaultSupplier"));
                    System.out.println("Product Added.");
                    break;

                case 2: // Remove Product
                    System.out.print("Enter Product ID to remove: ");
                    String removeId = scanner.nextLine();
                    if (inventory.removeProduct(removeId)) {
                        System.out.println("Product Removed.");
                    } else {
                        System.out.println("Product Not Found.");
                    }
                    break;

                case 3: // Find Product
                    System.out.print("Enter Product ID to find: ");
                    String findId = scanner.nextLine();
                    Product found = inventory.findProduct(findId);
                    System.out.println(found != null ? found : "Product Not Found.");
                    break;

                case 4: // List All Products
                    inventory.printAllProducts();
                    break;

                case 5: // Create Order
                    System.out.print("Order ID: ");
                    String orderId = scanner.nextLine();
                    System.out.print("Customer Name: ");
                    String customer = scanner.nextLine();
                    System.out.print("Order Date: ");
                    String date = scanner.nextLine();

                    Order order = new Order(orderId, customer, date, "Pending");
                    boolean addingItems = true;
                    while (addingItems) {
                        System.out.print("Enter Product ID: ");
                        String pId = scanner.nextLine();
                        Product product = inventory.findProduct(pId);
                        if (product == null) {
                            System.out.println("Product not found.");
                            continue;
                        }

                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        order.addItem(new OrderItem(product.getProductId(), product.getName(), quantity, product.getPrice()));

                        System.out.print("Add another item? (y/n): ");
                        String more = scanner.nextLine();
                        if (!more.equalsIgnoreCase("y")) {
                            addingItems = false;
                        }
                    }
                    orderManager.addOrder(order);
                    System.out.println("Order Created.");
                    break;

                case 6: // View Orders
                    orderManager.printAllOrders();
                    break;

                case 7: // Process Order
                    System.out.print("Enter Order ID to process: ");
                    String processId = scanner.nextLine();
                    if (orderManager.processOrder(processId)) {
                        System.out.println("Order Processed.");
                    } else {
                        System.out.println("Order Processing Failed.");
                    }
                    break;

                case 8: // Reports
                    System.out.println("\n=== SYSTEM REPORTS ===");
                    System.out.println("\nInventory Report:");
                    inventory.printAllProducts();
                    System.out.println("\nOrders Report:");
                    orderManager.printAllOrders();
                    break;

                case 9: // Exit
                    running = false;
                    System.out.println("Exiting System...");
                    break;

                default:
                    System.out.println("Invalid Option.");
            }
        }

        scanner.close();
    }
}
