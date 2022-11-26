package Dropdown_Menu_Years;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Years_Analyses_Data_Processor implements Years_Analyses_Data_Extractor{

	// instance variables
	private String analyses;
	JSONArray data;

	// constructor
	protected Years_Analyses_Data_Processor(String analyses) {
		this.analyses = analyses;
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

		List<Integer> isfetchable = new ArrayList<Integer>();

		// Loop through all users and check their password;
		for (Object analyses : data) {

			JSONObject tempAnalyses = (JSONObject) analyses;

			String tempYear = (String) tempAnalyses.get("year");

			if (tempYear.equals(this.analyses)) {
				return String.valueOf(tempUser.get("fetchable"));
			}
			;

		}

		return isfetchable;
	}
	
}
