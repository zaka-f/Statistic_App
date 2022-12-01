package performing_analyses;

import java.util.HashMap;

import com.google.gson.JsonArray;

public class AverageGovtExpenditureOnEducationPercentageOfGDP extends SuperClassGetData{

	private String country;
	private String yearStart;
	private String yearEnd;
	private String urlString;
	private JsonArray jsonArray;
	private HashMap<Integer, Double> yearValueHashMap;
	private double cummulativeValue;
	private double average;

	AverageGovtExpenditureOnEducationPercentageOfGDP(String country) {
		
		this.country = country;
		this.country = setCountryCode(country);
	    yearStart = updateStartYear();
	    yearEnd = updateEndYear();
	    urlString = setURL(this.country, yearStart, yearEnd,"SE.XPD.TOTL.GD.ZS");
		this.jsonArray = retreiveData(urlString);
		yearValueHashMap = new HashMap<Integer, Double>();
		
		System.out.println();
		System.out.println("Average Govt Expenditure on Education %(of GDP)");
		System.out.println();
		
		processData();

	}

	private void processData() {
		double govtExpenditureOnEducationPercentageOfGDP=0;
		cummulativeValue = 0;
		int size = jsonArray.size();
		int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			//GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
							year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
							
							// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
							// GIVEN YEAR
							if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
								govtExpenditureOnEducationPercentageOfGDP = 0;
							else
								// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
								// “value” FIELD
								govtExpenditureOnEducationPercentageOfGDP = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsDouble();

							System.out.println("Govt Expenditure On Education Percentage Of GDP for : " + year + " is " + govtExpenditureOnEducationPercentageOfGDP+ " %");
							cummulativeValue = cummulativeValue + govtExpenditureOnEducationPercentageOfGDP;
							yearValueHashMap.put(year, govtExpenditureOnEducationPercentageOfGDP);
	}
		average = cummulativeValue/(Double.parseDouble(yearEnd) - Double.parseDouble(yearStart) + 1);
	System.out.println("Average forest Area percentage over the years is "+ average+ " %");


		
	}



}
