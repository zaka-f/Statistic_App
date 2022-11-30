package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import org.jfree.chart.ChartPanel;

import mainUI.MainUI;

public class OnClickViewersActionAdd implements ActionListener {

	Views views;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ViewersFactory factory = new ViewersFactory();
		String newView = String.valueOf(MainUI.getViewsList().getSelectedItem());
		System.out.print(newView + "\n");
		ViewerSuperClass pie = factory.createViewer(newView);
		Views.getInstance(MainUI.getCenter());
		Views.getInstance().add((JComponent) pie.getChartPanel());
		System.out.print("chartpanel added \n");
		MainUI.getInstance().revalidate();

	}

}
