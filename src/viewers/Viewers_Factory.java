package viewers;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;

public class Viewers_Factory {

	public Viewers_Interface createViewer(String view) {
		if (view == null || view.isEmpty())
			return null;
		switch (view) {
		case "PieChart":
			return new Viewer_Pie_Chart();
		default:
			throw new IllegalArgumentException("Unknown view " + view);
		}

	}
}
