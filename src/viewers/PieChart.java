package viewers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart <T extends JComponent> extends ViewerInterface {

	private String type;
	
	private DefaultPieDataset dataset;

	private JFreeChart pieChart;

	private T chartPanel;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public T getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(T chartPanel) {
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

	public PieChart(String type) {

		this.type=type;
		
		dataset = new DefaultPieDataset();
		dataset.setValue("", 100);
//		dataset.setValue("Employed", 96.163);

		pieChart = ChartFactory.createPieChart("Women's Unemployment", dataset, true, true, false);

		chartPanel = (T) new ChartPanel(pieChart);

		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		chartPanel.setVisible(true);

//		MainUI.getCenter().add(chartPanel);
//		MainUI.getInstance().revalidate();
	}

}
