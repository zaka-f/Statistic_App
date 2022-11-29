package viewers;

import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

public class Views <T extends JComponent>{

	private static Views instance;
	static JPanel panel;
	private ArrayList<T> views;

	public ArrayList<T> getViews() {
		return views;
	}

	public void setViews(ArrayList<T> views) {
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
		views = new ArrayList<T>();
		Views.panel = panel;
	}

	public void add(T newView) {
		views.add( newView);
		panel.add(newView);
	}

}
