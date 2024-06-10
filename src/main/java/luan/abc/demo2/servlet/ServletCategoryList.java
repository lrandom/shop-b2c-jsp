package luan.abc.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import luan.abc.demo2.db.CategoryDAL;
import luan.abc.demo2.models.Category;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="ListCategory",urlPatterns = "/list-category")
public class ServletCategoryList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CategoryDAL categoryDAL = new CategoryDAL();
        ArrayList<Category> categories = categoryDAL.getList();
        for (Category category : categories) {
            System.out.println(category.getName());
        }
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/WEB-INF/category/list.jsp").forward(req,resp);
    }
}
