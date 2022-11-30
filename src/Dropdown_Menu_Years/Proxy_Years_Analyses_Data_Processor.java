package Dropdown_Menu_Years;

import java.util.List;

import error_message.Error_Message;
import mainUI.MainUI;

public class Proxy_Years_Analyses_Data_Processor implements Years_Analyses_Data_Extractor {

	Years_Analyses_Data_Processor checker;
	String analyses;
	List<Integer> bannedYears;

	Proxy_Years_Analyses_Data_Processor(String analyses) {
		this.analyses = analyses;
		checker = new Years_Analyses_Data_Processor(analyses);
		checker.ExtractData();
		bannedYears = checker.getFetchable();
	}

	@Override
	public void ExtractData() {
		checker.ExtractData();
	}

	@Override
	public List<Integer> getFetchable() {
		// TODO Auto-generated method stub
		return checker.getFetchable();

	}

	public boolean yearAvailable() {
		boolean flag = true;
		int start = Integer.parseInt((String) MainUI.getFromList().getSelectedItem());
		int end = Integer.parseInt((String) MainUI.getToList().getSelectedItem());

		System.out.println(start+" to "+ end + "\n");
		System.out.println(bannedYears + "\n");
		for (Integer year : bannedYears) {
			if (year >= start && year <= end) {
				flag = false;
			}
		}
		return flag;
	}

}
