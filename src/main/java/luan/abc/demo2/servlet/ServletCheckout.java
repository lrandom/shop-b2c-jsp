package luan.abc.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import luan.abc.demo2.db.OrderDAL;
import luan.abc.demo2.db.ProductDAL;
import luan.abc.demo2.models.CartItem;
import luan.abc.demo2.models.Order;
import luan.abc.demo2.models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Checkout", urlPatterns = "/checkout")
public class ServletCheckout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("full_name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String note = req.getParameter("note");

        HttpSession httpSession = req.getSession();
        ArrayList<CartItem> list = (ArrayList<CartItem>) httpSession.getAttribute("CART");
        if (list == null) {
            list = new ArrayList<>();
        }

        float subTotal = 0;
        for (CartItem cartItem : list) {
            subTotal += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        float tax = subTotal * 0.1f;
        float total = subTotal + tax;

        Order order = new Order();
        order.setAddress(address);
        order.setFullName(name);
        order.setPhone(phone);
        order.setNote(note);
        order.setTotal(total);
        order.setTax(tax);
        order.setShipFee(0);
        order.setSubTotal(subTotal);
        order.setUserId(0);
        OrderDAL orderDAL = new OrderDAL();
        order = orderDAL.add(order);

        for (CartItem cartItem : list) {
            orderDAL.addOrderDetail(order.getId(), cartItem);
        }


        req.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(req, resp);
    }
}

