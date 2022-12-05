package tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

import loginArea.LoginPage;
import loginArea.UILauncher;
import loginArea.actionButtonLogin;
import mainUI.MainUI;
import viewers.newChartPanel;

public class UC1 {

	UILauncher uiLauncher = new UILauncher();
	
	
	@SuppressWarnings("static-access")
	@Test
	public void test1() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("1a");
		loginPage.getUsername().setText("zakaria");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		
		assertTrue(isTrue);
	}
	

	@Test
	public void test2() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("wrong");
		loginPage.getUsername().setText("zakaria");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test3() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("1a");
		loginPage.getUsername().setText("wrong");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test4() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("wrong");
		loginPage.getUsername().setText("wrong");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test5() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("1a");
		loginPage.getUsername().setText("jamal");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test6() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("");
		loginPage.getUsername().setText("");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test7() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("");
		loginPage.getUsername().setText("zakaria");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
	
	@Test
	public void test8() {

		UILauncher.main(null);
		LoginPage loginPage = UILauncher.getnLoginPage();
		loginPage.getPassword().setText("1a");
		loginPage.getUsername().setText("");
		loginPage.getButton().doClick();
		
		boolean isTrue = loginPage.getActionButton().isAccess();
		int correct = 0;
		if (isTrue) correct = 1;
		assertEquals(0, correct);
	}
}

