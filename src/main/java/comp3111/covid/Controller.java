package comp3111.covid;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
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
    		
    		comboBoxA1.getItems().add(countries.get(i));
    	}
    	

    }
  

    @FXML
    private Button buttonChartA;
    @FXML
    private Button buttonChartB;
    @FXML
    private Button buttonChartC;


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
    void generateChart(ActionEvent event) {
    	
    	//String ID = (String) event.getSource();
    	
    	LocalDate startDate = startDatePicker.getValue();
    	
    	LocalDate endDate = endDatePicker.getValue();

    	// CHECK INPUT VALIDITY
    	
    	// Initialize InputChecker Object - will return any errors
    	InputChecker inputChecker = new InputChecker(startDate, endDate);
    	inputChecker.inputValidityCheck();
    	
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
    	
    	
    }
    
    
    

}
