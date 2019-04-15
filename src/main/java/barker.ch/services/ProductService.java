package barker.ch.services;


import barker.ch.dao.ProductDao;
import barker.ch.models.Product;
import barker.ch.models.ShoppingCart;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.http.HttpServletRequest;
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

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    // TODO: change this
    public ArrayList<Product> getFrontpageProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(productDao.findById(1L));
        products.add(productDao.findById(2L));
        products.add(productDao.findById(3L));
        return products;
    }

    public int getCartSize(HttpServletRequest req) {
        ShoppingCart shoppingCart = (ShoppingCart) req.getSession().getAttribute("shoppingCart");
        if (shoppingCart == null) {
            return 0;
        }
        return shoppingCart.getCartSize();
    }

    public ShoppingCart getShoppingCart(HttpServletRequest req) {
        if (req.getSession().getAttribute("shoppingCart") == null) {
            req.getSession().setAttribute("shoppingCart", new ShoppingCart());
        }
        return (ShoppingCart)req.getSession().getAttribute("shoppingCart");
    }

    public void emptyCart(HttpServletRequest req) {
        req.getSession().removeAttribute("shoppingCart");
    }
}
