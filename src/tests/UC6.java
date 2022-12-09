package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mainUI.MainUI;
import mainUI.MainUILuncher;
import viewers.BarChart;
import viewers.Views;

public class UC6 {

	MainUILuncher mainUILauncher = new MainUILuncher();

	@SuppressWarnings("static-access")
	@Test
	public void UC6test1Remove1() {

		//Removing any potential existing view
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
		
		MainUI.getInstance().getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test2Remove3() {

		//Removing any potential existing view
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
		MainUI.getInstance().getAddView().doClick();
		MainUI.getInstance().getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 3);
		
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test3RemoveEmpty3() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance().getViewsList().setSelectedIndex(x);
				MainUI.getInstance().getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;
		
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test4RemoveDifferent() {

		//Removing any potential existing view
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
		MainUI.getInstance().getAddView().doClick();		
		MainUI.getInstance().getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 3);
		
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		
		MainUI.getInstance().getViewsList().setSelectedIndex(1);//BarChart Chart
		
		MainUI.getInstance().getAddView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 1);
		
		MainUI.getInstance().getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test5RemoveDifferentAndEmpty() {

		//Removing any potential existing view
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
		MainUI.getInstance().getAddView().doClick();		
		MainUI.getInstance().getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 3);
		
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		MainUI.getInstance().getRemoveView().doClick();
		
		MainUI.getInstance().getViewsList().setSelectedIndex(1);//BarChart Chart
		
		MainUI.getInstance().getAddView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 1);
		
		MainUI.getInstance().getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		MainUI.getInstance().getRemoveView().doClick();
		
		MainUI.getInstance().getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	
}
