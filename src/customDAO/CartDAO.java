package customDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CartDAO {

//	public static ArrayList<Items> cartList;
	public static Map<String, ArrayList<Items>> cartMap = new HashMap<>();

	public static ArrayList<Items> getCartList(String userId) {
		//cartMap.get(userId);
		return cartMap.get(userId);
	}
	
	public CartDAO(String userId) {
		if (cartMap.get(userId) == null) {
			init(userId);
		}
	}
	
	private static void init(String userId) {
		cartMap.put(userId, new ArrayList<>());

	}

	public boolean registCart(String userId,Items item) {

		for (int i = 0; i < cartMap.get(userId).size(); i++) {
			if (cartMap.get(userId).get(i).getItemUrl() == item.getItemUrl()) { 
				System.out.println("중복");
				return false;
			}

			
		}
		return true;
	}
	
	// remove public
	public boolean remove(int id, String userId) {
		for(int i=0;i<cartMap.get(userId).size();i++)  {
			if(cartMap.get(userId).get(i).getId()==id) {
				cartMap.get(userId).remove(i);
				return true;
			}
		}
		return false;	
	}
	
	/*public int partPay(int id) {
		
		int partMoney =0;
		
		for(int i=0;i<cartMap.get(id).size();i++)  {
			if(cartMap.get(id).get(i).getId()==id) {
				partMoney+=cartMap.get(id).get(i).getPrice()*cartMap.get(id).get(i).getCnt();
				
			}
		}
		return partMoney;	
		
	}*/
	

	public boolean change(int id,int cnt,String userId,String size) {
		for(int i=0;i<cartMap.get(userId).size();i++)  {
			if(cartMap.get(userId).get(i).getId()==id) {
				cartMap.get(userId).get(i).setCnt(cnt);
				cartMap.get(userId).get(i).setSize(size);
				return true;
			}
		}
		return false;
	}
	
	public int totalMoney(String userId) {
		int money=0;
		for(int i=0;i<cartMap.get(userId).size();i++) {
			money+=cartMap.get(userId).get(i).getCnt()*cartMap.get(userId).get(i).getPrice();
			
		}
		
		return money;
	}
}