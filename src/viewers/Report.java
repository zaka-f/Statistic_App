package viewers;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Report extends ViewerSuperClass{

	private String type;
	
	private DefaultPieDataset dataset;

	private JFreeChart report;

	private JComponent chartPanel;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public JComponent getChartPanel() {
		return chartPanel;
	}

	public void setChartPanel(JComponent chartPanel) {
		this.chartPanel = chartPanel;
	}

	public DefaultPieDataset getDataset() {
		return dataset;
	}

	public void setDataset(DefaultPieDataset dataset) {
		this.dataset = dataset;
	}

	public JFreeChart getPieChart() {
		return report;
	}

	public void setPieChart(JFreeChart report) {
		this.report = report;
	}

	public Report(String type) {
		
		this.type=type;

		JTextArea report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(400, 300));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
		String reportMessage, reportMessage2;

		reportMessage = "Mortality vs Expenses & Hospital Beds\n" + "==============================\n" + "Year 2018:\n"
				+ "\tMortality/1000 births => 5.6\n" + "\tHealth Expenditure per Capita => 10624\n"
				+ "\tHospital Beds/1000 people => 2.92\n" + "\n" + "Year 2017:\n" + "\tMortality/1000 births => 5.7\n"
				+ "\tHealth Expenditure per Capita => 10209\n" + "\tHospital Beds/1000 people => 2.87\n" + "\n"
				+ "Year 2016:\n" + "\tMortality/1000 births => 5.8\n" + "\tHealth Expenditure per Capita => 9877\n"
				+ "\tHospital Beds/1000 people => 2.77\n";

		reportMessage2 = "Unemployment: Mev vs Women\n" + "==========================\n" + "Men=>\n"
				+ "\tEmployed: 96.054%\n" + "\tUnemployed: 3.946%\n" + "\n" + "Women=>\n" + "\tEmployed: 96.163%\n"
				+ "\tUnemployed: 3.837%\n";

		report.setText(reportMessage);
		chartPanel = new newJScrollPane(report,"Report");

//		MainUI.getCenter().add(chartPanel);
//		MainUI.getInstance().revalidate();
	}
}
