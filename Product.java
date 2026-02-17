// Task 1.1: Product Class
//Reprsents a product stored in inventory
public class Product {
    // Fields
    private String productId;
    private String name;
    private String category;
    private double price;
    private int quantityInStock;
    private String supplier;

    //Methods
    // Constructor
    public Product(String productId, String name, String category, double price, int quantityInStock, String supplier) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.supplier = supplier;
    }

    //Getters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public String getSupplier() {
        return supplier;
    }

    //Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
         this.quantityInStock = quantityInStock;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    // String representation
    @Override
    public String toString() {
        return String.format("Product[ID: %s, Name: %s, Category: %s, Price: %.2f, QuantityInStock: %d, Supplier: %s]",
            productId, name, category, price, quantityInStock, supplier);
    }

    // Compare by product by productId
    @Override 
    public boolean equals(Object obj) {
        
        if (this == obj) 
            return true;

        if (obj == null || getClass() != obj.getClass()) 
            return false;
    
        Product other = (Product) obj;
        return productId != null && productId.equals(other.productId);
    }

    // Consistent with equals()
    @Override
    public int hashCode() {
        return productId == null ? 0 : productId.hashCode();
    }
}
