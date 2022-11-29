package viewers;

import javax.swing.JComponent;

public class ViewerInterface<T extends JComponent> extends JComponent{

	private T panel;
	
	public String getType() {
		return null;
	}
	
	public T getChartPanel() {
		// TODO Auto-generated method stub
		return panel;
	}

}
