package barker.ch.servlets;

import barker.ch.products.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/catalog")
public class ProductListServlet extends HttpServlet {

    private Logger log = Logger.getLogger(ProductListServlet.class.getName());

    @Inject
    private ProductService productService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.getAllProducts());
        req.setAttribute("cartSize", productService.getCartSize(req));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/product-list.jsp").forward(req, resp);

    }
}
