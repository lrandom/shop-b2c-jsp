package luan.abc.demo2.db;

import luan.abc.demo2.models.CartItem;
import luan.abc.demo2.models.Order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDAL extends DB {
    public OrderDAL() {
        connect();
    }

    public Order add(Order order) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO orders (sub_total, tax,ship_fee,total,address,note,user_id,full_name,phone)" +
                            " VALUES (?,?,?,?,?,?,?,?,?)");
            preparedStatement.setFloat(1, order.getSubTotal());
            preparedStatement.setFloat(2, order.getTax());
            preparedStatement.setFloat(3, order.getShipFee());
            preparedStatement.setFloat(4, order.getTotal());
            preparedStatement.setString(5, order.getAddress());
            preparedStatement.setString(6, order.getNote());
            preparedStatement.setInt(7, order.getUserId());
            preparedStatement.setString(8, order.getFullName());
            preparedStatement.setString(9, order.getPhone());
            preparedStatement.executeUpdate();

            //return id of order
            preparedStatement = this.connection.prepareStatement("SELECT LAST_INSERT_ID()");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }
            return order;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean addOrderDetail(int orderId, CartItem cartItem) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO order_details (order_id, product_id, quantity,price,product_name)" +
                            " VALUES (?, ?,?,?,?)");
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, cartItem.getProduct().getId());
            preparedStatement.setInt(3, cartItem.getQuantity());
            preparedStatement.setFloat(4, cartItem.getProduct().getPrice());
            preparedStatement.setString(5, cartItem.getProduct().getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
