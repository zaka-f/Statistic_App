package performing_analyses;

import mainUI.MainUI;

//Here Factory Design Pattern
public class FactoryGetData {

	String country = (String)MainUI.getCountriesList().getSelectedItem();
	
	public SuperClassGetData getData(String analysis) {
		if (analysis == null || analysis.isEmpty())
			return null;
		switch (analysis) {
		case "Average Forest Area %":
			return new AverageForestArea(country);
		case "Current Health Expenditure %":
			return new CurrentHealthExpenditurePercentage(country);
		case "CO2 Emissions vs GDP Ratio":
			return new CO2EmissionsvsGDPRatio(country);
		case "Average Govt Expenditure on Education %(of GDP)":
			return new AverageGovtExpenditureOnEducationPercentageOfGDP(country);
		case "Govt Expenditure on Education vs Health Expenditure %":
			return new GovtExpenditureonEducatiOnVsHealthExpenditurePercentage(country);
		case "CO2 Emissions vs Energy Use vs PM 2.5 Air Pollution(MEA)":
			return new CO2EmissionsVsEnergyUseVsPM25AirPollutionMEA(country);
		default:
			throw new IllegalArgumentException("Unknown analysis " + analysis);
		}

	}
	
}
