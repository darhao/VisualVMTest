package cc.darhao.vvt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCCaller {

	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/smt_castle?characterEncoding=utf8", "root" , "newttl!@#$1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void exeQuery() {
		String sql = "SELECT * FROM cycle_time_report_item JOIN recipe ON cycle_time_report_item.recipe = recipe.id JOIN machine ON recipe.machine = machine.id";
		try {
			connection.createStatement().executeQuery(sql).close();;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
