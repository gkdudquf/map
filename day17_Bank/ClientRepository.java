package day17_Bank;

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
	
}
