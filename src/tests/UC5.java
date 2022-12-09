package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mainUI.MainUI;
import mainUI.MainUILuncher;
import viewers.Views;

public class UC5 {
	MainUILuncher mainUILauncher = new MainUILuncher();

	@SuppressWarnings("static-access")
	@Test
	public void UC5test1ValidInput() {

		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance().getViewsList().setSelectedIndex(x);
				MainUI.getInstance().getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance().getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance().getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance().getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance().getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance().getViewsList().setSelectedIndex(1);// Line Chart

		correct = correct && MainUI.getInstance().getViewsList().getSelectedItem().toString().equals("Line Chart");

		MainUI.getInstance().getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 1);
		assertTrue(correct);
	}

	@SuppressWarnings("static-access")
	@Test
	public void UC5test2InValidInput() {

		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance().getViewsList().setSelectedIndex(x);
				MainUI.getInstance().getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance().getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance().getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance().getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance().getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance().getViewsList().setSelectedIndex(0);// Pie Chart

		correct = correct && MainUI.getInstance().getViewsList().getSelectedItem().toString().equals("Pie Chart");

		MainUI.getInstance().getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 0);
		assertTrue(correct);
	}

	@SuppressWarnings("static-access")
	@Test
	public void UC5test3ValidInput2() {

		MainUILuncher.main(null);
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance().getViewsList().setSelectedIndex(x);
				MainUI.getInstance().getRemoveView().doClick();
			}
		}
		boolean correct = Views.getInstance().getViews().size() == 0;
		
		MainUI.getInstance().getCountriesList().setSelectedIndex(1);// Canada
		MainUI.getInstance().getFromList().setSelectedIndex(2);// 2019
		MainUI.getInstance().getToList().setSelectedIndex(1);// 2020
		MainUI.getInstance().getMethodsList().setSelectedIndex(2);// CO2 Emissions vs Energy Use vs PM 2.5 Air
		MainUI.getInstance().getViewsList().setSelectedIndex(3);// Scatter Chart

		correct = correct && MainUI.getInstance().getViewsList().getSelectedItem().toString().equals("Scatter Chart");
        MainUI.getInstance().getAddView().doClick();
        MainUI.getInstance().getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 2);

		assertTrue(correct);
	}
	
	@Test
	public void UC5test4InvalidInput2() {

		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance().getViewsList().setSelectedIndex(x);
				MainUI.getInstance().getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance().getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance().getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance().getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance().getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance().getViewsList().setSelectedIndex(0);// Pie Chart

		correct = correct && MainUI.getInstance().getViewsList().getSelectedItem().toString().equals("Pie Chart");

		MainUI.getInstance().getAddView().doClick();
		MainUI.getInstance().getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 0);
		assertTrue(correct);
	}
	
	@Test
	public void UC5test5ValidAndInvalidInput() {

		MainUILuncher.main(null);
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance().getViewsList().setSelectedIndex(x);
				MainUI.getInstance().getRemoveView().doClick();
			}
		}
		boolean correct = Views.getInstance().getViews().size() == 0;
		
		MainUI.getInstance().getCountriesList().setSelectedIndex(1);// Canada
		MainUI.getInstance().getFromList().setSelectedIndex(2);// 2019
		MainUI.getInstance().getToList().setSelectedIndex(1);// 2020
		MainUI.getInstance().getMethodsList().setSelectedIndex(2);// CO2 Emissions vs Energy Use vs PM 2.5 Air
																	// Pollution(MEA)
		MainUI.getInstance().getViewsList().setSelectedIndex(3);// Scatter Chart
		correct = correct && MainUI.getInstance().getViewsList().getSelectedItem().toString().equals("Scatter Chart");
        MainUI.getInstance().getAddView().doClick();
        MainUI.getInstance().getAddView().doClick();
		correct = (correct && Views.getInstance().getViews().size() == 2);	
		MainUI.getInstance().getViewsList().setSelectedIndex(0);// Scatter Chart
		MainUI.getInstance().getAddView().doClick();	
		correct = (correct && Views.getInstance().getViews().size() == 2);
		
		assertTrue(correct);
	}

	
}
