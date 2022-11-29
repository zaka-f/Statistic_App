package viewers;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

public class Views {

	private static Views instance;
	static JPanel panel;
	private ArrayList<newChartPanel> views;
	
	public ArrayList<newChartPanel> getViews() {
		return views;
	}

	public void setViews(ArrayList<newChartPanel> views) {
		this.views = views;
	}

	// Singeleton Design pattern is being used here
	public static Views getInstance(JPanel panel) {
		if (instance == null)
			instance = new Views(panel);

		return instance;
	}

	// Singeleton Design pattern is being used here
	public static Views getInstance() {
		if (instance == null)
			instance = new Views(null);

		return instance;
	}

	Views(JPanel panel) {
		views = new ArrayList<newChartPanel>();
		Views.panel = panel;
	}

	public void add(newChartPanel newView) {
		views.add(  newView);
		panel.add(newView);
	}

}
