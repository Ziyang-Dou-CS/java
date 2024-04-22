package equipment.application;

import java.util.*;
import equipment.base.*;


public class UseElectronics {
	public static Vector<Computer> computers = new Vector<Computer>();
	public static Vector<Phone> phones = new Vector<Phone>();
	public static Scanner reader = new Scanner(System.in);
	public static void addInformation(){
		int choice1=1;
		int choice2=1;
		String name = "0";
		double weight = 0;
		int price = 0;
		int consumption = 0;
		String maker = "0";
		int memory;
		String cpu;
		String system;
		int storage;
		System.out.println("请输入你的>电脑<设备参数：\n" +
				"格式为：设备名称 重量 价格 耗电量 制造商 内存 cpu型号");
		System.out.println("如果不添加，请输入‘0’；若要添加请输入‘1’");
		choice1=reader.nextInt();
		if(choice1!=0) {
			name = reader.next();
			weight = reader.nextInt();
			price = reader.nextInt();
			consumption = reader.nextInt();
			maker = reader.next();
			memory = reader.nextInt();
			cpu = reader.next();
			Computer computer = new Computer(name, weight, price, consumption, maker, memory, cpu);
			computers.add(computer);
		}
		System.out.println("请输入你的>手机<设备参数：\n" +
				"格式为：设备名称 重量 价格 耗电量 制造商 系统类型 存储空间");
		System.out.println("如果不添加，请输入‘0’；若要添加请输入‘1’");
		choice2=reader.nextInt();
		if(choice2!=0) {
			name = reader.next();
			weight = reader.nextInt();
			price = reader.nextInt();
			consumption = reader.nextInt();
			maker = reader.next();
			system = reader.next();
			storage = reader.nextInt();
			Phone phone = new Phone(name, weight, price, consumption, maker, system, storage);
			phones.add(phone);
		}
	}
	public static void showAll() {


		if(computers.isEmpty()){
			System.out.println("please add information for comoputer !");
		}else{
			System.out.println("computer information:");
             for(Computer computer : computers){
                      computer.showMyElectronics();
					  System.out.println("");
			 }
		}
		if(phones.isEmpty()){
			System.out.println("please add information for phone !");
		}else {
			System.out.println("phone information:");
			for (Phone phone : phones) {
				phone.showMyElectronics();
				System.out.println("");
			}
		}
	}
	public static void find(){
           int choice;
		   System.out.println("please imput one number(1 is to find computer; 2 is to find phone)");
		   System.out.print("->");
		   choice = reader.nextInt();
		   if(choice==1){
			   if(computers.isEmpty()){
				   System.out.println("no information!");
			   }
			   else{
				   String findname;
				   findname=reader.next();
				   for(Computer computer:computers){
					   if(findname.equals(computer.name)){
                            computer.showMyElectronics();
							System.out.println("");
					   }
				   }
			   }
		   }
		   if(choice==2){
			   if(phones.isEmpty()){
				   System.out.println("no information!");
			   }
			   else{
				   String findname;
				   findname=reader.next();
				   for(Phone phone :phones){
					   if(findname.equals(phone.name)){
						   phone.showMyElectronics();
						   System.out.println("");
					   }
				   }
			   }
		   }
	}
	public static void changeinformation(){
           String name;
		   System.out.println("please imput the name of electronics you want to change:");
		   name = reader.next();
		   int index=0;
		   for(Computer computer : computers){
			   if(name.equals(computer.name)){
				   computers.remove(computer);
				   index=1;
				   System.out.println("请输入你的设备参数：\n"+
						   "格式为：设备名称 重量 价格 耗电量 制造商 内存 cpu型号");
				   String newname = "0";
				   double weight = 0;
				   int price = 0;
				   int consumption = 0;
				   String maker = "0";
				   int memory ;
				   String cpu;
				   name = reader.next();
				   weight = reader.nextInt();
				   price = reader.nextInt();
				   consumption = reader.nextInt();
				   maker = reader.next();
				   memory = reader.nextInt();
				   cpu = reader.next();
				   new Computer(name,weight,price,consumption,maker,memory, cpu);
				   computers.add(computer);
			   }
		   }
		for(Phone phone : phones){
			if(name.equals(phone.name)){
				phones.remove(phone);
				index=1;
				System.out.println("请输入你的设备参数：\n"+
						"格式为：设备名称 重量 价格 耗电量 制造商 系统类型 储存空间");
				String newname = "0";
				double weight = 0;
				int price = 0;
				int consumption = 0;
				String maker = "0";
				String system = "0";
				int storage;
				name = reader.next();
				weight = reader.nextInt();
				price = reader.nextInt();
				consumption = reader.nextInt();
				maker = reader.next();
				system = reader.next();
				storage = reader.nextInt();
				new Phone(name,weight,price,consumption,maker,system, storage);
				phones.add(phone);
			}
		}
		 if(index==0){
			 System.out.println("fail to find!");
		 }
	}
    public static void deleteinformation(){
		int index=0;
		int index1=0;
		String name;
		if(computers.isEmpty()&&phones.isEmpty()){
			System.out.println("please add information!");
			index1=1;
		}
		else{
			System.out.println("please imput name:");
			name = reader.next();
			for(Computer computer:computers){
				if(name.equals(computer.name)){
					computers.remove(computer);
					index=1;
				}
			}
			for(Phone phone:phones){
				if(name.equals(phone.name)){
					phones.remove(phone);
					index=1;
				}
			}
		}
		if(index==0&&index1==0){
			System.out.println("fain to find!");
		}
	}
}
