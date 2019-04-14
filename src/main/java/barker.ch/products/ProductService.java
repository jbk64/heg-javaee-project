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

    public Product getProduct(Long id) {
        return productDao.findById(id);
    }

    public ArrayList<Product> getAllProducts() {
        return productDao.getAll();
    }

    public ArrayList<Product> getFrontpageProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(productDao.findById(1L));
        products.add(productDao.findById(2L));
        products.add(productDao.findById(3L));
        return products;
    }

    public int getCartSize() {
        return productDao.getCartSize();
    }

    public ArrayList<Product> getCartProducts() {
        return productDao.getCartProducts();
    }
}
