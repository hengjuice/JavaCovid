package comp3111.covid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.util.Pair;

import javafx.scene.control.TableColumn;




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import comp3111.covid.Chart;
import comp3111.covid.InputChecker;
import comp3111.covid.DataAnalysis;
import comp3111.covid.Country;
import comp3111.covid.TableEntry;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import comp3111.covid.DataAnalysis;


/** Represents the controller.
 */
public class Controller implements Initializable {

    @FXML
    private Button buttonConfirmedCases;

    @FXML
    private Button buttonConfirmedDeaths;

    @FXML
    private Button buttonRateOfVaccination;

    @FXML
    private ComboBox<String> comboBoxA1;

    
    // FOR CHARTS
    /** The start date picker for Chart A.
     */
    @FXML
    public DatePicker startDatePickerChartA;
    /** The start date picker for Chart B.
     */
    @FXML
    public DatePicker startDatePickerChartB;
    /** The start date picker for Chart C.
     */
    @FXML
    public DatePicker startDatePickerChartC;
    /** The end date picker for Chart A.
     */
    @FXML
    public DatePicker endDatePickerA;
    /** The end date picker for Chart B.
     */
    @FXML
    public DatePicker endDatePickerB;
    /** The end date picker for Chart C.
     */
    @FXML
    public DatePicker endDatePickerC;

    @FXML
    private DatePicker datePickerA;
    

    @FXML
    private DatePicker datePickerB;
    

    @FXML
    private DatePicker datePickerC;

    @FXML
    private Tab tabApp1;

    @FXML
    private Tab tabApp2;

    @FXML
    private Tab tabApp3;
    
    @FXML
    private Tab tabApp4;

    @FXML
    private Tab tabReport1;

    @FXML
    private Tab tabReport2;

    @FXML
    private Tab tabReport3;

    @FXML
    private Tab tabTaskZero;

    @FXML
    private TextField textfieldDataset;

    @FXML
    private TextField textfieldISO;
    
    @FXML
    private TableView<TableEntry> TableViewA;
    
    @FXML
    private TableView<TableEntry> TableViewB;
    
    @FXML
    private TableView<TableEntry> TableViewC;
  
    
    @FXML
    private TableView<TableEntry> TableViewD;
    
    @FXML
    private TableColumn<TableEntry, Float> casesPerMillionTableA;

    
    @FXML
    private TableColumn<TableEntry, Integer> casesPerMillionTableA;


    @FXML
    private TableColumn<TableEntry, Float> casesTableA;
    
    @FXML
    private TableColumn<TableEntry, String> countryTableA;
    
    @FXML
    private TableColumn<TableEntry, String> countryTableB;
    
    @FXML
    private TableColumn<TableEntry, Float> deathsPerMillionTableB;

    @FXML
    private TableColumn<TableEntry, Float> deathsTableB;
    
    @FXML
    private TableColumn<TableEntry, String> countryTableC;
    
    @FXML
    private TableColumn<TableEntry, Float> rateOfVaccinationsTableC;
    
    @FXML
    private TableColumn<TableEntry, Float> vaccinationsTableC;
    
    @FXML
    private TableColumn<TableEntry, String> countryTableD;
    
    @FXML
    private TableColumn<TableEntry, LocalDate> dateTableD;
    
