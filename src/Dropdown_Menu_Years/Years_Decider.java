package Dropdown_Menu_Years;

import mainUI.Error_Message;
import mainUI.MainUI;

public class Years_Decider{

	private static boolean year_To_Clicked;
	private static boolean year_From_Clicked;
	
	private static Years_Decider instance;
	
	//Singeleton Design pattern is being used here
	public static Years_Decider getInstance() {
		if (instance == null)
			instance = new Years_Decider();

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


	public static boolean isYearOrderCorrect(){
		boolean order = false;
		Integer start = Integer.valueOf(String.valueOf(MainUI.getFromList().getSelectedItem()));
		Integer end = Integer.valueOf(String.valueOf(MainUI.getToList().getSelectedItem()));
		if (year_From_Clicked && year_To_Clicked && (end - start) <= 0) {
			    System.out.print("it s working");
			    new Error_Message("year order wrong");
			}
		else if (year_From_Clicked && year_To_Clicked && (end - start) >= 0) {
			    order = true;
		}
		return order;
	}
	
	

}
