package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import mainUI.MainUI;
import mainUI.MainUILuncher;
import viewers.newChartPanel;
import years.YearsDecider;

public class UC4 {

	MainUILuncher mainUILauncher = new MainUILuncher();

//	System.out.println(MainUI.getInstance().getToList().getSelectedItem().toString());
	
	@SuppressWarnings("static-access")
	@Test
	public void test1ValidInput() {

		MainUILuncher.main(null);
		MainUI.getInstance().getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance().getToList().setSelectedIndex(0);// 2021
		boolean correct = MainUI.getInstance().getFromList().getSelectedItem().toString().equals("2020");
		correct = correct && MainUI.getInstance().getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && YearsDecider.getInstance().isYearAvailable()
				&& YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test2IncorrectYearsOrder() {

		MainUILuncher.main(null);
		MainUI.getInstance().getFromList().setSelectedIndex(0);// 2021
		MainUI.getInstance().getToList().setSelectedIndex(1);// 2020
		boolean correct = MainUI.getInstance().getFromList().getSelectedItem().toString().equals("2021");
		correct = correct && MainUI.getInstance().getToList().getSelectedItem().toString().equals("2020");
		correct = (correct && !YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test3CorrectYearsOrder() {

		MainUILuncher.main(null);
		MainUI.getInstance().getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance().getToList().setSelectedIndex(0);// 2021
		boolean correct = MainUI.getInstance().getFromList().getSelectedItem().toString().equals("2020");
		correct = correct && MainUI.getInstance().getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test4YearsNotAvailable() {

		MainUILuncher.main(null);
		MainUI.getInstance().getFromList().setSelectedIndex(11);// 2010
		MainUI.getInstance().getToList().setSelectedIndex(0);// 2021
		boolean correct = MainUI.getInstance().getFromList().getSelectedItem().toString().equals("2010");
		correct = correct && MainUI.getInstance().getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && !YearsDecider.getInstance().isYearAvailable());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test5YearsAvailable() {

		MainUILuncher.main(null);
		MainUI.getInstance().getFromList().setSelectedIndex(10);// 2011
		MainUI.getInstance().getToList().setSelectedIndex(0);// 2021
		boolean correct = MainUI.getInstance().getFromList().getSelectedItem().toString().equals("2011");
		correct = correct && MainUI.getInstance().getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && YearsDecider.getInstance().isYearAvailable());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test6YearsNotAvailableAndWrongOrder() {

		MainUILuncher.main(null);
		MainUI.getInstance().getFromList().setSelectedIndex(0);// 2021
		MainUI.getInstance().getToList().setSelectedIndex(11);// 2010
		boolean correct = MainUI.getInstance().getFromList().getSelectedItem().toString().equals("2021");
		System.out.println(MainUI.getInstance().getFromList().getSelectedItem().toString());
		correct = correct && MainUI.getInstance().getToList().getSelectedItem().toString().equals("2010");
		System.out.println(MainUI.getInstance().getToList().getSelectedItem().toString());
		correct = (correct && YearsDecider.getInstance().isYearAvailable()
				&& YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(!correct);
	}
	
}
