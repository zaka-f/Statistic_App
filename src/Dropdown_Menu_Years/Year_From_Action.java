package Dropdown_Menu_Years;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Year_From_Action implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Years_Decider.getInstance().setYear_From_Clicked(true);
		Years_Decider.getInstance().isYearOrderCorrect();
//		Years_Decider.getInstance().isYearAvailable();
	}

}
