package performing_analyses;

import mainUI.MainUI;

public class FactoryGetData {

	String country = (String)MainUI.getCountriesList().getSelectedItem();
	
	public SuperClassGetData getData(String analysis) {
		if (analysis == null || analysis.isEmpty())
			return null;
		switch (analysis) {
		case "Average Forest Area %":
			return new AverageForestArea(country);
		case "Current Health Expenditure %":
			return new CurrentHealthExpenditurePercentage(country);
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
