package countries;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CountryFetchableChecker implements CountryFetchableDataRetreiver {

	// instance variables
	private String country;
	JSONArray data;

	// constructor
	protected CountryFetchableChecker(String country) {
		this.country = country;
		ExtractData();
	}

	public void ExtractData() {
		// initialise the Json parser object;
		JSONParser jsonP = new JSONParser();

		try {
			// reads the file
			FileReader fr = new FileReader(".\\countriesFetchability.txt");

			// Parses the json data inside the the filereader
			JSONObject jsonO = (JSONObject) jsonP.parse(fr);

			// initialise the datarray object by casting jsonO as a JSONArray
			data = (JSONArray) jsonO.get("countries");
			// exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// function that returns the value of "fetchable" assossiated with the country
	public String getFetchable() {

		String isfetchable = "";

		// Loop through all the countries
		for (Object country : data) {

			JSONObject tempUser = (JSONObject) country;

			String tempCountry = (String) tempUser.get("country");

			if (tempCountry.equals(this.country)) {
				return String.valueOf(tempUser.get("fetchable"));
			}
			;

		}

		return isfetchable;
	}

}
