import java.util.*;

public class ECommercePlatform {
    private Map<Integer, User> users;
    private Map<Integer, Product> products;
    private Map<Integer, Order> orders;

    public ECommercePlatform() {
        this.users = new HashMap<>();
        this.products = new HashMap<>();
        this.orders = new HashMap<>();
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Map<Integer, Order> getOrders() {
        return orders;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    public void createOrder(Integer userId, Map<Product, Integer> orderDetails) {
        Order order = new Order(orders.size() + 1, userId);
        order.setOrderDetails(orderDetails);
        order.calculateTotalPrice();
        orders.put(order.getId(), order);

        for (Map.Entry<Product, Integer> entry : orderDetails.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setStock(product.getStock() - quantity);
        }
    }

    public List<Product> recommendProducts(User user) {
        List<Product> recommendedProducts = new ArrayList<>();
        return recommendedProducts;
    }
}
