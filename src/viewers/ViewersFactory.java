package viewers;

public class ViewersFactory {

	public ViewerInterface createViewer(String view) {
		if (view == null || view.isEmpty())
			return null;
		switch (view) {
		case "Pie Chart":
			return new PieChart();
		case "Line Chart":
			return new LineChart();
		case "Report":
			return new Report();
		default:
			throw new IllegalArgumentException("Unknown view " + view);
		}

	}
}
