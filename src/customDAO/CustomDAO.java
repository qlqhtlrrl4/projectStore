package customDAO;

import java.util.*;

import customDAO.CustomerInfo;

public class CustomDAO {

	private static ArrayList<CustomerInfo> customList;

	public static ArrayList<CustomerInfo> getCustomList() {
		return customList;
	}

	public static void setCustomList(ArrayList<CustomerInfo> customList) {
		CustomDAO.customList = customList;
	}

	public CustomDAO() {

		if (customList == null) {
			init();
		}
	}

	private void init() { // 초기 정보

		customList = new ArrayList<>();

		customList.add(new CustomerInfo("1", "1", "1"));
		customList.add(new CustomerInfo("2", "2", "2"));
		customList.add(new CustomerInfo("3", "3", "3"));
		customList.add(new CustomerInfo("4", "4", "4"));

	}

	// login 확인 -> id, pw 맞으면 true | 틀리면 false
	public MyInfo loginCheck(String id, String pw) {
		
		
		for (int i = 0; i < customList.size(); i++) {

			if (customList.get(i).getId().equals(id) && customList.get(i).getPw().equals(pw)) {
				
				return new MyInfo(customList.get(i).getName(),id,pw);
			}
			

		}
		return new MyInfo();

	}

	public boolean checkId(String id) {

		for (int i = 0; i < customList.size(); i++) {
			if (customList.get(i).getId().equals(id)) {

				return false;
			}
		}

		return true;

	}

	public void registCustomer(String name, String id, String pw) {

		customList.add(new CustomerInfo(name, id, pw));

	}

}
