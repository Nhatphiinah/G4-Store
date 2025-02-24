package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBcontext {
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=ShopDB_SWP;encrypt=true;trustServerCertificate=true";
    private final String user = "sa";
    private final String password = "123456";

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Kết nối thành công đến database!");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("❌ Không thể kết nối database!");
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        DBcontext db = new DBcontext();
        db.getConnection(); // Chạy thử kết nối
    }
}
