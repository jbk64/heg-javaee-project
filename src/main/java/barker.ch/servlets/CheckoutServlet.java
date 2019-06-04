package barker.ch.servlets;

import barker.ch.products.ProductService;

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
        resp.sendRedirect("checkout");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("totalCost", productService.getTotalCost(req));
        req.setAttribute("cartSize", productService.getCartSize(req));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/checkout.jsp").forward(req, resp);
    }
}
