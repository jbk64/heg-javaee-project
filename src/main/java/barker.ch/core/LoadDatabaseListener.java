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
        log.info("Servlet context initialized");
        productService.test();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("Servlet context destroyed");
    }

    private void loadDatabase() {
        log.info("Loading database.");
        Product productA = new Product("Product A", "Description of product A");
        // productService.addProduct(productA);
        log.info("Database loaded");

    }
}
