package viewers;

import java.util.ArrayList;

import loginArea.credentialChecker;

public class CompatibilityCheckerProxy implements AnalysisCompatibilityDataRetriever {
	// instance variables
	private String analyses;
	private String graph;
	private AnalysesCompatibilityChecker checker;
	private ArrayList<String> comboArrayList;
	
	//constructors
	public CompatibilityCheckerProxy(String analyses, String graph) {
		this.analyses = analyses;
		this.graph = graph;
		comboArrayList = new ArrayList<String>();
		checker = new AnalysesCompatibilityChecker(analyses, graph);
		
	}
	
	//method gets all the invalid combos
	@Override
	public void getCombo() {
		comboArrayList = checker.getCombo();

	}
	public Boolean isInvalid() {
		getCombo();
	
		if(comboArrayList.size() > 0) {
			for(int x = 0; x < comboArrayList.size()-1; x++) {
				if(comboArrayList.get(x).equals(analyses) && comboArrayList.get(x + 1).equals(graph)) {
					return true;
				}
			}
			
			
		}
		
		return false;
	}

}
