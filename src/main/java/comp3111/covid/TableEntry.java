package comp3111.covid;

public class TableEntry {
	String name;
	Integer data1;
	Integer data2;
	
	TableEntry(String name, Integer data1, Integer data2){
		this.name=name;
		this.data1=data1;
		this.data2=data2;
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getData1() {
		return data1;
	}
	
	public Integer getData2() {
		return data2;
	}
}
