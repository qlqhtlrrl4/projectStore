package customDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SellDAO {
//	public static ArrayList<Items> cartList;
	public static Map<String, ArrayList<Items>> historyMap = new HashMap<>();

	public static ArrayList<Items> getCartList(String userId) {
		//cartMap.get(userId);
		return historyMap.get(userId);
	}
	
	public SellDAO(String userId) {
		if (historyMap.get(userId) == null) {
			init(userId);
		}
	}
	
	private static void init(String userId) {
		historyMap.put(userId, new ArrayList<>());

	}

	public boolean registCart(String userId,Items item) {

		for (int i = 0; i < historyMap.get(userId).size(); i++) {
			if (historyMap.get(userId).get(i).getItemUrl() == item.getItemUrl()) { 
				System.out.println("중복");
				return false;
			}

			
		}
		return true;
	}
	
	// remove public
	public boolean remove(int id, String userId) {
		for(int i=0;i<historyMap.get(userId).size();i++)  {
			if(historyMap.get(userId).get(i).getId()==id) {
				historyMap.get(userId).remove(i);
				return true;
			}
		}
		return false;
		
	}
	

	public boolean change(int id,int cnt,String userId) {
		for(int i=0;i<historyMap.get(userId).size();i++)  {
			if(historyMap.get(userId).get(i).getId()==id) {
				historyMap.get(userId).get(i).setCnt(cnt);
				return true;
			}
		}
		return false;
	}
	
	public int totalMoney(String userId) {
		int money=0;
		for(int i=0;i<historyMap.get(userId).size();i++) {
			money+=historyMap.get(userId).get(i).getCnt()*historyMap.get(userId).get(i).getPrice();
			
		}
		
		return money;
	}
}

