package barker.ch.servlets;

import barker.ch.products.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/substractItem")
public class ShoppingCartSubstractItemServlet extends ShoppingCartServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleAction(req);
        super.doGet(req, resp);
    }

    private void handleAction(HttpServletRequest req) {
        long productId = Long.parseLong(req.getParameter("productId"));
        Product product = productService.getProduct(productId);
        productService.getShoppingCart(req).decrementItemQuantity(product);
    }
}
