/*************************************************
 * FALL 2022
 * EECS 3311 GUI SAMPLE CODE
 * ONLT AS A REFERENCE TO SEE THE USE OF THE jFree FRAMEWORK
 * THE CODE BELOW DOES NOT DEPICT THE DESIGN TO BE FOLLOWED 
 */

package mainUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import analyses.DropdownMenuAnalysesAction;
import countries.DropDownMenuCountriesAction;
import renderingResults.RenderingResultAction;
import viewers.OnClickViewersActionAdd;
import viewers.OnClickViewersActionRemove;
import viewers.newChartPanel;
import years.YearFromAction;
import years.YearToAction;

public class MainUI extends JFrame {

	private static MainUI instance;

	private static JComboBox<String> countriesList;

	private static JComboBox<String> methodsList;

	private static JComboBox<String> fromList;

	private static JComboBox<String> toList;

	private static JComboBox<String> viewsList;

	private static JPanel center;

	public static JPanel getCenter() {
		return center;
	}

	public static void setCenter(JPanel center) {
		MainUI.center = center;
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

		fromList.addActionListener(new YearFromAction());

		toList.addActionListener(new YearToAction());

		JPanel north = new JPanel();
		north.add(chooseCountryLabel);
		north.add(countriesList);
		north.add(from);
		north.add(fromList);
		north.add(to);
		north.add(toList);

		// Set bottom bar
		JButton recalculate = new JButton("Recalculate");
		recalculate.addActionListener(new RenderingResultAction());

		JLabel viewsLabel = new JLabel("Available Views: ");

		Vector<String> viewsNames = new Vector<String>();
		viewsNames.add("Pie Chart");
		viewsNames.add("Line Chart");
		viewsNames.add("Bar Chart");
		viewsNames.add("Scatter Chart");
		viewsNames.add("Report");
		viewsNames.add("Time Series");
		viewsList = new JComboBox<String>(viewsNames);
		JButton addView = new JButton("+");
		addView.addActionListener(new OnClickViewersActionAdd());
		JButton removeView = new JButton("-");
		removeView.addActionListener(new OnClickViewersActionRemove());

		JLabel methodLabel = new JLabel("        Choose analysis method: ");

		Vector<String> methodsNames = new Vector<String>();
		methodsNames.add("Current Health Expenditure %");
		methodsNames.add("Govt Expenditure on Education vs Health Expenditure % change");
		methodsNames.add("CO2 Emissions vs Energy Use vs PM 2.5 Air Pollution(MEA) % change");
		methodsNames.add("CO2 Emissions vs GDP Ratio");
		methodsNames.add("Average Govt Expenditure on Education %(of GDP)");
		methodsNames.add("Average Forest Area %");

		methodsList = new JComboBox<String>(methodsNames);
		methodsList.addActionListener(new DropdownMenuAnalysesAction());

		JPanel south = new JPanel();
		south.add(viewsLabel);
		south.add(viewsList);
		south.add(addView);
		south.add(removeView);

		south.add(methodLabel);
		south.add(methodsList);
		south.add(recalculate);

		// Set charts region
		center = new JPanel();
		center.setLayout(new GridLayout(2, 0));

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(center, BorderLayout.CENTER);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1200, 700));
		setLocation(100, 100);
		pack();
		setVisible(true);
	}

}