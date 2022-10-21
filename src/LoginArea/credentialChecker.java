package LoginArea;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class credentialChecker {
	
	 private String username;
	 private String password;

	public credentialChecker(String username, String password) {
		this.username = username;
		this.password = password;
	}

	boolean isUser() {
		boolean isUser = false;
		JSONParser jsonP = new JSONParser();
		
	      try {
	    	  FileReader fr = new FileReader("C:\\Users\\zakar\\eclipse-workspace\\Countries Statistics\\credentialDatabase.txt");
	    	  JSONObject jsonO = (JSONObject) jsonP.parse(fr);
	      
	    	  JSONArray jsonA = (JSONArray) jsonO.get("users");
	    			  
	    	  for (Object user : jsonA) {
	    		  
	    		  JSONObject tempUser = (JSONObject) user;
	    		  
	    		  String tempUsername = (String) tempUser.get("username");
	    		  String tempPassword = (String) tempUser.get("password");	    		  
	    		  
	    		  if (tempUsername.equals(username) && tempPassword.equals(password)) {
	    			  isUser = true;};    		  
	    	  }

	       } catch (FileNotFoundException e) {
	          e.printStackTrace();
	       } catch (IOException e) {
	          e.printStackTrace();
	       } catch (ParseException e) {
	          e.printStackTrace();
	       }
		
	    System.out.print(isUser);
		return isUser;
		
	}
}
