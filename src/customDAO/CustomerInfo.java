package customDAO;

public class CustomerInfo {
	
	String name;
	String id;
	String pw;
	int total;
	String grade;

	CustomerInfo(String name, String id, String pw, int total, String grade) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.total = total;
		this.grade = grade;
		
		//grade -> 할인율 
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getGrade() {
		return grade;
	}

}
