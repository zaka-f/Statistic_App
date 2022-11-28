package viewers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import mainUI.MainUI;

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
		Viewers_Factory factory = new Viewers_Factory();
		System.out.print("viewers selected\n");
		Viewers_Interface pie =  factory.createViewer("PieChart");
		System.out.print("viewers added\n");
	} 

}
