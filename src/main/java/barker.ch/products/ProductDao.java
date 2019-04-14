package barker.ch.products;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ProductDao {

    private Logger log = Logger.getLogger(ProductDao.class.getName());

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    private Map<Long, Product> products = new HashMap<>();

    public ProductDao() {}

    Product findById(Long id) {
        EntityManager em = getEntityManager();
        Product product = em.find(Product.class, id);
        if(product == null) {
            throw new ProductNotFoundException("Product with id " + id + " was not found.");
        }
        return product;
    }

    void save(Product product) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
    }

    List<Product> getAll() {
        EntityManager em = getEntityManager();
        return em.createQuery("SELECT p from Product p", Product.class).getResultList();
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

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}
