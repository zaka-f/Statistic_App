package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import loginArea.LoginPage;
import loginArea.UILauncher;
import mainUI.MainUI;
import mainUI.MainUILuncher;
import viewers.Views;
import years.YearsDecider;

public class AllUCTests {
UILauncher uiLauncher = new UILauncher();
	
	
    /*
     * UC1
     */

	@SuppressWarnings("static-access")
	@Test
	public void test1() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("1a");
		LoginPage.getUsername().setText("zakaria");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		
		assertTrue(isTrue);
	}
	

	@Test
	public void test2() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("wrong");
		LoginPage.getUsername().setText("zakaria");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test3() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("1a");
		LoginPage.getUsername().setText("wrong");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test4() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("wrong");
		LoginPage.getUsername().setText("wrong");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test5() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("1a");
		LoginPage.getUsername().setText("jamal");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test6() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("");
		LoginPage.getUsername().setText("");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test7() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("");
		LoginPage.getUsername().setText("zakaria");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test8() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		LoginPage.getPassword().setText("1a");
		LoginPage.getUsername().setText("");
		LoginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
    /*
     * UC2
     */
	
	
	@SuppressWarnings("static-access")
	@Test
	public void uC2test1() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);//Brazil
		boolean correct = MainUI.getCoutryAction().isFetchable();
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void uC2test2() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(1);//Cnada
		boolean correct = MainUI.getCoutryAction().isFetchable();
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void uC2test3() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(2);//China
		boolean correct = MainUI.getCoutryAction().isFetchable();
		assertTrue(!correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void uC2test4() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(3);//France
		boolean correct = MainUI.getCoutryAction().isFetchable();
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void uC2test5() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(4);//USA
		boolean correct = MainUI.getCoutryAction().isFetchable();
		assertTrue(!correct);
	}

    /*
     * UC4
     */
	
	@SuppressWarnings("static-access")
	@Test
	public void test1ValidInput() {

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		boolean correct = MainUI.getFromList().getSelectedItem().toString().equals("2020");
		MainUI.getInstance();
		correct = correct && MainUI.getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && YearsDecider.getInstance().isYearAvailable()
				&& YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test2IncorrectYearsOrder() {

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		boolean correct = MainUI.getFromList().getSelectedItem().toString().equals("2021");
		MainUI.getInstance();
		correct = correct && MainUI.getToList().getSelectedItem().toString().equals("2020");
		correct = (correct && !YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test3CorrectYearsOrder() {

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		boolean correct = MainUI.getFromList().getSelectedItem().toString().equals("2020");
		MainUI.getInstance();
		correct = correct && MainUI.getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test4YearsNotAvailable() {

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(11);// 2010
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		boolean correct = MainUI.getFromList().getSelectedItem().toString().equals("2010");
		MainUI.getInstance();
		correct = correct && MainUI.getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && !YearsDecider.getInstance().isYearAvailable());
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test5YearsAvailable() {

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(0);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(9);// 2012
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		boolean correct = MainUI.getFromList().getSelectedItem().toString().equals("2011");
		MainUI.getInstance();
		correct = correct && MainUI.getToList().getSelectedItem().toString().equals("2021");
		correct = (correct && YearsDecider.getInstance().isYearAvailable());
		assertTrue(!correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test6YearsNotAvailableAndWrongOrder() {

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(11);// 2010
		MainUI.getInstance();
		boolean correct = MainUI.getFromList().getSelectedItem().toString().equals("2021");
		MainUI.getInstance();
		System.out.println(MainUI.getFromList().getSelectedItem().toString());
		MainUI.getInstance();
		correct = correct && MainUI.getToList().getSelectedItem().toString().equals("2010");
		MainUI.getInstance();
		System.out.println(MainUI.getToList().getSelectedItem().toString());
		correct = (correct && YearsDecider.getInstance().isYearAvailable()
				&& YearsDecider.getInstance().isYearOrderCorrect());
		assertTrue(!correct);
	}
	
    /*
     * UC4
     */
	
	@SuppressWarnings("static-access")
	@Test
	public void UC5test1ValidInput() {

		while (Views.getInstance().getViews().size() > 0) {
			MainUI.getInstance();
			MainUI.getRemoveView().doClick();

		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(1);// Line Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Line Chart");

		MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 1);
		assertTrue(correct);
	}

	@SuppressWarnings("static-access")
	@Test
	public void UC5test2InValidInput() {

		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance();
				MainUI.getViewsList().setSelectedIndex(x);
				MainUI.getInstance();
				MainUI.getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(0);// Pie Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Pie Chart");

		MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 0);
		assertTrue(correct);
	}

	@SuppressWarnings("static-access")
	@Test
	public void UC5test3ValidInput2() {

		MainUILuncher.main(null);
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance();
				MainUI.getViewsList().setSelectedIndex(x);
				MainUI.getInstance();
				MainUI.getRemoveView().doClick();
			}
		}
		boolean correct = Views.getInstance().getViews().size() == 0;
		
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(1);// Canada
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(2);// 2019
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(2);// CO2 Emissions vs Energy Use vs PM 2.5 Air
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(3);// Scatter Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Scatter Chart");
        MainUI.getInstance();
		MainUI.getAddView().doClick();
        MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 2);

		assertTrue(correct);
	}
	
	@Test
	public void UC5test4InvalidInput2() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance();
				MainUI.getViewsList().setSelectedIndex(x);
				MainUI.getInstance();
				MainUI.getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(0);// Pie Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Pie Chart");

		MainUI.getInstance();
		MainUI.getAddView().doClick();
		MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 0);
		assertTrue(correct);
	}
	
	@Test
	public void UC5test5ValidAndInvalidInput() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance();
				MainUI.getViewsList().setSelectedIndex(x);
				MainUI.getInstance();
				MainUI.getRemoveView().doClick();
			}
		}
		boolean correct = Views.getInstance().getViews().size() == 0;
		
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(1);// Canada
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(2);// 2019
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(2);// CO2 Emissions vs Energy Use vs PM 2.5 Air
																	MainUI.getInstance();
		// Pollution(MEA)
		MainUI.getViewsList().setSelectedIndex(3);// Scatter Chart
		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Scatter Chart");
        MainUI.getInstance();
		MainUI.getAddView().doClick();
        MainUI.getInstance();
		MainUI.getAddView().doClick();
		correct = (correct && Views.getInstance().getViews().size() == 2);	
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(0);// Scatter Chart
		MainUI.getInstance();
		MainUI.getAddView().doClick();	
		correct = (correct && Views.getInstance().getViews().size() == 2);
		
		assertTrue(correct);
	}
	
	/*
     * UC6
     */
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test1Remove1() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance();
				MainUI.getViewsList().setSelectedIndex(x);
				MainUI.getInstance();
				MainUI.getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(1);// Line Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Line Chart");

		MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 1);
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test2Remove3() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance();
				MainUI.getViewsList().setSelectedIndex(x);
				MainUI.getInstance();
				MainUI.getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(1);// Line Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Line Chart");

		MainUI.getInstance();
		MainUI.getAddView().doClick();
		MainUI.getInstance();
		MainUI.getAddView().doClick();
		MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 3);
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test3RemoveEmpty3() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() != 0) {
			for(int x=0; x<6; x++) {
				MainUI.getInstance();
				MainUI.getViewsList().setSelectedIndex(x);
				MainUI.getInstance();
				MainUI.getRemoveView().doClick();
			}
		}

		boolean correct = Views.getInstance().getViews().size() == 0;
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test4RemoveDifferent() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() > 0) {
			MainUI.getInstance();
			MainUI.getRemoveView().doClick();

		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(1);// Line Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Line Chart");

		MainUI.getInstance();
		MainUI.getAddView().doClick();
		MainUI.getInstance();
		MainUI.getAddView().doClick();		
		MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 3);
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(1);//BarChart Chart
		
		MainUI.getInstance();
		MainUI.getAddView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 1);
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void UC6test5RemoveDifferentAndEmpty() {

		//Removing any potential existing view
		while (Views.getInstance().getViews().size() > 0) {
			MainUI.getInstance();
			MainUI.getRemoveView().doClick();

		}

		boolean correct = Views.getInstance().getViews().size() == 0;

		MainUILuncher.main(null);
		MainUI.getInstance();
		MainUI.getCountriesList().setSelectedIndex(0);// Brazil
		MainUI.getInstance();
		MainUI.getFromList().setSelectedIndex(1);// 2020
		MainUI.getInstance();
		MainUI.getToList().setSelectedIndex(0);// 2021
		MainUI.getInstance();
		MainUI.getMethodsList().setSelectedIndex(1);// Govt Expenditure on Education vs Health Expenditure
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(1);// Line Chart

		MainUI.getInstance();
		correct = correct && MainUI.getViewsList().getSelectedItem().toString().equals("Line Chart");

		MainUI.getInstance();
		MainUI.getAddView().doClick();
		MainUI.getInstance();
		MainUI.getAddView().doClick();		
		MainUI.getInstance();
		MainUI.getAddView().doClick();

		correct = (correct && Views.getInstance().getViews().size() == 3);
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		MainUI.getInstance();
		MainUI.getViewsList().setSelectedIndex(1);//BarChart Chart
		
		MainUI.getInstance();
		MainUI.getAddView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 1);
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		MainUI.getInstance();
		MainUI.getRemoveView().doClick();
		
		correct = (correct && Views.getInstance().getViews().size() == 0);
		
		assertTrue(correct);
	}
	
}
