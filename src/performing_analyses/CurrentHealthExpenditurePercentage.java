package performing_analyses;

import java.util.HashMap;

import com.google.gson.JsonArray;

public class CurrentHealthExpenditurePercentage extends SuperClassGetData{

	

	private String country;
	private String yearStart;
	private String yearEnd;
	private String urlString;
	private JsonArray jsonArray;
	private double cummulativeValue;
	private HashMap<Integer, Double> yearValueHashMap;

	CurrentHealthExpenditurePercentage(String country) {
		this.country = country;
		this.country = setCountryCode(country);
	    yearStart = updateStartYear();
	    yearEnd = updateEndYear();
	    urlString = setURL(this.country, yearStart, yearEnd, "SH.XPD.CHEX.GD.ZS");
		this.jsonArray = retreiveData(urlString);
		yearValueHashMap = new HashMap<Integer, Double>();
		
		System.out.println();
		System.out.println("Current Health Expenditure %");
		System.out.println();
		
		processData();
		
	}

	private void processData() {
		double currentHealthExpenditurePercentageForYear=0;
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
								currentHealthExpenditurePercentageForYear = 0;
							else
								// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
								// “value” FIELD
								currentHealthExpenditurePercentageForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsDouble();

							System.out.println("Current health expenditure percentage for a year : " + year + " is " + currentHealthExpenditurePercentageForYear+" %");
							cummulativeValue = cummulativeValue + currentHealthExpenditurePercentageForYear;
							yearValueHashMap.put(year, currentHealthExpenditurePercentageForYear);
	}
	}

}
