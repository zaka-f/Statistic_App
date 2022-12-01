package performing_analyses;

import java.util.HashMap;
import java.util.Map.Entry;

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
	
	private HashMap<Integer, Double> yearValueHashMapRatio;

	CO2EmissionsvsGDPRatio(String country) {
		this.country = country;
		this.country = setCountryCode(country);
	    yearStart = updateStartYear();
	    yearEnd = updateEndYear();
	    
	    urlStringCO2Emission = setURL(this.country, yearStart, yearEnd,"EN.ATM.CO2E.KT");
		this.jsonArrayCO2Emission = retreiveData(urlStringCO2Emission);
		yearValueHashMapCO2Emission = new HashMap<Integer, Double>();
		
		System.out.println();
		System.out.println("CO2 Emissions vs GDP Ratio");
		System.out.println();
		
		processDataCO2();
		
		urlStringGDP = setURL(this.country, yearStart, yearEnd,"NY.GDP.MKTP.CD");
		this.jsonArrayGDP = retreiveData(urlStringGDP);
		yearValueHashMapGDP = new HashMap<Integer, Double>();
		
		yearValueHashMapRatio = new HashMap<Integer, Double>();
		
		processDataGDP();
		
		processRatio();
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
										.getAsDouble() * 1000000;

							System.out.println("CO2 emmissions: " + year + " is " + CO2EmmissionsForYear+ " kg");
							cummulativeValueCO2Emission = cummulativeValueCO2Emission + CO2EmmissionsForYear;
							yearValueHashMapCO2Emission.put(year, CO2EmmissionsForYear);
	}	
	}

	private void processDataGDP() {
		
		double GDPForYear=0;
		cummulativeValueGDP = 0;
		int size = jsonArrayGDP.size();
		int sizeOfResults = jsonArrayGDP.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			//GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
							year = jsonArrayGDP.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
							
							// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
							// GIVEN YEAR
							if (jsonArrayGDP.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
								GDPForYear = 0;
							else
								// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
								// “value” FIELD
								GDPForYear = jsonArrayGDP.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsDouble();

							System.out.println("GDP: " + year + " is " + GDPForYear+ " US$");
							cummulativeValueGDP = cummulativeValueGDP + GDPForYear;
							yearValueHashMapGDP.put(year, GDPForYear);
	}	
	}
	
	private void processRatio() {
		for(Entry<Integer, Double> set : yearValueHashMapCO2Emission.entrySet()) {
	
			yearValueHashMapRatio.put(set.getKey(), set.getValue()/ yearValueHashMapGDP.get(set.getKey()));
			System.out.println("Ratio CO2 Emmissions/GDP: " + set.getKey() + " is " + set.getValue()/ yearValueHashMapGDP.get(set.getKey())+ " kg per US$");
//			yearValueHashMapCO2Emission.replace(set.getKey(), set.getValue(), set.getValue()/cummulativeValue);
}
		
	}

	public static void main(String[] args) {
		new CO2EmissionsvsGDPRatio("Canada");
	}
}
