import java.util.*;

public class Order {
    private Integer id;
    private Integer userId;
    private Map<Product, Integer> orderDetails;
    private double totalPrice;

    public Order(Integer id, Integer userId) {
        this.id = id;
        this.userId = userId;
        this.orderDetails = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<Product, Integer> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<Product, Integer> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void calculateTotalPrice() {
        totalPrice = orderDetails.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }
}
