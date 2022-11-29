package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartPanel;

import mainUI.MainUI;

public class OnClickViewersAction implements ActionListener {

	Views views;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ViewersFactory factory = new ViewersFactory();
		String newView = String.valueOf(MainUI.getViewsList().getSelectedItem());
		System.out.print(newView + "\n");
		ViewerInterface pie = factory.createViewer(newView);
		Views.getInstance(MainUI.getCenter());
		Views.getInstance().add(pie.getChartPanel());
		System.out.print("chartpanel added \n");
		MainUI.getInstance().revalidate();

	}

}
