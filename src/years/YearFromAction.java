package years;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YearFromAction implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {

		YearsDecider.getInstance().setYear_From_Clicked(true);
		YearsDecider.getInstance().isYearOrderCorrect();
		YearsDecider.getInstance().isYearAvailable();
	}

}
