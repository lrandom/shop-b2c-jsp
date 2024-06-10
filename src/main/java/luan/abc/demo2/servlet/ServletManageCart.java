package luan.abc.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import luan.abc.demo2.db.ProductDAL;
import luan.abc.demo2.models.CartItem;
import luan.abc.demo2.models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ManageCart", urlPatterns = "/cart")
public class ServletManageCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        ArrayList<CartItem> list= (ArrayList<CartItem>) httpSession.getAttribute("CART");
        if (list == null) {
            list = new ArrayList<>();
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
    }
}
