package viewers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

import mainUI.MainUI;

public class OnClickViewersActionRemove<T extends JComponent> implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		String removedView = String.valueOf(MainUI.getViewsList().getSelectedItem());

		for (int x = Views.getInstance().getViews().size() - 1; x >= 0; x--) {

			System.out.print("\n" + removedView + "\n");

			if ((Views.getInstance().getViews().get(x)).toString().equals(removedView)) {

				MainUI.getCenter().remove((Views.getInstance().getViews().get(x)));
				MainUI.getInstance().repaint();
				Views.getInstance().getViews().remove(Views.getInstance().getViews().get(x));

				break;
			}

		}
	}
}

