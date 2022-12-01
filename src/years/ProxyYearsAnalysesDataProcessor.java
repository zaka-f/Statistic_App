package years;

import java.util.List;

import mainUI.MainUI;

public class ProxyYearsAnalysesDataProcessor implements YearsAnalysesDataExtractor {

	YearsAnalysesDataProcessor checker;
	String analyses;
	List<Integer> bannedYears;

	ProxyYearsAnalysesDataProcessor(String analyses) {
		this.analyses = analyses;
		checker = new YearsAnalysesDataProcessor(analyses);
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

		for (Integer year : bannedYears) {
			if (year >= start && year <= end) {
				flag = false;
			}
		}
		return flag;
	}

}
