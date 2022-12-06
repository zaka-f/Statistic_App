package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import error_message.ErrorMessage;
import mainUI.MainUI;
import mainUI.MainUILuncher;

public class UC2 {

	MainUILuncher mainUILauncher = new MainUILuncher();
	
	
	@SuppressWarnings("static-access")
	@Test
	public void test1() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		mainUI.getCountriesList().setSelectedIndex(0);//Brazil
		boolean correct = mainUI.getCoutryAction().isFetchable();
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test2() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		mainUI.getCountriesList().setSelectedIndex(1);//Cnada
		boolean correct = mainUI.getCoutryAction().isFetchable();
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test3() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		mainUI.getCountriesList().setSelectedIndex(2);//China
		boolean correct = mainUI.getCoutryAction().isFetchable();
		assertTrue(!correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test4() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		mainUI.getCountriesList().setSelectedIndex(3);//France
		boolean correct = mainUI.getCoutryAction().isFetchable();
		assertTrue(correct);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test5() {

		MainUILuncher.main(null);
		MainUI mainUI = MainUI.getInstance();
		mainUI.getCountriesList().setSelectedIndex(4);//USA
		boolean correct = mainUI.getCoutryAction().isFetchable();
		assertTrue(!correct);
	}

	
}

