//Create an OrderItem class: 
public class OrderItem {
    // Fields                               
    private String productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    //Constructor(s)
    public OrderItem(Object productId, String productName, int quantity, Object unitPrice) {
        this.productId = (String) productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = (double) unitPrice;
        this.subtotal = calculateSubtotal();
    }

    //Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    //Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = calculateSubtotal();
    }

    public void setUnitPrice(double unitPrice){
        this.unitPrice = unitPrice;
        this.subtotal = calculateSubtotal();
    }

    //toString()
    @Override
    public String toString() {
        return "OrderItem[Id:" + productId + ", Name:" + productName + 
            ", Quantity:" + quantity + ", UnitPrice:" + unitPrice +
            ", Subtotal: "  + subtotal + "]";
    }

    //double calculateSubtotal() - calculates and updates subtotal
    public double calculateSubtotal() {
        this.subtotal = quantity * unitPrice;
        return subtotal;
    }
}
