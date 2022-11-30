package years;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class YearsAnalysesDataProcessor implements YearsAnalysesDataExtractor {

	// instance variables
	private String analyses;
	private JSONArray data;
	private List<Integer> isfetchable;

	// constructor
	protected YearsAnalysesDataProcessor(String analyses) {
		this.analyses = analyses;
		isfetchable = new ArrayList<Integer>();
		ExtractData();
	}

	public void ExtractData() {
		// initialise the Json parser object;
		JSONParser jsonP = new JSONParser();

		try {
			// reads the file
			FileReader fr = new FileReader(".\\Years_Analyses_Compatibility.txt");

			// Parses the json data inside the the filereader
			JSONObject jsonO = (JSONObject) jsonP.parse(fr);

			// initialise the datarray object by casting jsonO as a JSONArray
			data = (JSONArray) jsonO.get("analysesXyears");
			// exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// function that checks whether the user exists or not in the file
	public List<Integer> getFetchable() {

		// Loop through all users and check their password;
		for (Object analyses : data) {

			JSONObject tempAnalyses = (JSONObject) analyses;

			String tempAnalyse = String.valueOf(tempAnalyses.get("analyses"));
			int tempYear = Integer.parseInt(String.valueOf(tempAnalyses.get("year")));

			System.out.println(tempAnalyse + "\n");
			System.out.println(this.analyses + "\n");
			if (tempAnalyse.equals(this.analyses)) {
				System.out.println("here \n");
				isfetchable.add(tempYear);
			}
			

		}

		System.out.println(isfetchable + "\n");
		return isfetchable;
	}

}
