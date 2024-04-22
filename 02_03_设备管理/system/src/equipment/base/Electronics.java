package equipment.base;

public  class Electronics {
	public String name = "0";
	private double weight = 0;
	private int price = 0;
	private int consumption = 0;
	private String maker = "0";
	public Electronics (String initialName,double initialweight, int initialprice, int initialconsumption, String initialmaker){
		name = initialName;
		weight = initialweight;
		price = initialprice;
		consumption = initialconsumption;
		maker = initialmaker;
	}
	
	public String getName() {
		return name;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getPrice() {
		return price;
	}
	

	
	public int getConsumption() {
		return consumption;
	}
	
	public String getMaker() {
		return maker;
	}
	

}
