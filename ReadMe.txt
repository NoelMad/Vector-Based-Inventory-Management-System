Vector-Based Inventory Management System

## Overview

This project implements a **Vector-based inventory management system** in Java. It demonstrates the use of `Vector`, generics, enumeration, thread safety, and performance comparison with `ArrayList`. The system supports product management, order processing, and utility operations.

---

## Class Descriptions

### 1. **Product**

Represents a store product with the following attributes:

* `productId`
* `name`
* `category`
* `price`
* `quantityInStock`
* `supplier`

Provides constructors, getters/setters, `toString()`, `equals()`, and `hashCode()`.

---

### 2. **ProductInventory**

Manages a `Vector<Product>` and supports:

* Adding/removing products (duplicate check by `productId`)
* Finding products
* Filtering by category or low stock
* Updating stock
* Calculating total inventory value
* Printing inventory
* Capacity management (`trimToSize()`, `ensureCapacity()`)

Demonstrates `Enumeration` usage.

---

### 3. **OrderItem**

Represents an item in an order:

* `productId`
* `productName`
* `quantity`
* `unitPrice`
* `subtotal`

Includes methods to calculate subtotal and standard getters/setters.

---

### 4. **Order**

Represents a customer order with:

* `orderId`
* `customerName`
* `orderDate`
* `Vector<OrderItem> items`
* `orderStatus`

Supports adding/removing/finding items, calculating total, updating status, and printing order details.

---

### 5. **OrderManager**

Manages a `Vector<Order>` and supports:

* Adding orders
* Searching by `orderId`
* Filtering by customer or status
* Canceling orders
* Calculating total revenue
* Printing all orders

---

### 6. **VectorUtils**

Provides generic utility methods for `Vector`s:

* Swap two elements
* Find maximum element
* Count occurrences
* Filter elements by condition
* Bounded numeric operations: sum and average

---

### 7. **GenericContainer<T>**

Generic wrapper for `Vector<T>` with type-safe operations:

* Add, remove, get, size, clear, contains
* Add all elements
* Return all items

---

### 8. **VectorComparisonDemo**

Demonstrates performance differences between `Vector<Product>` and `ArrayList<Product>` for:

* Adding, removing, and accessing elements
* Measures time and memory usage

---

### 9. **InventorySystemMain**

Main application integrating all components:

* Product management
* Order processing
* Vector capacity management
* Generic utilities
* Optional interactive menu for operations
* Generates reports

---

### 10. **ThreadSafetyDemo (Bonus)**

Demonstrates thread-safety characteristics of `Vector` vs `ArrayList` with concurrent:

* Add operations
* Remove operations
* Read operations

---

## How to Compile and Run

1. Compile all classes:

```bash
javac *.java
```

2. Run the main application:

```bash
java InventorySystemMain
```

3. Optional: Run the thread safety demo:

```bash
java ThreadSafetyDemo
```

---

## Assumptions

* `productId` and `orderId` are unique.
* `OrderItem` subtotal recalculates automatically when quantity or price changes.
* Dates use simple `"YYYY-MM-DD"` strings.
* Thread-safety demo assumes multiple threads access shared collections.
* Users input valid data for interactive menu operations.

---

## Challenges Encountered

* Handling duplicate `productId`s
* Understanding Vector capacity management
* Implementing generic methods for multiple types
* Comparing performance between `Vector` and `ArrayList`
* Handling edge cases (empty Vectors, invalid IDs)

---

## Lessons Learned

### Vectors and Generics

* `Vector` is synchronized (thread-safe) but slower in single-threaded scenarios
* Capacity management optimizes memory usage
* Generics provide type safety and reduce casting
* Generic utilities improve code reusability

### Practical Insights

* Vector operations require validation for duplicates
* `Enumeration` is legacy; prefer `Iterator` or enhanced for-loops
* `ArrayList` is faster in single-threaded programs; `Vector` is safer for concurrent access

---

## Performance and Thread Safety Summary

**Performance Differences:**

* `ArrayList` is faster due to no synchronization overhead
* `Vector` is slower but thread-safe

**When to Use Vector:**

* Multiple threads may access the collection concurrently
* Legacy systems using `Vector`

**When to Use ArrayList:**

* Modern, single-threaded programs
* External synchronization can be applied if needed

**Thread Safety Comparison:**

| Collection | Thread Safety | Performance | Notes                      |
| ---------- | ------------- | ----------- | -------------------------- |
| Vector     | Yes           | Slower      | Safe for concurrent access |
| ArrayList  | No            | Faster      | May fail under concurrency |

**Conclusion:** `Vector` is thread-safe but slower; `ArrayList` is faster but requires external synchronization for multi-threaded use.

