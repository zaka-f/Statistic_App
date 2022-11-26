package Dropdown_Menu_Years;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Years_Decider implements ActionListener{

	private boolean year_To_Clicked;
	private boolean year_From_Clicked;
	
	static Years_Decider instance;
	
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


	@Override
	public void actionPerformed(ActionEvent e) {
	
	}

}
