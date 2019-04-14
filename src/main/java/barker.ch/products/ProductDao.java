package barker.ch.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ProductDao {

    private Logger log = Logger.getLogger(ProductDao.class.getName());
    private Map<Long, Product> products = new HashMap<>();

    public ProductDao() {}

    Product findById(Long id) {
        if(!products.containsKey(id)) {
            throw new ProductNotFoundException("Product with id " + id + " was not found.");
        }
        return products.get(id);
    }

    void save(Product product) {
        products.put(product.getId(), product);
    }

    ArrayList<Product> getAll() {
        return new ArrayList<>(products.values());
    }

    int getCartSize() {
        return getCartProducts().size();
    }

    ArrayList<Product> getCartProducts() {
        ArrayList<Product> cartProducts = new ArrayList<>();
        cartProducts.add(products.get(2L));
        cartProducts.add(products.get(5L));
        cartProducts.add(products.get(8L));
        cartProducts.add(products.get(3L));
        return cartProducts;
    }
}
