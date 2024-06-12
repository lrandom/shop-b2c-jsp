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
        ArrayList<CartItem> list = (ArrayList<CartItem>) httpSession.getAttribute("CART");
        if (list == null) {
            list = new ArrayList<>();
        }


        //nếu có 1 hành động gì đó của người dùng
        if (req.getParameter("command") != null) {
            String command = req.getParameter("command");
            if (command.equals("remove")) {
                //xoá
                int id = Integer.parseInt(req.getParameter("productId"));
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getProduct().getId() == id) {
                        list.remove(i);
                        break;
                    }
                }
                httpSession.setAttribute("CART", list);
            }

            if (command.equals("update-quantity")) {
                //cập nhật số lượng
                int id = Integer.parseInt(req.getParameter("productId"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getProduct().getId() == id) {
                        list.get(i).setQuantity(quantity + list.get(i).getQuantity());
                        if (list.get(i).getQuantity() <= 0) {
                            list.remove(i);
                        }
                        break;
                    }
                }
                httpSession.setAttribute("CART", list);
            }
        }

        float subTotal = 0;
        for (CartItem cartItem : list) {
            subTotal += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        float tax = subTotal * 0.1f;
        float total = subTotal + tax;

        req.setAttribute("subTotal", subTotal);
        req.setAttribute("tax", tax);
        req.setAttribute("total", total);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
    }
}
