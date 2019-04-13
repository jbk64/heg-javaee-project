package barker.ch.products;


import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
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

    public ArrayList<Product> getAllProducts() {
        return productDao.getProducts();
    }
}
