package luan.abc.demo2.db;

import luan.abc.demo2.models.Product;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAL extends DB {
    public ProductDAL() {
        connect();
    }

    public ArrayList<Product> getList() {
        String sql = "SELECT * FROM products";
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getFloat("price"));
                product.setDescription(rs.getString("description"));
                product.setPath(rs.getString("path"));
                products.add(product);
            }
            return products;
        } catch (Exception e) {

        }

        return null;
    }

    public Product getById(int id) {
        String sql = "SELECT * FROM products WHERE id = " + id;
        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getFloat("price"));
                product.setDescription(rs.getString("description"));
                product.setPath(rs.getString("path"));
                return product;
            }
        } catch (Exception e) {

        }

        return null;
    }
}
