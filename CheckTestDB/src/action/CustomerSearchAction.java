package action;

public class CustomerSearchAction {

	public static String[][] execute(String[] input_info){
		String[][] tableData = new String[2][2];
		String[] data = new String[2];
		try {
			tableData[0][0] = tableData[0][0].trim();
			tableData[0][0] = tableData[0][0].replaceAll("　", "");
			if(data[0] != "" && data[0] == "") {
				
			}else if(data[0] == "" && data[1] != "") {
				
			}else if(data[0] != "" && data[1] != "") {
				
			}
		}catch(Exception e) {
			
		}
		return tableData;
	}
}