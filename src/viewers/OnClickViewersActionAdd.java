package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import error_message.ErrorMessage;
import mainUI.MainUI;

public class OnClickViewersActionAdd implements ActionListener {

	private static Views views;


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ViewersFactory factory = new ViewersFactory();
		String newView = String.valueOf(MainUI.getViewsList().getSelectedItem());
		String newMethod = String.valueOf(MainUI.getMethodsList().getSelectedItem());
		CompatibilityCheckerProxy checker = new CompatibilityCheckerProxy(newMethod, newView);
		boolean access = checker.isInvalid();
		if(access) {
			new ErrorMessage("This graph type is not compatible");
		}
		else {
		ViewerSuperClass pie = factory.createViewer(newView);
		Views.getInstance(MainUI.getCenter());
		Views.getInstance().add((JComponent) pie.getChartPanel());
	
		MainUI.getInstance().revalidate();
		}

	}

}
