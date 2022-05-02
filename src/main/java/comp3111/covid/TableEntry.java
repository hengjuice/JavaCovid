package comp3111.covid;

public class TableEntry {
	String name;
	Float data1;
	Float data2;
	
	TableEntry(String name, Float data1, Float data2){
		this.name=name;
		this.data1=data1;
		this.data2=data2;
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
}
