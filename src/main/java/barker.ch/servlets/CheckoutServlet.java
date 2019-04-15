package barker.ch.servlets;

import barker.ch.services.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Inject
    ProductService productService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService.emptyCart(req);
        resp.sendRedirect("cart");
    }
}
