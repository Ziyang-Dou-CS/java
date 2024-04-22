package equipment.base;

public class Computer extends Electronics{
	private int memory = 0;
	private String cpu = "0";
	public Computer(String initialName, double initialweight, int initialprice, int initialconsumption,
			String initialmaker, int initialmemory, String initialcpu) {
		super(initialName, initialweight, initialprice, initialconsumption, initialmaker);
		// TODO 自动生成的构造函数存根
		memory = initialmemory;
		cpu = initialcpu;
	}
	
	public int getMemory() {
		return memory;
	}
	
	public void setMemory(int newmemory) {
		memory = newmemory;
	}
	
	public String getCpu() {
		return cpu;
	}
	
	public void setCpu(String newcpu) {
		cpu = newcpu;
	}
	
	public  void showMyElectronics() {
		// TODO 自动生成的方法存根
		System.out.println("设备名："+getName()+"重量："+getWeight()+"价格："+getPrice()+"耗电量："+getConsumption()+"制造商："+getMaker()+"内存："+getMemory()+"cpu型号："+getCpu());
	}
}
