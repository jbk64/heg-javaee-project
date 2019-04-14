package barker.ch.core;

import barker.ch.products.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private Logger log = Logger.getLogger(CheckoutServlet.class.getName());

    @Inject
    private ProductService productService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cartSize", productService.getCartSize());
        req.setAttribute("cartProducts", productService.getCartProducts());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/checkout.jsp").forward(req, resp);
    }
}
