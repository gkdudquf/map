package day11;

import java.util.List;
import java.util.Scanner;

public class UserService {
	UserRepository repository = new UserRepository();
	Scanner sc = new Scanner(System.in);
	
	String loginEmail = null;
	String loginPassword = null;
	
	public void save() {
		System.out.print("이메일> ");
		String email = sc.next();
		System.out.print("비밀번호> ");
		String password = sc.next();
		System.out.print("이름> ");
		String name = sc.next();
		System.out.print("나이> ");
		int age = sc.nextInt();
		UserDTO userDTO = new UserDTO(email,password,name,age);
		if(repository.save(userDTO)) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
	}
	
	public boolean loginCheck() {
		System.out.print("이메일> ");
		String email = sc.next();
		System.out.print("비밀번호> ");
		String password = sc.next();
		
		if(repository.loginCheck(email, password)) {
			System.out.println("로그인 성공!");
			loginEmail = email;
			loginPassword = password;
			return true;
		}else {
			System.out.println("로그인 실패");
			return false;
		}
	}
	
	public void findAll() {
		List<UserDTO> list = repository.findAll();
		System.out.println("이메일\t\t비밀번호\t이름\t나이\t가입일");
		System.out.println("------------------------------------");
		for(UserDTO u : list) {
			System.out.println(u.toString());
		}
	}

	public void findById() {
		UserDTO userDTO = repository.findById(loginEmail, loginPassword);
		if(userDTO == null) {
			System.out.println("로그인 오류");
		}else {
			System.out.println(userDTO);
		}
	}
}