    @FXML
    private TableColumn<TableEntry, Integer> newDeathsTableD;
    
    
    
    
    @Override
    /** Initialize the country checkboxes.
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
    	
    	countryTableA.setCellValueFactory(new PropertyValueFactory<TableEntry,String>("name"));
    	casesTableA.setCellValueFactory(new PropertyValueFactory<TableEntry,Float>("data1"));
    	casesPerMillionTableA.setCellValueFactory(new PropertyValueFactory<TableEntry,Float>("data2"));
    	
    	countryTableB.setCellValueFactory(new PropertyValueFactory<TableEntry,String>("name"));
    	deathsTableB.setCellValueFactory(new PropertyValueFactory<TableEntry,Float>("data1"));
    	deathsPerMillionTableB.setCellValueFactory(new PropertyValueFactory<TableEntry,Float>("data2"));
    	
    	countryTableC.setCellValueFactory(new PropertyValueFactory<TableEntry,String>("name"));
    	vaccinationsTableC.setCellValueFactory(new PropertyValueFactory<TableEntry,Float>("data1"));
    	rateOfVaccinationsTableC.setCellValueFactory(new PropertyValueFactory<TableEntry,Float>("data2"));
    	
    	countryTableD.setCellValueFactory(new PropertyValueFactory<TableEntry,String>("name"));
    	dateTableD.setCellValueFactory(new PropertyValueFactory<TableEntry, LocalDate>("data3"));
    	newDeathsTableD.setCellValueFactory(new PropertyValueFactory<TableEntry,Integer>("data2"));
    	
    	warningMessageA1.setText("");
    	warningMessageA1b.setText("");
    	
    	warningMessageB1.setText("");
    	warningMessageB1b.setText("");
    	
    	warningMessageC1.setText("");
    	warningMessageC1b.setText("");
    	
    	warningMessageD.setText("");
    	
    	String iDataset = textfieldDataset.getText();
    	ArrayList<String> countries = DataAnalysis.allCountriesArray(iDataset);
    	
    	for (int i = 0; i < countries.size(); i++) {
    		String country = countries.get(i);
    		checkCBA.getItems().add(country);
    		checkCBB.getItems().add(country);
    		checkCBC.getItems().add(country);
    		
    		checkCBA2.getItems().add(country);
    		checkCBB2.getItems().add(country);
    		checkCBC2.getItems().add(country);
    		
    		checkD.getItems().add(country);
    		
    	}
    	

    }

    @FXML
    private Button buttonChartA;
    @FXML
    private Button buttonChartB;
    @FXML
    private Button buttonChartC;
    
    @FXML
    private Button buttonTableA;

    @FXML
    private Button buttonTableB;

    @FXML
    private Button buttonTableC;
    
    @FXML
    private Button buttonTableD;
    // Tables


    

    
    
    // Charts
    @FXML
    private LineChart<String, Number> LineChartA;
    @FXML
    private LineChart<String, Number> LineChartB;
    @FXML
    private LineChart<String, Number> LineChartC;
    
    @FXML
    private CheckComboBox checkCBA;
    @FXML
    private CheckComboBox checkCBB;
    @FXML
    private CheckComboBox checkCBC;
    
    
    @FXML
    private CheckComboBox checkCBA2;
    @FXML
    private CheckComboBox checkCBB2;
    @FXML
    private CheckComboBox checkCBC2;
    @FXML
    private CheckComboBox checkD;
    
    @FXML
    private Label warningMessageA1;
    
    @FXML
    private Label warningMessageA1b;
    
    @FXML
    private Label warningMessageB1;

    @FXML
    private Label warningMessageB1b;
    
    @FXML
    private Label warningMessageC1;

    @FXML
    private Label warningMessageC1b;
    
    @FXML
    private Label titleTableA;

    @FXML
    private Label titleTableB;

    @FXML
    private Label titleTableC;

    /** The label to display warning messages for A2.
     */
    @FXML
    public Label warningMessageA2;
    /** The label to display warning messages for B2.
     */
    @FXML
    public Label warningMessageB2;
    /** The label to display warning messages for C2.
     */
    @FXML
    public Label warningMessageC2;
    
    
    @FXML
    private Label warningMessageD;
    
    @FXML
    void doConfirmedCases(ActionEvent event) {

    }

    @FXML
    void doConfirmedDeaths(ActionEvent event) {

    }

    @FXML
    void doRateOfVaccination(ActionEvent event) {

    }

