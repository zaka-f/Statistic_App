package renderingResults;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainUI.MainUI;
import performing_analyses.FactoryGetData;
import viewers.newChartPanel;

public class RenderingResultAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		FactoryGetData factory = new FactoryGetData();
		factory.getData((String)MainUI.getMethodsList().getSelectedItem());
 		
	}

}
