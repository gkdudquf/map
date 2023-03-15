package day11;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	private List<UserDTO> list = new ArrayList<>();
	
	public boolean save(UserDTO userDTO) {
		return list.add(userDTO);
	}
	
	public boolean loginCheck(String email, String password) {
		for(UserDTO u : list) {
			if(email.equals(u.getEmail()) && password.equals(u.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public List<UserDTO> findAll() {
		return list;
	}
	public UserDTO findById(String email, String password) {
		for(UserDTO u : list) {
			if(u.getEmail().equals(email) && u.getPassword().equals(password)) {
				return u;
			}
		}
		return  null;
	}
}