    @FXML
    void generateTable(ActionEvent event) {
    	
    	TableViewA.getItems().clear();
    	warningMessageA1.setText("");
    	warningMessageA1b.setText("");
    	
    	LocalDate Date = datePickerA.getValue();
    	
    	if (Date == null) {
    		warningMessageA1.setText("no date selected");
    	}
    	
    	ObservableList list = checkCBA.getCheckModel().getCheckedItems();
    	
    	System.out.println(list.get(0));
    	//System.out.println("the date is " + Date);
    	
    	if (list.isEmpty() == true) {

    		System.out.println("no countries selected");
    		warningMessageA1b.setText("no countries selected");
    	}
    	
    	String iDataset = textfieldDataset.getText();
    	
    	for(Object obj : list) {	
    	Country country = new Country(obj.toString(), Date, "A1" , iDataset);
    	
    	
    	/*
    	ObservableList<TableEntry> listTable = FXCollections.observableArrayList(
    			new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue())
    			   			
    			);
    	
    	listTable.add(new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue()));
    	*/
    	
    	TableEntry newTableEntry = new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue());	
    	TableViewA.getItems().add(newTableEntry);
    	titleTableA.setText("Number of Confirmed COVID-19 Cases as of " + Date);
    	warningMessageA1b.setText("Beware: \"NaN\" or empty fields represents \"no data for this day\" ");
    	}

    }
    
    @FXML
    void generateTableB(ActionEvent event) {
    	
    	TableViewB.getItems().clear();
    	warningMessageB1.setText("");
    	warningMessageB1b.setText("");
    	
    	LocalDate Date = datePickerB.getValue();
    	
    	if (Date == null) {
    		warningMessageB1.setText("no date selected");
    	}
    	
    	ObservableList list = checkCBB.getCheckModel().getCheckedItems();
    	
    	System.out.println(list.get(0));
    	
    	if (list.isEmpty() == true) {
    		System.out.println("no countries selected");
    		warningMessageB1b.setText("no countries selected");
    	}
    	
    	String iDataset = textfieldDataset.getText();
    	
    	for(Object obj : list) {	
    	Country country = new Country(obj.toString(), Date, "B1" , iDataset);
    	
    	
    	/*
    	ObservableList<TableEntry> listTable = FXCollections.observableArrayList(
    			new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue())
    			   			
    			);
    	
    	listTable.add(new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue()));
    	*/
    	
    	TableEntry newTableEntry = new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue());	
    	TableViewB.getItems().add(newTableEntry);
    	titleTableB.setText("Number of Confirmed COVID-19 Deaths as of " + Date);
    	warningMessageB1b.setText("Beware: \"NaN\" or empty fields represents \"no data for this day\" ");
    	}
    }

    @FXML
    void generateTableC(ActionEvent event) {
    	
    	TableViewC.getItems().clear();
    	warningMessageC1.setText("");
    	warningMessageC1b.setText("");
    	
    	LocalDate Date = datePickerC.getValue();
    	
    	if (Date == null) {
    		warningMessageC1.setText("no date selected");

    		System.out.println("No countries are selected");

    	}
    	
    	ObservableList list = checkCBC.getCheckModel().getCheckedItems();
    	
    	System.out.println(list.get(0));
    	
    	if (list.isEmpty() == true) {
    		System.out.println("no countries selected");
    		warningMessageC1b.setText("no countries selected");
    	}
    	
    	String iDataset = textfieldDataset.getText();
    	
    	for(Object obj : list) {	
    	Country country = new Country(obj.toString(), Date, "C1" , iDataset);
    	
    	
    	/*
    	ObservableList<TableEntry> listTable = FXCollections.observableArrayList(
    			new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue())
    			   			
    			);
    	
    	listTable.add(new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue()));
    	*/
    	
    	TableEntry newTableEntry = new TableEntry(country.name,country.tabledatapoint.getKey() ,country.tabledatapoint.getValue());	
    	TableViewC.getItems().add(newTableEntry);
    	titleTableC.setText("Rate of Vaccination against COVID-19 as of " + Date);
    	warningMessageC1b.setText("Beware: \"NaN\" or empty fields represents \"no data for this day\" ");
    	}

    }
    @FXML
    void generateTableD(ActionEvent event) {
    	TableViewD.getItems().clear();
    	warningMessageD.setText("");
    	
    	LocalDate Date = datePickerC.getValue();
    	
    	if (Date == null) {
    		warningMessageD.setText("no date selected");

    		System.out.println("No countries are selected");

    	}
    	
    	ObservableList list = checkD.getCheckModel().getCheckedItems();
    	
    	System.out.println(list.get(0));
    	
    	if (list.isEmpty() == true) {
    		System.out.println("no countries selected");
    		warningMessageD.setText("no countries selected");
    		return;
    	}
    	
    	String iDataset = textfieldDataset.getText();
    	
    	for(Object obj : list) {	
	    	Country country = new Country(obj.toString(), "D" , iDataset);
	    	TableEntry newTableEntry = new TableEntry(country.name,country.tableDdatapoint.getKey() ,country.tableDdatapoint.getValue());	
	    	TableViewD.getItems().add(newTableEntry);
	    	warningMessageD.setText("");
    	}
    }
    
    @FXML
    void generateChartA(ActionEvent event) {
    	
    	System.out.println("Button is pressed "+ ((Button)event.getSource()).getText());
    	
    	// ENSURING THAT CHART IS EMPTIED FIRST
    	LineChartA.getData().clear();
    	warningMessageA2.setText("");
    	
    	// GETTING START DATES AND END DATES FROM USER INPUT
    	LocalDate startDate = startDatePickerChartA.getValue();
    	LocalDate endDate = endDatePickerA.getValue();

    	// CHECK INPUT VALIDITY using InputChecker Class
    	InputChecker inputChecker = new InputChecker(startDate, endDate);
    	inputChecker.chartInputValidityCheck();
    	
    	// If there are errors, graphs will not be generated
    	if (!inputChecker.error_statements.isEmpty()) {
    		StringBuilder errs = new StringBuilder();
    		for(String err: inputChecker.error_statements)
        	{
        		errs.append(err);
        		errs.append('\n');
        	}
    		warningMessageA2.setWrapText(true);
    		warningMessageA2.setText(errs.toString());
    		//Generate Error window
    		return;
    	}
    	
    	// If no countries are selected, graphs will not be generated
    	
    	
    	ObservableList list = checkCBA2.getCheckModel().getCheckedItems();
    	
    	if (list.isEmpty() == true) {
    		System.out.println("No countries are selected");
    		
    		warningMessageA2.setWrapText(true);
    		warningMessageA2.setText("No countries are selected");
    		return;
    	}
    	
    	//
    	
    	System.out.println("Error check completed");
    	
    	// Get Countries Value
    	/*
    	ArrayList<String> countries = new ArrayList<String>();
    	countries.add("Afghanistan");
    	*/
    	
    	
    	
    	String iDataset = textfieldDataset.getText();
    	
    	for(Object obj : list) {
    		
    	
    	Country country = new Country(obj.toString(), startDate, endDate, "A2" , iDataset);
    	
    	System.out.println(country.name);
    	
    	Series<String, Number> series = new XYChart.Series<String, Number>();
    	
    	for (Pair<LocalDate, Float> dp : country.chartdatapoints)
    	{
    		System.out.println("Adding datapoint into chart" + dp.getKey().toString());
    		series.getData().add(new XYChart.Data<String, Number>(dp.getKey().toString(), dp.getValue()));
    	}
    	series.setName(country.name);
//    	
    	LineChartA.getData().add(series);
    	LineChartA.getXAxis().setLabel("Date");
    	LineChartA.getYAxis().setLabel("Cumulative Cases");
    	LineChartA.getXAxis().setAnimated(false);
    	LineChartA.setTitle("Graph of Cumulative Cases Over Time");
    	}
    }
    
    @FXML
    void generateChartB(ActionEvent event) {
    	
    	
    	System.out.println("Button is pressed "+ ((Button)event.getSource()).getText());
    	
    	LineChartB.getData().clear();
    	warningMessageB2.setText("");
    	
    	LocalDate startDate = startDatePickerChartB.getValue();
    	LocalDate endDate = endDatePickerB.getValue();

    	// CHECK INPUT VALIDITY
    	
    	// Initialize InputChecker Object - will return any errors
    	InputChecker inputChecker = new InputChecker(startDate, endDate);
    	inputChecker.chartInputValidityCheck();
    	
    	// If there are errors, graphs will not be generated
    	if (!inputChecker.error_statements.isEmpty()) {
    		//inputChecker.printErrorStatements();
    		StringBuilder errs = new StringBuilder();
    		for(String err: inputChecker.error_statements)
        	{
        		errs.append(err);
        		errs.append('\n');
        	}
    		warningMessageB2.setWrapText(true);
    		warningMessageB2.setText(errs.toString());
    		//Generate Error window
    		return;
    	}
    	
    	// If no countries are selected, graphs will not be generated
    	
    	/* ADD CODE HERE */
    	
    	//
    	
    	ObservableList list = checkCBB2.getCheckModel().getCheckedItems();
    	
    	if (list.isEmpty() == true) {
    		System.out.println("No countries are selected");
    		
    		warningMessageB2.setWrapText(true);
    		warningMessageB2.setText("No countries are selected");
    		return;
    	}
    	
    	System.out.println("Error check completed");
    	
    	// Get Countries Value

    	
    	String iDataset = textfieldDataset.getText();
    	
    	for(Object obj : list) {
    	Country country = new Country(obj.toString(), startDate, endDate, "B2" , iDataset);
    	
    	System.out.println(country.name);
    	
    	Series<String, Number> series = new XYChart.Series<String, Number>();
    	
    	for (Pair<LocalDate, Float> dp : country.chartdatapoints)
    	{
    		System.out.println("Adding datapoint into chart" + dp.getKey().toString());
    		series.getData().add(new XYChart.Data<String, Number>(dp.getKey().toString(), dp.getValue()));
    	}
    	series.setName(country.name);
//    	
    	LineChartB.getData().add(series);
    	LineChartB.getXAxis().setLabel("Date");
    	LineChartB.getYAxis().setLabel("Cumulative Deaths");
    	LineChartB.getXAxis().setAnimated(false);
    	LineChartB.setTitle("Graph of Cumulative Deaths Over Time");
    	}

    }
    
    
    
    @FXML
    void generateChartC(ActionEvent event) {
    	
    	System.out.println("Button is pressed "+ ((Button)event.getSource()).getText());
    	
    	LineChartC.getData().clear();
    	warningMessageB2.setText("");

    	
    	LocalDate startDate = startDatePickerChartC.getValue();
    	LocalDate endDate = endDatePickerC.getValue();

    	// CHECK INPUT VALIDITY
    	
    	// Initialize InputChecker Object - will return any errors
    	InputChecker inputChecker = new InputChecker(startDate, endDate);
    	inputChecker.chartInputValidityCheck();
    	
    	// If there are errors, graphs will not be generated
    	if (!inputChecker.error_statements.isEmpty()) {
    		//inputChecker.printErrorStatements();
    		StringBuilder errs = new StringBuilder();
    		for(String err: inputChecker.error_statements)
        	{
        		errs.append(err);
        		errs.append('\n');
        	}
    		warningMessageC2.setWrapText(true);
    		warningMessageC2.setText(errs.toString());
    		//Generate Error window
    		return;
    	}
    	

    	ObservableList list = checkCBC2.getCheckModel().getCheckedItems();
    	
    	if (list.isEmpty() == true) {
    		System.out.println("No countries are selected");
    		
    		warningMessageB2.setWrapText(true);
    		warningMessageB2.setText("No countries are selected");
    		return;
    	}
    	

    	System.out.println("Error check completed");
    	
    	// Get Countries Value

    	
    	String iDataset = textfieldDataset.getText();
    	
    	for(Object obj : list) {
    	Country country = new Country(obj.toString(), startDate, endDate, "C2" , iDataset);
    	
    	System.out.println(country.name);
    	
    	Series<String, Number> series = new XYChart.Series<String, Number>();
    	
    	for (Pair<LocalDate, Float> dp : country.chartdatapoints)
    	{
    		System.out.println("Adding datapoint into chart" + dp.getKey().toString());
    		series.getData().add(new XYChart.Data<String, Number>(dp.getKey().toString(), dp.getValue()));
    	}
    	series.setName(country.name);
    	LineChartC.getData().add(series);;
    	LineChartC.getXAxis().setLabel("Date");
    	LineChartC.getYAxis().setLabel("% Vaccinated");
    	LineChartC.getXAxis().setAnimated(false);
    	LineChartC.setTitle("Graph of Vaccination Rate Over Time");
    	}
    }
}

