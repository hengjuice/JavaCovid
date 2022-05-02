package comp3111.covid;

import java.time.LocalDate;

public class TableEntry {
	String name;

	Float data1;
	Float data2;


	LocalDate data3;

	
	TableEntry(String name, Float data1, Float data2){
		this.name=name;
		this.data1=data1;
		this.data2=data2;
	}
	TableEntry(String name, LocalDate data3, Float data2){
		this.name = name;
		this.data3 = data3;
		this.data2 = data2;
	}
	
	
	public String getName() {
		return name;
	}
	
	public Float getData1() {
		return data1;
	}
	
	public Float getData2() {
		return data2;
	}
	
	public LocalDate getData3() {
		return data3;
	}
}
