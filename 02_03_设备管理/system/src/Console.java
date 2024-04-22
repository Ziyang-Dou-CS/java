import equipment.application.UseElectronics;

import java.util.Scanner;

public class Console {
    public static UseElectronics application = new UseElectronics();
    public static Scanner reader = new Scanner(System.in);


    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("----------欢迎使用电子设备管理系统-----------");
            System.out.println("-------------【1】录入电子设备信息-------------");
            System.out.println("-------------【2】显示统计数据-------------");
            System.out.println("-------------【3】查找电子设备信息-------------");
            System.out.println("-------------【4】修改电子设备信息-------------");
            System.out.println("-------------【5】删除电子设备信息-------------");
            System.out.println("-------------【6】退出系统-------------");
            System.out.println("请输入你的选择：");
            choice = reader.nextInt();
            if (choice == 6) {
                break;
            }
            switch (choice) {
                case 1:
                    application.addInformation();
                    break;
                case 2:
                    application.showAll();
                    break;
                case 3: {
                    application.find();
                    break;
                }
                case 4:
                    application.changeinformation();
                    break;
                case 5:
                    application.deleteinformation();
                    break;
                default:
                    System.out.println("please imput wright number!");
                    break;
            }
        }
    }

}
