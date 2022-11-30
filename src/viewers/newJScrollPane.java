package viewers;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.JFreeChart;

public class newJScrollPane extends JScrollPane{

	private String type;
	
	public newJScrollPane(JTextArea report) {
		super(report);
		// TODO Auto-generated constructor stub
	}
	
	public newJScrollPane(JTextArea report, String type) {
		super(report);
		this.type = type;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return type;	
	}
}
