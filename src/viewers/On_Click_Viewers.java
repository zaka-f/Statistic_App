package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class On_Click_Viewers implements ActionListener {

	private ArrayList<Integer> viwersList = new ArrayList<Integer>();
	
	public ArrayList<Integer> getViwersList() {
		return viwersList;
	}

	public void setViwersList(ArrayList<Integer> viwersList) {
		this.viwersList = viwersList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("viewers selected\n\n");
		
	} 

}
