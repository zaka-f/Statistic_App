/*************************************************
 * FALL 2022
 * EECS 3311 GUI SAMPLE CODE
 * ONLT AS A REFERENCE TO SEE THE USE OF THE jFree FRAMEWORK
 * THE CODE BELOW DOES NOT DEPICT THE DESIGN TO BE FOLLOWED 
 */

package mainUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Dropdown_Menu_Years.Year_From_Action;
import Dropdown_Menu_Years.Year_To_Action;
import dropdown_Menu_Analyses.Dropdown_Menu_Analyses_Action;
import dropdown_Menu_Countries.DropDownMenuCountriesAction;
import viewers.On_Click_Viewers;

public class MainUI extends JFrame {

	private static MainUI instance;

	private static JComboBox<String> countriesList;

	private static JComboBox<String> methodsList;

	private static JComboBox<String> fromList;

	private static JComboBox<String> toList;

	private static JComboBox<String> viewsList;
	
	private static JPanel west ;

	public static JPanel getWest() {
		return west;
	}

	public static void setWest(JPanel west) {
		MainUI.west = west;
	}

	public static JComboBox<String> getViewsList() {
		return viewsList;
	}

	public static void setViewsList(JComboBox<String> viewsList) {
		MainUI.viewsList = viewsList;
	}

	public static JComboBox<String> getMethodsList() {
		return methodsList;
	}

	public static void setMethodsList(JComboBox<String> methodsList) {
		MainUI.methodsList = methodsList;
	}

	public static JComboBox<String> getFromList() {
		return fromList;
	}

	public static void setFromList(JComboBox<String> fromList) {
		MainUI.fromList = fromList;
	}

	public static JComboBox<String> getToList() {
		return toList;
	}

	public static void setToList(JComboBox<String> toList) {
		MainUI.toList = toList;
	}

	public static JComboBox<String> getCountriesList() {
		return countriesList;
	}

	public void setCountriesList(JComboBox<String> countriesList) {
		this.countriesList = countriesList;
	}

	// Singeleton Design pattern is being used here
	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	public MainUI() {
		// Set window title
		super("Country Statistics");

		// Set top bar
		JLabel chooseCountryLabel = new JLabel("Choose a country: ");
		Vector<String> countriesNames = new Vector<String>();
		countriesNames.add("USA");
		countriesNames.add("Canada");
		countriesNames.add("France");
		countriesNames.add("China");
		countriesNames.add("Brazil");
		countriesNames.sort(null);
		countriesList = new JComboBox<String>(countriesNames);
		countriesList.addActionListener(new DropDownMenuCountriesAction());

		JLabel from = new JLabel("From");
		JLabel to = new JLabel("To");
		Vector<String> years = new Vector<String>();
		for (int i = 2021; i >= 2010; i--) {
			years.add("" + i);
		}
		fromList = new JComboBox<String>(years);
		toList = new JComboBox<String>(years);

		fromList.addActionListener(new Year_From_Action());

		toList.addActionListener(new Year_To_Action());

		JPanel north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);

		// Set bottom bar
		JButton recalculate = new JButton("Recalculate");

		JLabel viewsLabel = new JLabel("Available Views: ");

		Vector<String> viewsNames = new Vector<String>();
		viewsNames.add("Pie Chart");
		viewsNames.add("Line Chart");
		viewsNames.add("Bar Chart");
		viewsNames.add("Scatter Chart");
		viewsNames.add("Report");
		viewsList = new JComboBox<String>(viewsNames);
		JButton addView = new JButton("+");
		addView.addActionListener(new On_Click_Viewers());
		JButton removeView = new JButton("-");

		JLabel methodLabel = new JLabel("        Choose analysis method: ");

		Vector<String> methodsNames = new Vector<String>();
		methodsNames.add("Total Population");
		methodsNames.add("Total Population vs Forest Area");
		methodsNames.add(
				"Total Population vs Access To Electricity from Clean Energy & Electricity Production from Coal Sources");
		methodsNames.add("Energy Use vs GDP");
		methodsNames.add("Forest Area vs GDP");
		methodsNames.add("Forest Area");

		methodsList = new JComboBox<String>(methodsNames);
		methodsList.addActionListener(new Dropdown_Menu_Analyses_Action());

		JPanel south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(methodsList);
		south.add(recalculate);

		JPanel east = new JPanel();

		// Set charts region
		JPanel west = new JPanel();
		west.setLayout(new GridLayout(2, 0));

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);

		setSize(900, 600);
		pack();
		setVisible(true);
	}

}