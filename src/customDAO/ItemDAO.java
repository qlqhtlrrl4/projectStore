package customDAO;

import java.util.*;


public class ItemDAO {
	
	// 상품정보
	public static ArrayList<Items> itemList;
	
	public ItemDAO() {
		
		if (itemList == null) { 
			init(); 
		}
		
		
	}

	private void init() {
		
		itemList = new ArrayList<Items>(); //상품 arraylist만들기
		
		itemList.add(new Items("a",1000));
		itemList.add(new Items("b",2000));
		itemList.add(new Items("c",3000));
		itemList.add(new Items("d",4000));
		
	}
	
	public Items searchItem(String name) {
		
		for(int i=0;i<itemList.size();i++) {
			
			if(itemList.get(i).getName().equals(name)) {
				return itemList.get(i);
			}
		}	
		return null;		
	}

}
