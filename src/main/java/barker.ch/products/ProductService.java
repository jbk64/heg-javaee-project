package barker.ch.products;


import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.logging.Logger;

@Singleton
public class ProductService {

    Logger log = Logger.getLogger(ProductService.class.getName());

    @Inject
    private ProductDao productDao;

    public ProductService() {}

    public void addProduct(Product product) {
        productDao.save(product);
    }

    public Product getProduct(Long id) {
        return productDao.findById(id);
    }

    public ArrayList<Product> getAllProducts() {
        return productDao.getProducts();
    }

    public int getCartSize() {
        return 7;
    }
}
