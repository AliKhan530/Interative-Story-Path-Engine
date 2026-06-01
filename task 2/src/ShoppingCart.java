import java.util.HashMap;
import java.util.Map;
public class ShoppingCart {
    private HashMap<Product, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }
    public void addProduct(Product product, int quantity) {

        if (cart.containsKey(product)) {

            int currentQty = cart.get(product);
            cart.put(product, currentQty + quantity);

        } else {

            cart.put(product, quantity);
        }
    }
    public void updateQuantity(Product product, int quantity) {

        if (cart.containsKey(product)) {

            cart.put(product, quantity);

        } else {

            System.out.println(product.getName() + " not found.");
        }
    }

    public void removeProduct(Product product) {

        cart.remove(product);
    }

    public double calculateTotalCost() {

        double total = 0;

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {

            Product product = entry.getKey();
            int quantity = entry.getValue();

            total += product.getPrice() * quantity;
        }
        return total;
    }
    public int totalItems() {

        int total = 0;

        for (int quantity : cart.values()) {

            total += quantity;
        }

        return total;
    }

    public void displayCart() {

        System.out.println("\n===== SHOPPING CART =====");

        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {

            Product product = entry.getKey();
            int quantity = entry.getValue();

            System.out.println(
                    "ID: " + product.getId()
                            + " | Name: " + product.getName()
                            + " | Price: $" + product.getPrice()
                            + " | Quantity: " + quantity);
        }
        System.out.println("--------------------------");
        System.out.println("Total Items: " + totalItems());
        System.out.println("Total Cost : $" + calculateTotalCost());
    }
}
