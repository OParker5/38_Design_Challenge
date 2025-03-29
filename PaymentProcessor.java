public class PaymentProcessor {
    // Internal "service" methods (could be extracted to separate classes later)
    private double findDiscountPercent(int discountCode) {
        return discountCode > 100 ? 0.2 : 0.1; // Example
    }

    private boolean checkInventory(Order order) {
        // Logic to verify inventory (e.g., database call)
        return order.getItems().stream().allMatch(item -> item.isInStock());
    }

    private double calculateShipping(Order order) {
        return order.getWeight() * 0.5; 
    }

    private void logAnalytics(Order order) {
        System.out.println("Analytics: Order " + order.getId() + " processed");
    }

    // Core processor method (now streamlined)
    public PaymentResult processTransaction(Order order, User user, int discountCode) {
        // Step 1: Validate
        if (!user.isLoggedIn()) {
            return PaymentResult.failure("User not logged in");
        }

        // Step 2: Apply discount
        if (discountCode > 0) {
            order.setDiscount(findDiscountPercent(discountCode));
        }

        // Step 3: Check inventory
        if (!checkInventory(order)) {
            return PaymentResult.failure("Insufficient inventory");
        }

        // Step 4: Calculate shipping
        order.setShipping(calculateShipping(order));

        // Step 5: Analytics
        logAnalytics(order);

        // Step 6: Process payment (simplified)
        boolean paymentSuccess = Math.random() > 0.5; // Mock payment result
        return paymentSuccess 
            ? PaymentResult.success("Payment completed")
            : PaymentResult.failure("Payment declined");
    }

    // Immutable result container
    public static record PaymentResult(boolean success, String message) {
        public static PaymentResult success(String msg) {
            return new PaymentResult(true, msg);
        }
        public static PaymentResult failure(String error) {
            return new PaymentResult(false, error);
        }
    }
}