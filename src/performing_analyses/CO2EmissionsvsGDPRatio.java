package performing_analyses;

import java.util.HashMap;

import com.google.gson.JsonArray;

public class CO2EmissionsvsGDPRatio extends SuperClassGetData{
	private String country;
	private String yearStart;
	private String yearEnd;
	
	private String urlStringCO2Emission;
	
	private String urlStringGDP;
	
	private JsonArray jsonArrayCO2Emission;
	
	private JsonArray jsonArrayGDP;
	
	private HashMap<Integer, Double> yearValueHashMapCO2Emission;
	private double cummulativeValueCO2Emission;
	
	private HashMap<Integer, Double> yearValueHashMapGDP;
	private double cummulativeValueGDP;

	CO2EmissionsvsGDPRatio(String country) {
		this.country = country;
		this.country = setCountryCode(country);
	    yearStart = updateStartYear();
	    yearEnd = updateEndYear();
	    
	    urlStringCO2Emission = setURL(this.country, yearStart, yearEnd,"EN.ATM.CO2E.KT");
		this.jsonArrayCO2Emission = retreiveData(urlStringCO2Emission);
		yearValueHashMapCO2Emission = new HashMap<Integer, Double>();
		
		processDataCO2();
		
		urlStringGDP = setURL(this.country, yearStart, yearEnd,"NY.GDP.MKTP.CD");
		this.jsonArrayGDP = retreiveData(urlStringCO2Emission);
		yearValueHashMapGDP = new HashMap<Integer, Double>();
		
//		processDataCO2();
	}

	private void processDataCO2() {
		double CO2EmmissionsForYear=0;
		cummulativeValueCO2Emission = 0;
		int size = jsonArrayCO2Emission.size();
		int sizeOfResults = jsonArrayCO2Emission.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			//GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
							year = jsonArrayCO2Emission.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
							
							// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
							// GIVEN YEAR
							if (jsonArrayCO2Emission.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
								CO2EmmissionsForYear = 0;
							else
								// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
								// “value” FIELD
								CO2EmmissionsForYear = jsonArrayCO2Emission.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsDouble();

							System.out.println("CO2 emmissions: " + year + " is " + CO2EmmissionsForYear+ " kt");
							cummulativeValueCO2Emission = cummulativeValueCO2Emission + CO2EmmissionsForYear;
							yearValueHashMapCO2Emission.put(year, CO2EmmissionsForYear);
	}
		
	}


	public static void main(String[] args) {
		new CO2EmissionsvsGDPRatio("Canada");
	}
}
