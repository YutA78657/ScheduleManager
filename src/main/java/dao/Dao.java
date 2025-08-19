package dao;

public class Dao {
	protected String url ="jdbc:mysql://localhost:3306/shiftmanager";
	protected String user ="root";
	protected String passward ="";
	public void load() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
