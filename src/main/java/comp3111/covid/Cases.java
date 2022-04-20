package comp3111.covid;

public class Cases {
	private int daily_cases;
	private int total_cases;
	private double cases_per_mil;
	public Cases() {
		daily_cases=0;
		total_cases=0;
		cases_per_mil=0;
	}
	public int getCases() {return daily_cases;}
	public int getTotal() {return total_cases;}
	public double getCPM() {return cases_per_mil;}
	public void addCases(int _daily_cases) {
		if (_daily_cases<=total_cases) {
			daily_cases=_daily_cases;}
		}
	public void addTotal(int _total_cases) {total_cases=_total_cases;}
	public void addCPM(double _cases_per_mil) {cases_per_mil=_cases_per_mil;}
	public void calcCPM(int population) {
		if(population>total_cases) {
		cases_per_mil=total_cases*1000000/(float)population;}}
}
