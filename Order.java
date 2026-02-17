//Create an Order class:
import java.util.Vector;

public class Order {
    
    //Fields
    private String orderId;
    private String customerName;
    private String orderDate;
    private Vector<OrderItem> items;
    private String orderStatus;

    public Order(String orderId, String customerName,
        String orderDate, String orderStatus) {
           this.orderId = orderId;
           this.customerName = customerName;
           this.orderDate = orderDate;
           this.orderStatus = orderStatus = "Pending";
           this.items = new Vector<>(); 

    }

   //Methods
   // Getters
public String getOrderId() {
    return orderId;
}

public String getCustomerName() {
    return customerName;
}

public String getOrderDate() {
    return orderDate;
}


public String getOrderStatus() {
    return orderStatus;
}

// Setters
public void setOrderId(String orderId) {
    this.orderId = orderId;
}

public void setCustomerName(String customerName) {
    this.customerName = customerName;
}

public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
}

public void setItems(Vector<OrderItem> items) {
    this.items = new Vector<>(items); // protects internal vector from outside changes
}

public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
}

   //void addItem(OrderItem item) - adds item to order
   public void addItem(OrderItem item) {
        if (item == null) {
            System.out.println("Cannot add null item.");
            return;
        }
        items.add(item);
   }

   //boolean removeItem(String productId) - removes item by productId
   public boolean removeItem(String productId) {
        if (productId == null || productId.isEmpty()) {
            return false;
        }
        for(int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId().equals(productId)) {
                items.remove(i);
                return true;
        }
    }
    return false;
   }

   //OrderItem findItem(String productId) - finds item in order
   public OrderItem findItem(String productId) {
        if (productId == null || productId.isEmpty()) {
            return null;
        }
        for (OrderItem item : items) {
        if (item.getProductId().equals(productId)) {
            return item;
        }
    }
        return null;
   }

   //double calculateTotal() - calculates total order value
   public double calculateTotal() {
    double total = 0;

    for (OrderItem item : items) {
        total += item.calculateSubtotal();
    }
    return total;
   }

   //int getTotalItems() - returns total quantity of all items
   public int getTotalItems() {
        int totalQuantity = 0;

        for (OrderItem item : items) {
            totalQuantity += item.getQuantity();
        }

        return totalQuantity;
   }

   //void updateStatus(String newStatus) - updates order status
   public void updateStatus (String newStatus) {
        this.orderStatus = newStatus;
   }

   //void printOrder() - prints formatted order details
   public void printOrder() {
        System.out.println("===== ORDER DETAILS =====");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Date: " + orderDate);
        System.out.println("Status: " + orderStatus);
        System.out.println("\nItems");

        for (OrderItem item : items) {
            System.out.println(item);
        }

        System.out.println("\nTotal Items: " + getTotalItems());
        System.out.printf("Total Cost: $%.2f\n", calculateTotal());
        System.out.println("======================");
   }

   //Vector<OrderItem> getItems() - returns copy of items Vector
   public Vector<OrderItem> getItems() {
        return new Vector<>(items);
   }
}
