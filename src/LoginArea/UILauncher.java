package LoginArea;

public class UILauncher {

	private static LoginPage nLoginPage;

	public static LoginPage getnLoginPage() {
		return nLoginPage;
	}

	public static void main(String[] args) {
		// Initialization of the login page
		nLoginPage = new LoginPage();
	}

}
