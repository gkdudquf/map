package day18_BANK_teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class ClientRepository {
	private static ClientRepository repository = new ClientRepository();
	private ClientRepository() {}
	
	public static ClientRepository getInstance() {
		return repository;
	}
	
	Map<String, ClientDTO> clientMap = new HashMap<String, ClientDTO>();
	List<BreakdownDTO> bList = new ArrayList<>();
	
	public boolean save(ClientDTO clientDTO) { 
		if(clientMap.put(clientDTO.getAccount(), clientDTO) == null)
			return true; //실행하는 코드가 한줄일 때 중괄호 생략가능
		else
			return false;
	}

	public boolean loginCheck(String id, String password) {
		for(String key : clientMap.keySet()) {
			if(id.equals(clientMap.get(key).getId()) && password.equals(clientMap.get(key).getPassword())) {
				return true;
			}
		}
		return false;
	}
}














