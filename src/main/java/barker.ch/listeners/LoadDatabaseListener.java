package barker.ch.listeners;

import barker.ch.products.Product;
import barker.ch.products.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.logging.Logger;

@WebListener
public class LoadDatabaseListener implements ServletContextListener {

    private Logger log = Logger.getLogger(LoadDatabaseListener.class.getName());

    @Inject
    private ProductService productService;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info("Servlet context initialized.");
        loadProducts();
        checkProducts();
        log.info("Products loaded.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("Servlet context destroyed");
    }

    private void loadProducts() {
        try {
            productService.addProduct(new Product("Product A", "Description A", 99.90, true));
            productService.addProduct(new Product("Product B", "Description B", 114.90, false));
            productService.addProduct(new Product("Product C", "Description C", 99.90, false));
            productService.addProduct(new Product("Product D", "Description D", 49.90, true));
            productService.addProduct(new Product("Product E", "Description E", 199.90, false));
            productService.addProduct(new Product("Product F", "Description F", 299.90, false));
            productService.addProduct(new Product("Product G", "Description G", 14.90, false));
            productService.addProduct(new Product("Product H", "Description H", 44.90, false));
            productService.addProduct(new Product("Product I", "Description I", 99.90, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkProducts() {
        try {
            Product product = productService.getProduct(1L);
            log.info(product.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
