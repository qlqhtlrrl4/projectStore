package customDAO;

public class MyInfo {
	
	String name;
	String id;
	String pw;
	int total;
	
	MyInfo() {
		this.id = "";
	}
	
	MyInfo(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		
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
}
