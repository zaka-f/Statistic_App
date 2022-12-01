package performing_analyses;

import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;

public class GovtExpenditureonEducatiOnVsHealthExpenditurePercentage extends SuperClassGetData{

	private String country;
	private String yearStart;
	private String yearEnd;
	
	private String urlStringEducation;
	
	private String urlStringHealth;
	
	private JsonArray jsonArrayEducation;
	
	private JsonArray jsonArrayHealth;
	
	private HashMap<Integer, Double> yearValueHashMapEducation;
	private double cummulativeValueEducation;
	
	private HashMap<Integer, Double> yearValueHashMapHealth;
	private double cummulativeValueHealth;
	
	private HashMap<Integer, Double> yearValueHashMapEducationVsHealth;

	GovtExpenditureonEducatiOnVsHealthExpenditurePercentage(String country) {
		this.country = country;
		this.country = setCountryCode(country);
	    yearStart = updateStartYear();
	    yearEnd = updateEndYear();
	    
	    urlStringEducation = setURL(this.country, yearStart, yearEnd,"SE.XPD.TOTL.GD.ZS");
		this.jsonArrayEducation = retreiveData(urlStringEducation);
		yearValueHashMapEducation = new HashMap<Integer, Double>();
		
		System.out.println();
		System.out.println("Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)");
		System.out.println();
		
		processDataEducation();
		
		urlStringHealth = setURL(this.country, yearStart, yearEnd,"SH.XPD.CHEX.GD.ZS");
		this.jsonArrayHealth = retreiveData(urlStringHealth);
		yearValueHashMapHealth = new HashMap<Integer, Double>();
		
		yearValueHashMapEducationVsHealth = new HashMap<Integer, Double>();
		
		processDataHealth();
		
		processRatio();
	}

	private void processDataEducation() {
		double EducationForYear=0;
		cummulativeValueEducation = 0;
		int size = jsonArrayEducation.size();
		int sizeOfResults = jsonArrayEducation.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			//GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
							year = jsonArrayEducation.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
							
							// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
							// GIVEN YEAR
							if (jsonArrayEducation.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
								EducationForYear = 0;
							else
								// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
								// “value” FIELD
								EducationForYear = jsonArrayEducation.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsDouble();

							System.out.println("Government expenditure on education, total (% of GDP): " + year + " is " + EducationForYear+ " %");
							cummulativeValueEducation = cummulativeValueEducation + EducationForYear;
							yearValueHashMapEducation.put(year, EducationForYear);
	}	
	}

	private void processDataHealth() {
		
		double HealthForYear=0;
		cummulativeValueHealth = 0;
		int size = jsonArrayHealth.size();
		int sizeOfResults = jsonArrayHealth.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			//GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
							year = jsonArrayHealth.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
							
							// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
							// GIVEN YEAR
							if (jsonArrayHealth.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
								HealthForYear = 0;
							else
								// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
								// “value” FIELD
								HealthForYear = jsonArrayHealth.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsDouble();

							System.out.println("Current health expenditure (% of GDP): " + year + " is " + HealthForYear+ " %");
							cummulativeValueHealth = cummulativeValueHealth + HealthForYear;
							yearValueHashMapHealth.put(year, HealthForYear);
	}	
	}
	
	private void processRatio() {
		for(Entry<Integer, Double> set : yearValueHashMapEducation.entrySet()) {
	
			yearValueHashMapEducationVsHealth.put(set.getKey(), set.getValue()/ yearValueHashMapHealth.get(set.getKey()));
			System.out.println(set.getKey() + " is " + set.getValue()+ " % for eductaion vs "+yearValueHashMapHealth.get(set.getKey())+" % for health");
//			yearValueHashMapEducation.replace(set.getKey(), set.getValue(), set.getValue()/cummulativeValue);
}
		
	}

}
