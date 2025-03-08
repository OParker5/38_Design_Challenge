import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShippingOrder {
    private final List<Item> items;
    private final String address;
    private final double totalWeight;
    private double shippingCost;
    private final ShippingCalculator shippingCalculator;
    private final OrderNotifier orderNotifier;

    // Constructor (core logic only)
    public ShippingOrder(List<Item> items, String address, 
                        ShippingCalculator calculator, OrderNotifier notifier) {
        this.items = new ArrayList<>(items); // Defensive copy
        this.address = address;
        this.totalWeight = calculateTotalWeight();
        this.shippingCalculator = calculator;
        this.orderNotifier = notifier;
    }

    // Deferred calculation (lazy initialization)
    public double getShippingCost() {
        if (shippingCost == 0.0) {
            shippingCost = shippingCalculator.calculateRate(address, totalWeight);
            orderNotifier.notifyAnalytics(this); // Side effect only on first access
        }
        return shippingCost;
    }

    // Pure calculation (no side effects)
    private double calculateTotalWeight() {
        return items.stream().mapToDouble(Item::getWeight).sum();
    }

    // Immutable view of items
    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    // Strategy interface for shipping rates
    public interface ShippingCalculator {
        double calculateRate(String address, double weight);
    }

    // External service for notifications
    public static class OrderNotifier {
        public void notifyAnalytics(ShippingOrder order) {
            System.out.println("Analytics logged for order to " + order.address);
        }
    }
}