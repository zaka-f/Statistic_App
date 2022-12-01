package performing_analyses;

import java.util.HashMap;
import java.util.Map.Entry;

import com.google.gson.JsonArray;

public class CO2EmissionsVsEnergyUseVsPM25AirPollutionMEA extends SuperClassGetData {

	private String country;
	private String yearStart;
	private String yearEnd;

	private String urlStringCO2;

	private String urlStringEnergy;

	private JsonArray jsonArrayCO2;

	private JsonArray jsonArrayEnergy;

	private HashMap<Integer, Double> yearValueHashMapCO2;
	private double cummulativeValueCO2;

	private HashMap<Integer, Double> yearValueHashMapEnergy;
	private double cummulativeValueEnergy;

	private String urlStringPM25;
	private JsonArray jsonArrayPM25;
	private HashMap<Integer, Double> yearValueHashMapPM25;
	private double cummulativeValuePM25;

	CO2EmissionsVsEnergyUseVsPM25AirPollutionMEA(String country) {
		this.country = country;
		this.country = setCountryCode(country);
		yearStart = updateStartYear();
		yearEnd = updateEndYear();

		urlStringCO2 = setURL(this.country, yearStart, yearEnd, "EN.ATM.CO2E.PC");
		this.jsonArrayCO2 = retreiveData(urlStringCO2);
		yearValueHashMapCO2 = new HashMap<Integer, Double>();

		System.out.println();
		System.out.println("CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita)");
		System.out.println();

		processDataCO2();

		urlStringEnergy = setURL(this.country, yearStart, yearEnd, "EG.USE.PCAP.KG.OE");
		this.jsonArrayEnergy = retreiveData(urlStringEnergy);
		yearValueHashMapEnergy = new HashMap<Integer, Double>();

		processDataEnergy();

		urlStringPM25 = setURL(this.country, yearStart, yearEnd, "EN.ATM.PM25.MC.M3");
		this.jsonArrayPM25 = retreiveData(urlStringPM25);
		yearValueHashMapPM25 = new HashMap<Integer, Double>();

		processDataPM25();
		
		processVS();

	}

	private void processDataCO2() {
		double cO2ForYear = 0;
		cummulativeValueCO2 = 0;
		int size = jsonArrayCO2.size();
		int sizeOfResults = jsonArrayCO2.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			// GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
			year = jsonArrayCO2.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();

			// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
			// GIVEN YEAR
			if (jsonArrayCO2.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
				cO2ForYear = 0;
			else
				// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
				// “value” FIELD
				cO2ForYear = jsonArrayCO2.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

			System.out.println("CO2 emissions (metric tons per capita) for: " + year + " is " + cO2ForYear
					+ " metric tons per capita");
			cummulativeValueCO2 = cummulativeValueCO2 + cO2ForYear;
			yearValueHashMapCO2.put(year, cO2ForYear);
		}
	}

	private void processDataEnergy() {

		double EnergyForYear = 0;
		cummulativeValueEnergy = 0;
		int size = jsonArrayEnergy.size();
		int sizeOfResults = jsonArrayEnergy.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			// GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
			year = jsonArrayEnergy.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();

			// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
			// GIVEN YEAR
			if (jsonArrayEnergy.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
				EnergyForYear = 0;
			else
				// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
				// “value” FIELD
				EnergyForYear = jsonArrayEnergy.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value")
						.getAsDouble();

			System.out.println("Energy use (kg of oil equivalent per capita) for: " + year + " is " + EnergyForYear
					+ " kg of oil equivalent per capita");
			cummulativeValueEnergy = cummulativeValueEnergy + EnergyForYear;
			yearValueHashMapEnergy.put(year, EnergyForYear);
		}
	}

	private void processDataPM25() {
		double pM25ForYear = 0;
		cummulativeValuePM25 = 0;
		int size = jsonArrayPM25.size();
		int sizeOfResults = jsonArrayPM25.get(1).getAsJsonArray().size();
		int year = 0;
		for (int i = 0; i < sizeOfResults; i++) {
			// GET FOR EACH ENTRY THE YEAR FROM THE “date” FIELD
			year = jsonArrayPM25.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt();

			// CHECK IF THERE IS A VALUE FOR THE POPULATION FOR A
			// GIVEN YEAR
			if (jsonArrayPM25.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull())
				pM25ForYear = 0;
			else
				// GET THE POPULATION FOR THE GIVEN YEAR FROM THE
				// “value” FIELD
				pM25ForYear = jsonArrayPM25.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble();

			System.out.println("PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) for: " + year
					+ " is " + pM25ForYear + " micrograms per cubic meter");
			cummulativeValuePM25 = cummulativeValuePM25 + pM25ForYear;
			yearValueHashMapPM25.put(year, pM25ForYear);
		}
	}

	private void processVS() {
		for(Entry<Integer, Double> set : yearValueHashMapCO2.entrySet()) {
	
			System.out.println(set.getKey() + " is " + set.getValue()+ " metric tons per capita for CO2 emissions vs "+yearValueHashMapEnergy.get(set.getKey())+
					" kg of oil equivalent per capita for Energy Use vs "+ yearValueHashMapPM25.get(set.getKey())+" micrograms per cubic meter");

}
		
	}

}
