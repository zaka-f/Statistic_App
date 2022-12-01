package analyses;

public class Analyses {
	
	//instance variable
	String analyses;
	
	//getter method
	public String getAnalyses() {
		return analyses;
	}

	//setter method
	public void setAnalyses(String analyses) {
		this.analyses = analyses;
	}

	//overloaded constructor
	public Analyses(String type) {
		analyses = type;
	}

}
