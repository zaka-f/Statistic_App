package loginArea;

import java.io.*;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class credentialChecker implements credentialCheckerDataRetriever {

	// instance variables
	private String username;
	private String password;

	// constructor
	protected credentialChecker(String username, String password) {
		this.username = username;
		this.password = password;
	}
	//function that gets all the username and passwords in the system in an array
	public JSONArray getValidCombos() {
		// initialise the Json parser object;
				JSONParser jsonP = new JSONParser();
		try {
			// reads the file
						FileReader fr = new FileReader(".\\credentialDatabase.txt");

						// Parses the json data inside the the filereader
						JSONObject jsonO = (JSONObject) jsonP.parse(fr);

						// initialise the jsonArray object by casting jsonO as a JSONArray
						JSONArray jsonA = (JSONArray) jsonO.get("users");
						return jsonA;
						
			
		}  catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
		
	}
	
	/*
	 * Here create a function that returns an array of size 2 where the first element is 
	 * the username and the second one is password
	 * return combo
	 * public  isUser() {
	 * */

	// function that checks whether the user exists or not in the file
	public ArrayList<String> getCombo() {

		ArrayList<String> comboArrayList = new ArrayList<String>();
		
		// get the array of all correct combinations of user and password
		JSONArray jsonA = getValidCombos();


			// Loop through all users and check their password;
			for (Object user : jsonA) {

				JSONObject tempUser = (JSONObject) user;

				String tempUsername = (String) tempUser.get("username");
				String tempPassword = (String) tempUser.get("password");
 
				
				if (tempUsername.equals(username) ) {
					comboArrayList.add(tempUsername);
					comboArrayList.add(tempPassword );
				}
				
			}

		return comboArrayList;

	}
}
