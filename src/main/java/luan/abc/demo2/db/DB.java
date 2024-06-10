package luan.abc.demo2.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    protected Connection connection;

    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java35",
                    "root",
                    "koodinh@");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
