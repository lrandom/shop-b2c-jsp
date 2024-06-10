package luan.abc.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.abc.demo2.db.ProductDAL;
import luan.abc.demo2.models.Product;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Home", urlPatterns = "/")
public class ServletHome extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        ProductDAL productDAL = new ProductDAL();
        ArrayList<Product> list = productDAL.getList();
//        list.forEach(product -> System.out.println(product.getName()));
        req.setAttribute("list", list);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

}
