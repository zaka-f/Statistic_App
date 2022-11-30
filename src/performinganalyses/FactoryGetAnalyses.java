package performinganalyses;

import viewers.BarChart;
import viewers.LineChart;
import viewers.PieChart;
import viewers.Report;
import viewers.ScatterChart;
import viewers.TimeSeriesChart;
import viewers.ViewerSuperClass;

public class FactoryGetAnalyses {

	public SuperClassGetData FactoryGetAnalyses(String analysis) {
		if (analysis == null || analysis.isEmpty())
			return null;
		switch (analysis) {
		case "Pie Chart":
			return new AverageForestArea(analysis);
		case "Line Chart":
//			return new LineChart();
//		case "Report":
//			return new Report();
//		case "Bar Chart":
//			return new BarChart();
//		case "Time Series":
//			return new TimeSeriesChart();
//		case "Scatter Chart":
//			return new ScatterChart();
		default:
			throw new IllegalArgumentException("Unknown analysis " + analysis);
		}

	}
	
}
