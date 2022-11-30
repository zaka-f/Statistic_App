package years;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YearToAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {

		YearsDecider.getInstance().setYear_To_Clicked(true);
		YearsDecider.getInstance().isYearOrderCorrect();
		YearsDecider.getInstance().isYearAvailable();
	}

}
