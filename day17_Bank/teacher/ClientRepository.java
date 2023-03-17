package day17_Bank.teacher;

import java.util.*;

public class ClientRepository {
	private Map<String, ClientDTO> clientMap = new HashMap<>();
	
	public boolean save(ClientDTO clientDTO) {
		ClientDTO result = clientMap.put(clientDTO.getAccount(), clientDTO);
		if(result == null) {
			System.out.println();
			return true;
		}
		return false;
	}
	
	public boolean loginCheck(String id, String pw) {
		for(String key : clientMap.keySet()) {
			if(id.equals(clientMap.get(key).getId()) && pw.equals(clientMap.get(key).getPassword())) {
				clientMap.get(id);
				return true;
			}
		}
		return false;
	}
	
	public Map<String, ClientDTO> findAll(){
		return clientMap;
	}
	
	public boolean update(String loginId, String loginPw, String pw) {
		for(String key : clientMap.keySet()) {
			if(loginId.equals(clientMap.get(key).getId()) && loginPw.equals(clientMap.get(key).getPassword())) {
				clientMap.get(key).setPassword(pw);
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(String loginId, String loginPw) {
		for(String key : clientMap.keySet()) {
			if(loginId.equals(clientMap.get(key).getId()) && loginPw.equals(clientMap.get(key).getPassword())) {
				clientMap.remove(key);
				return true;
			}
		}
		return false;
	}
	
}
