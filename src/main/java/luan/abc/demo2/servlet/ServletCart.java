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

@WebServlet(name = "Cart", urlPatterns = "/add-to-cart")
public class ServletCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        HttpSession httpSession = req.getSession();
        ArrayList<CartItem> cartItems = (ArrayList<CartItem>) httpSession.getAttribute("CART");
        if (cartItems==null) {
            cartItems = new ArrayList<>();
        }

        boolean check = false;
        //check xem có trong giỏ hàng hay ko
        for (CartItem item : cartItems) {
            if (item.getProduct().getId() == Integer.parseInt(id)) {
                //có rồi thì tăng số lượng
                item.setQuantity(item.getQuantity() + 1);
                check = true;
                break;
            }
        }

        if (check==false) {
            ProductDAL productDAL = new ProductDAL();
            Product product = productDAL.getById(Integer.parseInt(id));
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            //lưu vào session
            cartItems.add(cartItem);
        }

        httpSession.setAttribute("CART", cartItems);
        //redirect to index
        resp.sendRedirect(req.getContextPath());
    }
}
