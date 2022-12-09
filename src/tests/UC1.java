package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import loginArea.LoginPage;
import loginArea.UILauncher;

public class UC1 {

	UILauncher uiLauncher = new UILauncher();
	
	
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
}

