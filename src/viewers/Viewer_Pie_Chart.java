package viewers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import mainUI.MainUI;

public class Viewer_Pie_Chart extends Viewers_Interface {

	private DefaultPieDataset dataset;

	private JFreeChart pieChart;
	
	private ChartPanel chartPanel;

	public ChartPanel getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(ChartPanel chartPanel) {
		this.chartPanel = chartPanel;
	}

	public DefaultPieDataset getDataset() {
		return dataset;
	}

	public void setDataset(DefaultPieDataset dataset) {
		this.dataset = dataset;
	}

	public JFreeChart getPieChart() {
		return pieChart;
	}

	public void setPieChart(JFreeChart pieChart) {
		this.pieChart = pieChart;
	}

	public Viewer_Pie_Chart() {

		dataset = new DefaultPieDataset();
		dataset.setValue("", 100);
//		dataset.setValue("Employed", 96.163);

		pieChart = ChartFactory.createPieChart("Women's Unemployment",
				  dataset, true, true, false);
	
		chartPanel = new ChartPanel(pieChart);
		
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    	chartPanel.setBackground(Color.white);
		chartPanel.setVisible(true);
		
//		PiePlot piePlot = (PiePlot) pieChart.getPlot();
//		piePlot.setForegroundAlpha(1);
//		ChartFrame frame = new ChartFrame("Pie Chart", pieChart);
//		frame.setVisible(true);
//		frame.setSize(400,300);
		MainUI.getWest().add(chartPanel);
		MainUI.getInstance().revalidate();
		
		
	}

}
