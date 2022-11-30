package viewers;

public class ViewersFactory {

	public ViewerSuperClass createViewer(String view) {
		if (view == null || view.isEmpty())
			return null;
		switch (view) {
		case "Pie Chart":
			return new PieChart(view);
		case "Line Chart":
			return new LineChart(view);
		case "Report":
			return new Report(view);
		case "Bar Chart":
			return new BarChart(view);
		case "Time Series":
			return new TimeSeriesChart(view);
		case "Scatter Chart":
			return new ScatterChart(view);
		default:
			throw new IllegalArgumentException("Unknown view " + view);
		}

	}
}
