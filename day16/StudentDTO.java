package day16;

public class StudentDTO {

	private long id;       // 관리번호
	private String studentNumber; // 학번
	private String studentName; // 이름
	private String studentMajor; // 전공
	private String studentMobile; // 전화번호
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentMajor() {
		return studentMajor;
	}
	public void setStudentMajor(String studentMajor) {
		this.studentMajor = studentMajor;
	}
	public String getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", studentNumber=" + studentNumber + ", studentName=" + studentName
				+ ", studentMajor=" + studentMajor + ", studentMobile=" + studentMobile + "]";
	}
	

	

}
