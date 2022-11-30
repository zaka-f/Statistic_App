package countries;

import org.json.simple.JSONArray;

//Here Proxy Design Pattern was used

public class ProxyCountryFetchableChecker implements CountryFetchableDataRetreiver {
	
	// instance variables
	private String country;
	private CountryFetchableChecker checker;
	private JSONArray data;

	// constructor
	protected ProxyCountryFetchableChecker(String country) {
		this.country = country;
		checker = new CountryFetchableChecker(country);
	}

	@Override
	public void ExtractData() {
		checker.ExtractData();
	}

	// function that checks rthe country is fetchable
	public String getFetchable() {
		return checker.getFetchable();
	}

	//returns a boolean depending on if the country is fetchable
	boolean isFetchable() {
		if (getFetchable().equals("true"))
			return true;
		else
			return false;

	}

}
