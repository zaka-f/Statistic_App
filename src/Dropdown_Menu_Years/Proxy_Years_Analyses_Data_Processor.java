package Dropdown_Menu_Years;

import java.util.List;

import mainUI.MainUI;

public class Proxy_Years_Analyses_Data_Processor implements Years_Analyses_Data_Extractor {

	Years_Analyses_Data_Processor checker;
	String analyses;
	
	Proxy_Years_Analyses_Data_Processor(String analyses){
		this.analyses = analyses;
		checker = new Years_Analyses_Data_Processor(analyses);
	}
	@Override
	public void ExtractData() {
		checker.ExtractData();
	}

	@Override
	public List<Integer> getFetchable() {
		// TODO Auto-generated method stub
		return  checker.getFetchable();

	}
	
	public boolean yearAvaialable() {
		boolean flag = true;
		int start = (Integer) MainUI.getFromList().getSelectedItem();
		int end = (Integer) MainUI.getToList().getSelectedItem();
		
		List<Integer> bannedYears = getFetchable();
		for(Integer year: bannedYears) {
			if (year >= start && year <= end) {
				flag = false;
//				new Error_Message("the years selected are not valid for the selected type of analysis");
			}
		}
		return flag;
	}

}
