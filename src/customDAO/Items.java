package customDAO;

public class Items {
	
	int id;
	String name; //상품이름
	int price; //가격
	int cnt = 0; // 수량
	String itemUrl;
	String itemInfo;
	String kind;
	String size;
	
	
	//상품 등록
/*	public Items(int id, String name, int price, String itemUrl) {
	
		this.id = id;
		this.name = name;
		this.price = price;
		this.itemUrl = itemUrl;
		//this.cnt = cnt;
		
	}*/
	//건화 태큐
	public Items(int id, String name, int price, String itemUrl,String itemInfo, String kind) {
		
		this.id = id;
		this.name = name;
		this.price = price;
		this.itemUrl = itemUrl;
		this.itemInfo = itemInfo;
		this.kind = kind;
		//this.cnt = cnt;
		
	}
	
	// 장바구니에 사용할 상품
	public Items(int  id, String name, int price, String itemUrl,int cnt,String itemInfo,String kind, String size) {
	
		this.id = id;
		this.name = name;
		this.price = price;
		this.itemUrl = itemUrl;
		this.cnt = cnt;
		this.size=size;
		this.kind=kind;
		this.itemInfo = itemInfo;
	}

	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}


	public String getItemUrl() {
		return itemUrl;
	}


	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
}
