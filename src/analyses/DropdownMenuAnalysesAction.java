package analyses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainUI.MainUI;

public class DropdownMenuAnalysesAction implements ActionListener {
	@Override

	// Action performed when an analis is selected.
	public void actionPerformed(ActionEvent e) {

		new Analyses(String.valueOf(MainUI.getMethodsList().getSelectedItem()));

	}

}
