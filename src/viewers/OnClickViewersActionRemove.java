package viewers;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import mainUI.MainUI;

public class OnClickViewersActionRemove<T extends JComponent> implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
        String removedView = String.valueOf(MainUI.getViewsList().getSelectedItem());
        
        System.out.print(Views.getInstance().getViews().size()+"\n");
        
        for (int x = Views.getInstance().getViews().size()-1; x>=0; x--) {
        	
        	System.out.print("\n"+removedView+"\n");
        	System.out.print(Views.getInstance().getViews().get(x).toString()+"\n");
        	
        	if((Views.getInstance().getViews().get(x)).toString().equals(removedView)) {
        		System.out.print((Views.getInstance().getViews().get(x)).toString()+"\n");
                Views.getInstance().getViews().remove(Views.getInstance().getViews().get(x));
                System.out.print(Views.getInstance().getViews().size()+"\n");
                break;
    	}
         	
        }
        }
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		
//        String removedView = String.valueOf(MainUI.getViewsList().getSelectedItem());
//        
//        System.out.print(Views.getInstance().getViews().size()+"\n");
//        
//        for (int x = Views.getInstance().getViews().size()-1; x>=0; x--) {
//        	
//        	if((Views.getInstance().getViews().get(x)).getType().equals(removedView)) {
//                Views.getInstance().getViews().remove(Views.getInstance().getViews().get(x));
//                System.out.print(Views.getInstance().getViews().size()+"\n");
//                break;
//    	}
//         	
//        }
//        }

}
