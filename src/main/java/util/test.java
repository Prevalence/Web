package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bl.UserService;

public class test {
	public static void main(String[] args) {
		// UserService.getImplement().register("谢凯航", "123");
		Connection con;
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		// String url = "jdbc:mysql://localhost:3306/user";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "199898";
		String url = "jdbc:mysql://localhost:3306/user?"
				+ "user=root&password=199898&useUnicode=true&characterEncoding=UTF8";
		// 加载驱动程序
		try {
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url);
			if (!con.isClosed())
				System.out.println("Succeeded connecting to the Database!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
