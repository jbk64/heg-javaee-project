package barker.ch.products;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

public class ProductDao {

    private Logger log = Logger.getLogger(ProductDao.class.getName());

    private EntityManager manager;

    public ProductDao() {}

    public ProductDao(EntityManager manager) {
        this.manager = manager;
    }

    Product findById(Long id) {
        return manager.find(Product.class, id);
    }

    void save(Product product) {
        manager.getTransaction().begin();
        manager.persist(product);
        manager.getTransaction().commit();
    }

    @SuppressWarnings("JpaQlInspection")
    List getProducts() {
        Query query = manager.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    void test() {
        log.info("Hello from ProductDao.");
    }
}
