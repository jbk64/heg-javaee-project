package barker.ch.products;


import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

public class ProductService {

    Logger log = Logger.getLogger(ProductService.class.getName());

    @Inject
    private ProductDao productDao;

    public ProductService() {}

    public void addProduct(Product product) {
        productDao.save(product);
    }

    public List<Product> getAllProducts() {
        return productDao.getProducts();
    }
}
