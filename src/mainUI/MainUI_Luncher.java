package mainUI;

import LoginArea.LoginPage;

public class MainUI_Luncher {
	private static MainUI nMainUI;

	public static MainUI getnLoginPage() {
		return nMainUI;
	}

	public static void main(String[] args) {
		// Initialization of the login page
		nMainUI = MainUI.getInstance();
	}
	

}
