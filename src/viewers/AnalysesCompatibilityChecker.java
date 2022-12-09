package viewers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AnalysesCompatibilityChecker {
	// instance variables
	private String graphType;
	private String analysesType;

	// constructor
	protected AnalysesCompatibilityChecker(String graphType, String analysesType) {
		this.graphType = graphType;
		this.analysesType = analysesType;

	}

	// parse through text file to find invalid combos of analyses and graph types
	public JSONArray getInvalidCombos() {
		// initialise the Json parser object;
		JSONParser jsonP = new JSONParser();
		try {
			// reads the file
			FileReader fr = new FileReader(".\\Analyses_Graph_Compatibility.txt");

			// Parses the json data inside the the filereader
			JSONObject jsonO = (JSONObject) jsonP.parse(fr);

			// initialise the jsonArray object by casting jsonO as a JSONArray
			JSONArray jsonA = (JSONArray) jsonO.get("analyses");
			return jsonA;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> getCombo() {
		ArrayList<String> comboArrayList = new ArrayList<String>();

		// get the array of all incorrect combinations of Analyses and Graph type
		JSONArray jsonA = getInvalidCombos();

		// System.out.println(analyses);
		// Loop through all analyses types and check the compatability with the
		// graphtype;
		for (Object analyses : jsonA) {

			JSONObject tempAnalys = (JSONObject) analyses;

			String tempAnalyses = (String) tempAnalys.get("analysis");
			String tempGraph = (String) tempAnalys.get("incompatible");

			if (tempAnalyses.equals(graphType)) {
				comboArrayList.add(tempAnalyses);
				comboArrayList.add(tempGraph);
			}

		}

		return comboArrayList;
	}

}
