package barker.ch.core;

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
            productService.addProduct(new Product("Product A", "Description A"));
            productService.addProduct(new Product("Product B", "Description B"));
            productService.addProduct(new Product("Product C", "Description C"));
            productService.addProduct(new Product("Product D", "Description D"));
            productService.addProduct(new Product("Product E", "Description E"));
            productService.addProduct(new Product("Product F", "Description F"));
            productService.addProduct(new Product("Product G", "Description G"));
            productService.addProduct(new Product("Product H", "Description H"));
            productService.addProduct(new Product("Product I", "Description I"));
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
