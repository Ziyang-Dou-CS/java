package equipment.base;

public class 	Phone extends Electronics{
	private String system = "0";
	private int storage = 0;
	
	public Phone(String initialname,double initialweight, int initialprice, int initialconsumption, String initialmaker, String initialsystem, int initialstorage) {
		super(initialname,initialweight, initialprice, initialconsumption, initialmaker);
		// TODO 自动生成的构造函数存根
		system = initialsystem;
		storage = initialstorage;
	}
	
	public String getSystem() {
		return system;
	}
	
	public void setSystem(String newsystem) {
		system = newsystem;
	}
	
	public int getStorage() {
		return storage;
	}
	
	public void setStorage(int newstorage) {
		storage = newstorage;
	}
	
	public  void showMyElectronics() {
		System.out.println("设备名："+getName()+"重量："+getWeight()+"价格："+getPrice()+"耗电量："+getConsumption()+"制造商："+getMaker()+"系统："+getSystem()+"储存："+getStorage());
	}
}
