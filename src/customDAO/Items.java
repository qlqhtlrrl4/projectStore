package customDAO;

public class Items {
	
	String name; //상품이름
	int price; //가격
	int cnt; // 수량
	
	
	public Items(String name, int price) {
		
		this.name = name;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

}
