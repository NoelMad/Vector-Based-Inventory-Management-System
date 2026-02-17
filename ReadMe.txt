# README.txt

## Homework 1: Vector-Based Inventory Management System

### Brief Description of Each Class

1. **Product**
   Represents a store product with `productId`, `name`, `category`, `price`, `quantityInStock`, and `supplier`. Provides constructors, getters/setters, `toString()`, `equals()`, and `hashCode()`.

2. **ProductInventory**
   Manages a `Vector<Product>` inventory. Supports adding/removing products, finding products, filtering by category or low stock, updating stock, calculating total inventory value, printing inventory, and capacity management. Demonstrates Enumeration usage.

3. **OrderItem**
   Represents an item in an order with `productId`, `productName`, `quantity`, `unitPrice`, and `subtotal`. Methods include calculating subtotal and standard getters/setters.

4. **Order**
   Represents a customer order with `orderId`, `customerName`, `orderDate`, `Vector<OrderItem> items`, and `orderStatus`. Methods allow adding/removing/finding items, calculating total, updating status, and printing order details.

5. **OrderManager**
   Manages `Vector<Order>` orders. Supports adding orders, searching by orderId, filtering by customer or status, canceling orders, calculating total revenue, and printing all orders.

6. **VectorUtils**
   Provides generic utility methods for `Vector`s:

   * Swap two elements
   * Find maximum element
   * Count occurrences
   * Filter elements based on a condition
   * Bounded methods for Numbers: sum and average

7. **GenericContainer<T>**
   Generic wrapper for `Vector<T>` with type-safe operations: add, remove, get, size, clear, contains, addAll, and returning all items.

8. **VectorComparisonDemo**
   Demonstrates performance differences between `Vector<Product>` and `ArrayList<Product>` for adding, removing, and accessing elements. Measures time and memory usage.

9. **InventorySystemMain**
   Main application integrating all components. Demonstrates product management, order processing, Vector capacity management, generic utilities, and generates reports. Optional menu system for interactive operations.

10. **ThreadSafetyDemo (Bonus)**
    Demonstrates thread-safety characteristics of `Vector` vs `ArrayList` with concurrent add, remove, and read operations.

---

### How to Compile and Run

1. Compile all classes:

```bash
javac *.java
```

2. Run the main application:

```bash
java InventorySystemMain
```

3. Optional: Run thread safety demo:

```bash
java ThreadSafetyDemo
```

---

### Assumptions Made

* `productId` and `orderId` are unique.
* `OrderItem` subtotal recalculates when quantity or price changes.
* Dates are simple strings in `"YYYY-MM-DD"` format.
* Thread-safety demo assumes multiple threads access shared collections.
* Users input valid product and order data for interactive menu operations.

---

### Challenges Encountered

* Handling duplicate `productId`s.
* Understanding Vector capacity (`trimToSize()` vs `ensureCapacity()`).
* Implementing generic methods for multiple types.
* Comparing performance between `Vector` and `ArrayList`.
* Handling edge cases like empty Vectors or invalid IDs.

---

### What I Learned

* **Vectors and Generics:**

  * Vectors are synchronized (thread-safe) but slower in single-threaded contexts.
  * Vector capacity management optimizes memory usage.
  * Generics provide type safety and reduce casting.
  * Generic utility methods make code reusable and flexible.

* **Practical Insights:**

  * Vector operations are straightforward but require validation for duplicates.
  * Enumeration is legacy; prefer `Iterator` or enhanced for-loop.
  * ArrayList is faster in single-threaded programs; Vector is safer for concurrent access.

---

### Performance and Thread Safety Summary

**Performance Differences Observed:**

* `ArrayList` is faster for adding/accessing elements due to lack of synchronization overhead.
* `Vector` is slower because all methods are synchronized for thread safety.

**When to Choose Vector:**

* Use when multiple threads may access the collection concurrently.
* Useful for legacy systems using Vector.

**When to Choose ArrayList:**

* Best for modern, single-threaded programs.
* Thread safety can be handled externally if needed.

**Thread Safety Comparison (Vector vs ArrayList):**

* **Vector:** Successfully handled concurrent operations; slower due to synchronization.
* **ArrayList:** May produce runtime errors under concurrent access; faster in single-threaded scenarios.
* **Conclusion:** Vector is thread-safe but slower; ArrayList is faster but unsafe for concurrent use without external synchronization.


