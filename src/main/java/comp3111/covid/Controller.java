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
import javafx.scene.text.Text;
import javafx.util.Pair;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import comp3111.covid.Chart;
import comp3111.covid.InputChecker;
import comp3111.covid.DataAnalysis;
import comp3111.covid.Country;

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
    @FXML
    public DatePicker startDatePickerChartA;
    @FXML
    public DatePicker startDatePickerChartB;
    @FXML
    public DatePicker startDatePickerChartC;
    @FXML
    public DatePicker endDatePickerA;
    @FXML
    public DatePicker endDatePickerB;
    @FXML
    public DatePicker endDatePickerC;

    @FXML
    private DatePicker datePickerA;

    @FXML
    private Tab tabApp1;

    @FXML
    private Tab tabApp2;

    @FXML
    private Tab tabApp3;

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
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
    
    // Tables
    @FXML
    private TableView TableViewA;
    @FXML
    private TableView TableViewB;
    @FXML
    private TableView TableViewC;
    
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
    public Label warningMessageA2;
    @FXML
    public Label warningMessageB2;
    @FXML
    public Label warningMessageC2;
    
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
    	
    	LocalDate Date = datePickerA.getValue();
    	
    	ObservableList list = checkCBA.getCheckModel().getCheckedItems();
    	
    	if (list.isEmpty() == true) {
    		System.out.println("no countries selected");
    	}
 
    	//for testing
    	System.out.println(list.get(0));
    	
    	for(Object obj : list)
    		System.out.println(obj.toString());
    }
    
    @FXML
    void generateChartA(ActionEvent event) {
    	
    	System.out.println("Button is pressed "+ ((Button)event.getSource()).getText());
    	
    	// ENSURING THAT CHART IS EMPTIED FIRST
    	LineChartA.getData().clear();
    	
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
    	
    	
    	//
    	
    	System.out.println("Error check completed");
    	
    	// Get Countries Value
    	ArrayList<String> countries = new ArrayList<String>();
    	countries.add("Afghanistan");
    	
    	
    	
    	String iDataset = textfieldDataset.getText();
    	Country country = new Country("Afghanistan", startDate, endDate, "A2" , iDataset);
    	
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

    }
    
    @FXML
    void generateChartB(ActionEvent event) {
    	
    	System.out.println("Button is pressed "+ ((Button)event.getSource()).getText());
    	LineChartB.getData().clear();
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
    	
    	System.out.println("Error check completed");
    	
    	// Get Countries Value
    	ArrayList<String> countries = new ArrayList<String>();
    	countries.add("Afghanistan");
    	
    	String iDataset = textfieldDataset.getText();
    	Country country = new Country("Afghanistan", startDate, endDate, "B2" , iDataset);
    	
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

    }
    
    @FXML
    void generateChartC(ActionEvent event) {
    	
    	System.out.println("Button is pressed "+ ((Button)event.getSource()).getText());
    	LineChartC.getData().clear();
    	
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
    	
    	System.out.println("Error check completed");
    	
    	// Get Countries Value
    	ArrayList<String> countries = new ArrayList<String>();
    	countries.add("Afghanistan");
    	
    	String iDataset = textfieldDataset.getText();
    	Country country = new Country("Afghanistan", startDate, endDate, "C2" , iDataset);
    	
    	System.out.println(country.name);
    	
    	Series<String, Number> series = new XYChart.Series<String, Number>();
    	
    	for (Pair<LocalDate, Float> dp : country.chartdatapoints)
    	{
    		System.out.println("Adding datapoint into chart" + dp.getKey().toString());
    		series.getData().add(new XYChart.Data<String, Number>(dp.getKey().toString(), dp.getValue()));
    	}
    	series.setName(country.name);
    	LineChartC.getData().add(series);

    }

}
