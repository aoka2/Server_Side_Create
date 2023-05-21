package action;

import java.util.ArrayList;
import java.util.List;

import dao.CustomerSearchDBAccess;
import model.Customer;
public class CustomerSearchAction {

	public static String[][] execute(String[] data)throws Exception{
		//data[0] = 電話番号
		//data[1] = カナ
		List<Customer> datalist = new ArrayList<>();
		
		
		if(data[0] != "" && data[1] != "") {	
			datalist = CustomerSearchDBAccess.searchCustomer(data[1],data[0]);
		}else if(data[0] != "" && data[0] == "") {
			datalist = CustomerSearchDBAccess.searchCustomerByTel(data[0]);
		}else if(data[0] == "" && data[1] != "") {
			datalist = CustomerSearchDBAccess.searchCustomerByKana(data[1]);
		}
		
		//電話番号とカナをArrayListに入っているCustomerから取得
		//取得したものをStringの2次元配列に格納
		String[][] tableData = new String[datalist.size()][datalist.size()];
		for(int i = 0; i < datalist.size(); i++) {
			for(int j = 0; j < 2; j++) {
				tableData[i][0] = datalist.get(i).getTel();
				tableData[i][1] = datalist.get(i).getKana();
			}
			
		}
		
		
		//全角と半角のスペースを消去
		for(int i = 0; i < tableData.length; i++) {
			for(int j = 0; j < 2; j++) {
				tableData[i][j] = tableData[i][j].trim();
				tableData[i][j] = tableData[i][j].replaceAll("　", "");
			}
		}
		return tableData;
	}
}
