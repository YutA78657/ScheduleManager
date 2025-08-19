package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDto;

public class UserDao extends Dao{
	public UserDto getUser(String id,String pass){
		UserDto result = null;
		String sql = "select name,role from user where user_id = ? and passward = ?";
		load();
		try(Connection con = DriverManager.getConnection(url, user, passward);
				PreparedStatement st=con.prepareStatement(sql)){
			st.setString(1, id);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String role = rs.getString("role");
				result = new UserDto(id,name,role);
			}
		}catch(SQLException e) {
			System.out.println("getUser");
		}
		return result;
	}
}
