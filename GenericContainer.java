import java.util.Vector;

public class GenericContainer<T> {

    // Field
    private Vector<T> items;

    // Constructor
    public GenericContainer() {
        items = new Vector<>();
    }

    // Add item
    public void add(T item) {
        items.add(item);
    }

    // Get item by index
    public T get(int index) {
        return items.get(index);
    }

    // Remove item
    public boolean remove(T item) {
        return items.remove(item);
    }

    // Get size
    public int size() {
        return items.size();
    }

    // Return copy of all items
    public Vector<T> getAll() {
        // protects internal vector from outside changes
        return new Vector<>(items); 
    }

    // Clear container
    public void clear() {
        items.clear();
    }

    // Check if contains item
    public boolean contains(T item) {
        return items.contains(item);
    }

    // Add all items from another Vector
    public void addAll(Vector<T> other) {
        if (other != null) {
            items.addAll(other);
        }
    }
}
