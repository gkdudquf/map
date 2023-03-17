package day17_Bank;

import java.util.*;

public class ClientService {
	Scanner sc = new Scanner(System.in);
	ClientRepository cr = new ClientRepository();
	private static ClientService service = new ClientService();
	public static ClientService getInstance() {
		return service;
	}
	
	public void save() {
		ClientDTO clientDTO = new ClientDTO();
		System.out.println("아이디 입력> ");
		clientDTO.setId(sc.next());
		System.out.println("비밀번호 입력> ");
		clientDTO.setPassword(sc.next());
		System.out.println("이름 입력> ");
		clientDTO.setName(sc.next());
		System.out.println("초기입금액> ");
		clientDTO.setBalance(sc.nextLong());
		boolean result = cr.save(clientDTO);
		if(result) {
			System.out.println("등록이 완료되었습니다");
		}else {
			System.out.println("등록을 실패했습니다");
		}
	}
	
	public boolean loginCheck() {
		System.out.println("아이디 입력> ");
		String id = sc.next();
		System.out.println("비밀번호 입력> ");
		String pw = sc.next();
		boolean result = cr.loginCheck(id, pw);
		if(result) {
			System.out.println("로그인 성공!");
			return true;
		}else {
			System.out.println("로그인 실패!");
			return false;
		}
		
	}
	
	public  void findAll() {
		Map<String, ClientDTO> clientMap = cr.findAll();
		List<String> keySet = new ArrayList<>(clientMap.keySet());
		System.out.println("계좌번호\t\t아이디\t비밀번호\t이름\t초기입금액\t개설일");
		for(String key : clientMap.keySet()) {
			System.out.println(clientMap.get(key));
		}
	}
	
	
	
}
