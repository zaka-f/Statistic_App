package mainUI;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CountryFetchableChecker {

		// instance variables
		private String country;

		// constructor
		protected CountryFetchableChecker(String country) {
			this.country = country;
		}

		// function that checks whether the user exists or not in the file
		boolean isUser() {

			boolean isfetchable = false;

			// initialise the Json parser object;
			JSONParser jsonP = new JSONParser();

			try {
				// reads the file
				FileReader fr = new FileReader(".\\countriesFetchability.txt");

				// Parses the json data inside the the filereader
				JSONObject jsonO = (JSONObject) jsonP.parse(fr);

				// initialise the jsonArray object by casting jsonO as a JSONArray
				JSONArray jsonA = (JSONArray) jsonO.get("countries");

				// Loop through all users and check their password;
				for (Object country : jsonA) {

					JSONObject tempUser = (JSONObject) country;

					String tempCountry = (String) tempUser.get("country");
					String tempFetchable = (String) tempUser.get("fetchable");

					if (tempCountry.equals(country)) {
						if (tempFetchable.equals("true"))
						isfetchable = true;
					}
					;
				}

				// exceptions
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

			return isfetchable;

		}
}


