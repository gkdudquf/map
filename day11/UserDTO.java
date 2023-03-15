package day11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDTO {
	private final static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yy/MM/dd hh:mm:ss");
	private static String domain = "naver.com";
	
	private String email;
	private String password;
	private String name;
	private int age;
	private String joinDate;
	
	public UserDTO() {
		this.joinDate = DTF.format(LocalDateTime.now());
	}
	public UserDTO(String email, String password, String name, int age) {
		this();
		this.email = email +"@"+ domain;
		this.password = password;
		this.name = name;
		this.age = age;
	}
	
	public static String getDomain() {
		return domain;
	}
	public static void setDomain(String domain) {
		UserDTO.domain = domain;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJoinDate() {
		return joinDate;
	}
	
	@Override
	public String toString() {
		return email+"\t"+password+"\t"+name+"\t"+age+"\t"+joinDate;
	}
	
	
	
	
	
}
