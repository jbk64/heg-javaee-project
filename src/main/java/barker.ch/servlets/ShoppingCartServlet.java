package barker.ch.servlets;

import barker.ch.models.Product;
import barker.ch.services.ProductService;
import barker.ch.models.ShoppingCart;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet {

    @Inject
    ProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("cart");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("cartSize", productService.getCartSize(req));
        ShoppingCart shoppingCart = productService.getShoppingCart(req);
        Map<Product, Integer> shoppingCartContent = shoppingCart.getContent();
        req.setAttribute("shoppingCartContent", shoppingCartContent);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/cart.jsp").forward(req, resp);
    }
}
