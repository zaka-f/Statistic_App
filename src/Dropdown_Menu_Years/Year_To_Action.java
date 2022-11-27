package Dropdown_Menu_Years;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Year_To_Action implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Years_Decider decider  = new Years_Decider();
		decider.setYear_To_Clicked(true);
		decider.isYearOrderCorrect();
//		decider.isYearAvailable();
	}

}
