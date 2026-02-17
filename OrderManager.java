//Create an OrderManager class using Vector<Order>:

import java.util.Vector;

public class OrderManager {
    //Field
    private Vector<Order> orders;

    // Constructor
    public OrderManager() {
        orders = new Vector<>();
    }

    //Method
    //void addOrder(Order order) - adds order
    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }
    //Order findOrder(String orderId) - finds order by ID
    public Order findOrder(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }
    //Vector<Order> getOrdersByStatus(String status) - returns orders with specific status
    public Vector<Order> getOrdersByStatus(String status) {
        Vector<Order> result = new Vector<>();

        for (Order order : orders) {
            if (order.getOrderStatus().equalsIgnoreCase(status)) {
                result.add(order);
            }
        }

        return result;
    }
    //Vector<Order> getOrdersByCustomer(String customerName) - returns customer's orders
    public Vector<Order> getOrdersByCustomer(String customerName) {
        Vector<Order> result = new Vector<>();

        for (Order order : orders) {
            if (order.getCustomerName().equalsIgnoreCase(customerName)) {
                result.add(order);
            }
        }

        return result;
    }
    //double getTotalRevenue() - calculates total revenue from all delivered orders
    public double getTotalRevenue() {
        double total = 0;

        for (Order order : orders) {
            if (order.getOrderStatus().equalsIgnoreCase("Delivered")) {
                total += order.calculateTotal();
            }
        }

        return total;
    }
    //void cancelOrder(String orderId) - cancels order (updates status)
    public void cancelOrder(String orderId) {
        Order order = findOrder(orderId);

        if (order != null) {
            order.updateStatus("Cancelled");
        }
    }
    //void printAllOrders() - prints all orders
     public void printAllOrders() {
        for (Order order : orders) {
            order.printOrder();
            System.out.println("----------------------");
        }
    }
    //Vector<Order> getPendingOrders() - returns pending orders
    public Vector<Order> getPendingOrders() {
        Vector<Order> pending = new Vector<>();

        for (Order order : orders) {
            if (order.getOrderStatus().equalsIgnoreCase("Pending")) {
                pending.add(order);
            }
        }
            return pending;
        }
    //int getOrderCount() - returns number of orders
         public int getOrderCount() {
        return orders.size();
    }

    public boolean processOrder(String orderId) {
    Order order = findOrder(orderId);

    if (order == null) {
        return false;
    }

    order.updateStatus("Processed");
    return true;
}

}
