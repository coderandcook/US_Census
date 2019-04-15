
public class State {
	//copied from csv file
	private int[] popByYear;//index 0 points to population in the first year
	private String name;
	private double[] percentage;
	//percentage change between year1 and year2
	private double per;
	
	public int[] getPopByYear() {
		return popByYear;
	}
	public void setPopByYear(int[] popByYear) {
		this.popByYear = popByYear;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[] getPercentage() {
		return percentage;
	}
	public void setPercentage(double[] percentage) {
		this.percentage=percentage;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double year1, double year2) {
		
		
		double temp=((year2-year1)/year1)*100;
		this.per=temp;
	}
	
	public State() {
		
	}

}
