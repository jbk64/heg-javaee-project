package barker.ch.models;

import java.util.HashMap;

public class ShoppingCart {

    private HashMap<Product, Integer> content;

    public ShoppingCart() {
        this.content = new HashMap<>();
    }

    public void incrementItemQuantity(Product product) {
        int quantity = 1;
        if (this.content.containsKey(product)) {
            quantity = this.content.get(product) + 1;
        }
        this.content.put(product, quantity);
    }

    public void decrementItemQuantity(Product product) {
        int newCount = this.content.get(product) - 1;
        if (newCount == 0) {
            this.content.remove(product);
        } else {
            this.content.put(product, newCount);
        }
    }

    public HashMap<Product, Integer> getContent() {
        return content;
    }

    public int getCartSize() {
        return content.values().stream().mapToInt(Integer::intValue).sum();
    }
}
