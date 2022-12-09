package renderingResults;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainUI.MainUI;
import performing_analyses.FactoryGetData;
import performing_analyses.SuperClassGetData;
import viewers.newChartPanel;

public class ActionButtonRecalculate implements ActionListener {

	private static SuperClassGetData getData;
	
	public static SuperClassGetData getGetData() {
		return getData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FactoryGetData factory = new FactoryGetData();
		getData = factory.getData((String)MainUI.getMethodsList().getSelectedItem());
 		
	}

}
