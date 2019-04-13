package barker.ch.products;


import javax.inject.Inject;
import java.util.logging.Logger;

public class ProductService {

    Logger log = Logger.getLogger(ProductService.class.getName());

    @Inject
    private ProductDao productDao;

    public ProductService() {}

    public void test() {
        log.info("Hello from ProductService.");
        productDao.test();
    }
}
