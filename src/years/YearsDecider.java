package years;

import error_message.ErrorMessage;
import mainUI.MainUI;

public class YearsDecider {

	private static boolean year_To_Clicked;
	private static boolean year_From_Clicked;

	private static YearsDecider instance;

	// Singeleton Design pattern is being used here
	public static YearsDecider getInstance() {
		if (instance == null)
			instance = new YearsDecider();

		return instance;
	}

	public boolean isYear_To_Clicked() {
		return year_To_Clicked;
	}

	public void setYear_To_Clicked(boolean year_To_Clicked) {
		this.year_To_Clicked = year_To_Clicked;
	}

	public boolean isYear_From_Clicked() {
		return year_From_Clicked;
	}

	public void setYear_From_Clicked(boolean year_From_Clicked) {
		this.year_From_Clicked = year_From_Clicked;
	}

	public boolean isYearOrderCorrect() {
		boolean correct = false;
		Integer start = Integer.valueOf(String.valueOf(MainUI.getFromList().getSelectedItem()));
		Integer end = Integer.valueOf(String.valueOf(MainUI.getToList().getSelectedItem()));
		if (year_From_Clicked && year_To_Clicked && (end - start) <= 0) {
			new ErrorMessage("year order wrong");
		} else if (year_From_Clicked && year_To_Clicked && (end - start) >= 0) {
			correct = true;
		}
		return correct;
	}

	public boolean isYearAvailable() {
		boolean correct = true;
		String country = String.valueOf(MainUI.getMethodsList().getSelectedItem());
		ProxyYearsAnalysesDataProcessor checker = new ProxyYearsAnalysesDataProcessor(country);
		if (!checker.yearAvailable()) {
			correct = false;
			System.out.println("Year for analyses is not available\n");
			new ErrorMessage("the years selected are not valid for the selected type of analysis");
		} 
		return correct;
	}

}
