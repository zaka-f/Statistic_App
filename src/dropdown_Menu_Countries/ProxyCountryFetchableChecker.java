package dropdown_Menu_Countries;

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

	// function that checks whether the user exists or not in the file
	public String getFetchable() {
		return checker.getFetchable();
	}

	boolean isFetchable() {
		if (getFetchable().equals("true"))
			return true;
		else
			return false;

	}

}
