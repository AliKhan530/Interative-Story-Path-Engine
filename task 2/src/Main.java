public class Main {
    public static void main(String[] args) {
        Product laptop =
                new Product(101, "Laptop", 1000);
        Product mouse =
                new Product(102, "Mouse", 20);
        Product keyboard =
                new Product(103, "Keyboard", 50);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(laptop, 1);
        cart.addProduct(mouse, 2);
        cart.addProduct(keyboard, 1);

        cart.displayCart();
        cart.updateQuantity(mouse, 5);
        System.out.println("\nAfter Updating Mouse Quantity:");
        cart.displayCart();
        cart.removeProduct(keyboard);
        System.out.println("\nAfter Removing Keyboard:");
        cart.displayCart();
    }
}