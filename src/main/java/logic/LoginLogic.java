package logic;

import dao.UserDao;
import dto.UserDto;

public class LoginLogic {
	public UserDto execute(String id,String pass){
		UserDao userdao = new UserDao();
		UserDto result = userdao.getUser(id, pass);
		return result;
	}
}
