package analyses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainUI.MainUI;

public class DropdownMenuAnalysesAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println(String.valueOf(MainUI.getMethodsList().getSelectedItem()));
	    new Analyses(String.valueOf(MainUI.getMethodsList().getSelectedItem()));
		
	}

}
