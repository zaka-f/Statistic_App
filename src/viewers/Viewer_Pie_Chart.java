package viewers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;

public class Viewer_Pie_Chart implements Viewers_Interface {

	private void createPie(JPanel west) {
		// Different way to create pie chart
		/*
		 * var dataset = new DefaultPieDataset(); 
		 * dataset.setValue("Unemployed", 3.837);
		 * dataset.setValue("Employed", 96.163);
		 * 
		 * JFreeChart pieChart = ChartFactory.createPieChart("Women's Unemployment",
		 * dataset, true, true, false);
		 */

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		JFreeChart pieChart = ChartFactory.createMultiplePieChart("Name of analyses", dataset,
				TableOrder.BY_COLUMN, true, true, false);

		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		west.add(chartPanel);
	}
}
