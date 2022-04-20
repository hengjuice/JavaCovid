package comp3111.covid;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import comp3111.covid.Chart;
import comp3111.covid.InputChecker;
import comp3111.covid.DataAnalysis;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckComboBox;

import comp3111.covid.DataAnalysis;



public class Controller implements Initializable {

    @FXML
    private Button buttonConfirmedCases;

    @FXML
    private Button buttonConfirmedDeaths;

    @FXML
    private Button buttonRateOfVaccination;

    @FXML
    private ComboBox<String> comboBoxA1;
    public DatePicker endDatePicker;

    @FXML
    public DatePicker startDatePicker;

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
    		
    		checkCBA.getItems().add(countries.get(i));
    		checkCBB.getItems().add(countries.get(i));
    		checkCBC.getItems().add(countries.get(i));
    		
    		checkCBA2.getItems().add(countries.get(i));
    		checkCBB2.getItems().add(countries.get(i));
    		checkCBC2.getItems().add(countries.get(i));
    		
    	}
    	

    }
    

    
//    public void initializeComboBox (URL url, ResourceBundle resourceBundle) {
//    	String iDataset = textfieldDataset.getText();
//    	ArrayList<String> countries = DataAnalysis.allCountriesArray(iDataset);
//    	
//    	
//    	for (int i = 0; i < countries.size(); i++) {
//    		
//    		comboBoxA1.getItems().add(countries.get(i));
//    	}
//    }
  

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
    void doConfirmedCases(ActionEvent event) {

    }

    @FXML
    void doConfirmedDeaths(ActionEvent event) {

    }

    @FXML
    void doRateOfVaccination(ActionEvent event) {
    	
    }
    
	@FXML
    LocalDate saveStartDate(ActionEvent event) {
    	LocalDate startDate = startDatePicker.getValue();
    	
    	// TEST
    	String formattedStartDate = startDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    	System.out.println(formattedStartDate);
    	
    	
    	return startDate;
    }
    
    @FXML
    LocalDate saveEndDate(ActionEvent event) {
    	LocalDate endDate = endDatePicker.getValue();
    	
    	// TEST
    	String formattedEndDate = endDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    	System.out.println(formattedEndDate);
    	
    	return endDate;
    }

    @FXML
    void generateTable(ActionEvent event) {
    }
    
    @FXML
    void generateChart(ActionEvent event) {
    	
    	//String ID = (String) event.getSource();
    	
    	LocalDate startDate = startDatePicker.getValue();
    	
    	LocalDate endDate = endDatePicker.getValue();

    	// CHECK INPUT VALIDITY
    	
    	// Initialize InputChecker Object - will return any errors
    	InputChecker inputChecker = new InputChecker(startDate, endDate);
    	inputChecker.chartInputValidityCheck();
    	
    	// If there are errors, graphs will not be generated
    	if (!inputChecker.error_statements.isEmpty()) {
    		inputChecker.printErrorStatements();
    		//Generate Error window
    		return;
    	}
    	
    	


    	
    	
    	// Get Countries Value
    	ArrayList<String> countries = new ArrayList<String>();
    	countries.add("Afghanistan");
    	
    	// Initialize Chart Object
    	//Chart chart = new Chart(ID, startDate, endDate, countries);
    	Series<String, Number> series = new XYChart.Series<String, Number>();
    	series.getData().add(new XYChart.Data<String, Number>("Jan", 100));
    	series.getData().add(new XYChart.Data<String, Number>("Feb", 60));
    	series.getData().add(new XYChart.Data<String, Number>("Mar", 40));
    	series.getData().add(new XYChart.Data<String, Number>("Apr", 150));
    	series.getData().add(new XYChart.Data<String, Number>("May", 90));
    	series.setName("No of cases");
    	
    	LineChartA.getData().add(series);
    	
    	
    	/*
    	
    	for every country selected from combobox:
    		add data from start date till end date into series
    			plot the graph of that country's series
    	
    	 */
    }
    
    
    

}
