package mainUI;


//Facade Design pattern is being used here
public class MainUI_Luncher {
	private static MainUI nMainUI;

	public static MainUI getnMainUI() {
		return nMainUI;
	}

	public static void main(String[] args) {
		// Initialization of the login page
		nMainUI = MainUI.getInstance();
	}
	

}
