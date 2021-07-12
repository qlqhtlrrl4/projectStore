package customDAO;

public class CustomerInfo {
	
	String name;
	String id;
	String pw;
	String total;
	
	

	CustomerInfo(String name, String id, String pw) {
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
	
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

}
