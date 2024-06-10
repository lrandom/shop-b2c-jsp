package luan.abc.demo2.db;


import luan.abc.demo2.models.Category;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDAL extends DB {
    public CategoryDAL() {
        connect();
    }

    public ArrayList<Category> getList() {
        String sql = "SELECT * FROM categories";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Category> categories = new ArrayList<>();
            while (rs.next()) {
                Category category = new Category();
                category.setName(rs.getString("name"));
                category.setId(rs.getInt("id"));
                categories.add(category);
            }
            return categories;
        } catch (Exception e) {

        }

        return null;
    }
}
