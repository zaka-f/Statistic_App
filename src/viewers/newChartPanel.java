package viewers;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class newChartPanel extends ChartPanel{

	private String type;
	
	public newChartPanel(JFreeChart chart) {
		super(chart);
		// TODO Auto-generated constructor stub
	}
	
	public newChartPanel(JFreeChart chart, String type) {
		super(chart);
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return type;	
	}

}
