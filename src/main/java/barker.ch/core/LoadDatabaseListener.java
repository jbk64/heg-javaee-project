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
        productService.addProduct(new Product(1L, "Product A", "Description A"));
        productService.addProduct(new Product(2L, "Product B", "Description B"));
        productService.addProduct(new Product(3L, "Product C", "Description C"));
        log.info("Products loaded.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info("Servlet context destroyed");
    }

}
