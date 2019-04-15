package barker.ch.servlets;

import barker.ch.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/removeItem")
public class ShoppingCartRemoveItemServlet extends ShoppingCartServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleAction(req);
        super.doPost(req, resp);
    }

    private void handleAction(HttpServletRequest req) {
        long productId = Long.parseLong(req.getParameter("productId"));
        Product product = productService.getProduct(productId);
        productService.getShoppingCart(req).decrementItemQuantity(product);
    }
}
