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
		private String username;
		private String password;

		// constructor
		protected credentialChecker(String country) {
			this.username = username;
			this.password = password;
		}

		// function that checks wether the user exists or not in the file
		boolean isUser() {

			boolean isUser = false;

			// initialise the Json parser object;
			JSONParser jsonP = new JSONParser();

			try {
				// reads the file
				FileReader fr = new FileReader(".\\credentialDatabase.txt");

				// Parses the json data inside the the filereader
				JSONObject jsonO = (JSONObject) jsonP.parse(fr);

				// initialise the jsonArray object by casting jsonO as a JSONArray
				JSONArray jsonA = (JSONArray) jsonO.get("users");

				// Loop through all users and check their password;
				for (Object user : jsonA) {

					JSONObject tempUser = (JSONObject) user;

					String tempUsername = (String) tempUser.get("username");
					String tempPassword = (String) tempUser.get("password");

					if (tempUsername.equals(username) && tempPassword.equals(password)) {
						isUser = true;
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

			return isUser;

		}
	}

}
