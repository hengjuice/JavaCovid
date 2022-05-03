package comp3111.covid;

import java.time.LocalDate;

/** Represents an entry in a table
 */
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
	
	/** Get name of country
	 * @return name of country
	 */
	public String getName() {
		return name;
	}
	/** Get Data1
	 * @return the float data value
	 */
	public Float getData1() {
		return data1;
	}
	/** Get Data2
	 * @return the float data value
	 */
	public Float getData2() {
		return data2;
	}
	/** Get Data3
	 * @return the LocalDate data value
	 */
	public LocalDate getData3() {
		return data3;
	}
}
