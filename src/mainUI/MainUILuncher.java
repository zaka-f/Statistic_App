package mainUI;


//Facade Design pattern is being used here
public class MainUILuncher {
	private static MainUI nMainUI;

	public static MainUI getnMainUI() {
		return nMainUI;
	}

	public static void main(String[] args) {
		// Initialization of the login page
		nMainUI = MainUI.getInstance();
		
	}
	

}
