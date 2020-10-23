package connector;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class JdbcConnector implements Serializable {

	private static final long serialVersionUID = 7278678841707475562L;
	public Connection connect() {
		String url = "jdbc:postgresql://localhost:5433/staff";
		String user = "postgres";
		String pass = "canh12";
		try {
			return DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}