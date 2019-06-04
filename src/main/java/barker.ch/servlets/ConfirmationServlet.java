package barker.ch.servlets;

import barker.ch.products.ProductService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {

    @Inject
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService.emptyCart(req);
        req.setAttribute("cartSize", productService.getCartSize(req));
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/confirmation.jsp").forward(req, resp);
    }
}
