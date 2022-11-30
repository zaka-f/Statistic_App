package loginArea;

//Facade design pattern
public class UILauncher {

	private static LoginPage nLoginPage;

	public static LoginPage getnLoginPage() {
		return nLoginPage;
	}

	public static void main(String[] args) {
		// Initialization of the login page
		nLoginPage = LoginPage.getInstance();
	}

}
