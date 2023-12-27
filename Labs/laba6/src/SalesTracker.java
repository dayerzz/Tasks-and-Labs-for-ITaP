import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SalesTracker {
    private ConcurrentHashMap<String, AtomicInteger> salesData;

    public SalesTracker() {
        salesData = new ConcurrentHashMap<>();
    }

    public void addSale(String product, int quantity) {
        salesData.putIfAbsent(product, new AtomicInteger(0));
        salesData.get(product).addAndGet(quantity);
    }

    public void printSalesReport() {
        System.out.println("Sales Report:");
        for (String product : salesData.keySet()) {
            int quantity = salesData.get(product).get();
            System.out.println(product + ": " + quantity);
        }
    }

    public int getTotalSales() {
        int totalSales = 0;
        for (AtomicInteger quantity : salesData.values()) {
            totalSales += quantity.get();
        }
        return totalSales;
    }

    public String getMostPopularProduct() {
        String mostPopularProduct = null;
        int maxQuantity = 0;
        for (String product : salesData.keySet()) {
            int quantity = salesData.get(product).get();
            if (quantity > maxQuantity) {
                mostPopularProduct = product;
                maxQuantity = quantity;
            }
        }
        return mostPopularProduct;
    }

    public static void main(String[] args) {
        SalesTracker salesTracker = new SalesTracker();
        salesTracker.addSale("Product A", 5);
        salesTracker.addSale("Product B", 10);
        salesTracker.addSale("Product A", 3);
        salesTracker.addSale("Product C", 8);

        salesTracker.printSalesReport();

        int totalSales = salesTracker.getTotalSales();
        System.out.println("Total Sales: " + totalSales);

        String mostPopularProduct = salesTracker.getMostPopularProduct();
        System.out.println("Most Popular Product: " + mostPopularProduct);
    }
}