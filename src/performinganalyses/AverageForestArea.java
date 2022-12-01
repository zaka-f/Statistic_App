package performinganalyses;

import java.util.HashMap;
import com.google.gson.JsonArray;

public class AverageForestArea extends SuperClassGetData {

	private String country;
	private String yearStart;
	private String yearEnd;
	private String urlString;
	private JsonArray jsonArray;
	private HashMap<Integer, Double> yearValueHashMap;
	private double cummulativeValue;
	private double average;

	AverageForestArea(String country) {
		this.country = country;
		this.country = setCountryCode(country);
	    yearStart = updateStartYear();
	    yearEnd = updateEndYear();
	    urlString = setURL(this.country, yearStart, yearEnd,"AG.LND.FRST.ZS");
		this.jsonArray = retreiveData(urlString);
		yearValueHashMap = new HashMap<Integer, Double>();
		processData();
	}

	private void processData() {
		double averageForestAreaForYear=0;
		cummulativeValue = 0;
		int size = jsonArray.size();
		int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			//GET FOR EACH ENTRY THE YEAR FROM THE �date� FIELD
							year = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();
							
							// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
							// GIVEN YEAR
							if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
								averageForestAreaForYear = 0;
							else
								// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
								// �value� FIELD
								averageForestAreaForYear = jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
										.getAsDouble();

							System.out.println("Forest area for : " + year + " is " + averageForestAreaForYear+ " %");
							cummulativeValue = cummulativeValue + averageForestAreaForYear;
							yearValueHashMap.put(year, averageForestAreaForYear);
	}
		average = cummulativeValue/(Double.parseDouble(yearEnd) - Double.parseDouble(yearStart) + 1);
	System.out.println("Average forest Area percentage over the years is "+ average+ " %");

		
//		for(Entry<Integer, Double> set : yearValueHashMap.entrySet()) {
////			yearValueHashMap.replace(set.getKey(), set.getValue(), set.getValue()/cummulativeValue);
//		}
		
	}


//	public static void main(String[] args) {
//		new AverageForestArea("Canada");
//	}

}
