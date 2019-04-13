package barker.ch.products;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ProductDao {

    private Logger log = Logger.getLogger(ProductDao.class.getName());
    private Map<Long, Product> products = new HashMap<>();

    public ProductDao() {}

    Product findById(Long id) {
        return products.get(id);
    }

    void save(Product product) {
        products.put(product.getId(), product);
        log.info("Product saved.");
    }

    List getProducts() {
        return new ArrayList<>(products.values());
    }
}
