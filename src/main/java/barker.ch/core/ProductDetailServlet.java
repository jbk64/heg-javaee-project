package barker.ch.core;

import barker.ch.products.Product;
import barker.ch.products.ProductNotFoundException;
import barker.ch.products.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

@WebServlet("/product")
public class ProductDetailServlet extends HttpServlet {

    private Logger log = Logger.getLogger(ProductDetailServlet.class.getName());

    @Inject
    private ProductService productService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        req.setAttribute("product", productService.getProduct(id));
        req.setAttribute("cartSize", productService.getCartSize());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/product-detail.jsp").forward(req, resp);

    }
}
