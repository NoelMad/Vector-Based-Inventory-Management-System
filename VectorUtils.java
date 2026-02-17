import java.util.Vector;
import java.util.function.Predicate;

public class VectorUtils {

    // Method 1: Generic Swap
    public static <T> void swap(Vector<T> vec, int index1, int index2) {

        if (index1 < 0 || index2 < 0 || 
            index1 >= vec.size() || index2 >= vec.size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        T temp = vec.get(index1);
        vec.set(index1, vec.get(index2));
        vec.set(index2, temp);
    }


   
    // Method 2: Generic Find Maximum
    public static <T extends Comparable<T>> T findMax(Vector<T> vec) {

        if (vec == null || vec.isEmpty()) {
            return null;
        }

        T max = vec.get(0);

        for (T item : vec) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }

        return max;
    }

    // Method 3: Generic Count Matches
    public static <T> int countMatches(Vector<T> vec, T target) {

        int count = 0;

        for (T item : vec) {
            if (item.equals(target)) {
                count++;
            }
        }

        return count;
    }


    // Method 4: Generic Filter (Using Predicate)
    public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition) {

        Vector<T> result = new Vector<>();

        for (T item : vec) {
            if (condition.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    // Method 5: Sum Numbers
    public static <T extends Number> double sumNumbers(Vector<T> numbers) {

        double sum = 0.0;

        for (T num : numbers) {
            // Convert each number to double for accurate summation
            sum += num.doubleValue(); 
        }

        return sum;
    }


    // Method 6: Average Numbers
    public static <T extends Number> double averageNumbers(Vector<T> numbers) {

        if (numbers == null || numbers.isEmpty()) {
            return 0.0;
        }

        double sum = sumNumbers(numbers);
        return sum / numbers.size();
    }

}

