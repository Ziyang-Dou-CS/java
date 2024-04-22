package application;

import java.util.StringTokenizer;

import application.FileSystem.MyException;

import java.util.InputMismatchException;
import java.util.Scanner;

import framework.File;
import framework.Folder;
import framework.FolderItem;
//StringTokenizer类将一个英文句子中各个单词分别提取出来

public class FileSystem {
    public static String input;
    class MyException extends Exception {
        /**
         *
         */
        private static final long serialVersionUID = 3626348820613533381L;// 系统提示自动添加
        /**
         * 自定义异常类
         */
        String message;
        public MyException(String error) {
            message = error;
        }
        public String getMessage() {
            // 重写getMessage方法
            return message;
        }
    }

    static Scanner reader = new Scanner(System.in);
    /**
     * The main function try to use <code>File<code>, <code>Folder<code>
     * and <code>FolderItem<code> and comparing with using class java.io.File
     */
    public static void main(String[] args) {
        boolean i;
        int flag = 0;
        do {

        /** Get the current user path and printout it */
        String path = System.getProperty("user.dir");
        // 返回执行java命令的路径
        /** Get specified path and printout it */

        // String path = "D:\\testFileSystem";

        System.out.println(path);

        /** Get the folder name */
        StringTokenizer tokenizer = new StringTokenizer(path, "\\");
        // StringTokenizer用于自定义字符为分界符进行拆分，即遇到"\\"拆分一次
        String folderName = tokenizer.nextToken();
        // nextToken方法返回的是当前索引位置到下一个"\"为止出现的所有字符
        for (; tokenizer.hasMoreTokens(); ) {
            // hasMoreTokens判断字符串中是否还有可读的单词
            folderName = tokenizer.nextToken();
            // 循环作用是获取当前文件名称，即获取绝对路径中的最后一个token
        }

        /** Get all file items <code>files<code> of the current user path */
        java.io.File file = new java.io.File(System.getProperty("user.dir"));
        // 创建file对象，表示当前工作目录的路径
        /** Get all file items <code>files<code> of specified path */

        java.io.File[] files = file.listFiles();

        // 创建file数组，使用listFiles获取当前工作目录中的所有文件和子目录

            if (files != null) {

                /**
                 * Recursive printout all folder items of the current folder by
                 * using java.io.File
                 *
                 */
                if (flag == 0) {
                    System.out.println(folderName);
                    printFolderItems(file, "--");

                    System.out.println("====Up:java.io.File========Down:filesystem===========");
                }
                /**
                 * Recursive construct <code>folder<code> include all folder items
                 * by using <code>File<code>, <code>Folder<code>, <code>FolderItem<code>
                 * and java.io.File
                 *
                 */
                Folder folder = new Folder(folderName);
                for (java.io.File f : files) {
                    // 当前工作目录的所有文件和子目录进行分析
                    FolderItem folderItem;
                    if (f.isFile()) {
                        // 如果是文件
                        folderItem = new File(f.getName(), "  ", (int) f.length());
                        // 用父类对象表示子类对象
                        folder.addFolderItem(folderItem);
                    }
                    if (f.isDirectory()) {
                        // 如果是目录
                        folderItem = new Folder(f.getName());
                        folder.addFolderItem(folderItem);
                        constructFolderItems(f, (Folder) folderItem);
                        // 将表示子类对象的父类对象，强制转换为子类对象
                    }
                }
                // 将当前工作目录中的文件和文件夹添加到该文件夹对象中。同时递归构建子文件夹和子文件。
                /**
                 * Recursive printout all folder items of the current folder by
                 * using <code>File<code>, <code>Folder<code> and <code>FolderItem<code>
                 *
                 */
                System.out.println(folder.getName());
                printFolderItems(folder, "--");
            }
            i = run();
            flag = 1;
        } while (i);
    }

    /**
     * Recursive construct <code>folder<coder> object of one folder
     * by using <code>File<code>, <code>Folder<code> and <code>FolderItem<code>
     * and class java.io.File
     *
     * @param f      a java.io.File's object
     * @param folder Folder
     */
    public static void constructFolderItems(java.io.File f, Folder folder) {
        java.io.File[] subFiles = f.listFiles();
        for (java.io.File i : subFiles) {
            FolderItem folderItem;
            if (i.isFile()) {
                folderItem = new File(i.getName(), "  ", (int) i.length());
                folder.addFolderItem(folderItem);
            }
            if (i.isDirectory()) {
                folderItem = new Folder(i.getName());
                folder.addFolderItem(folderItem);
                constructFolderItems(i, (Folder) folderItem);
            }
        }
    }

    // 这段代码用于递归构建文件夹结构的方法。
    // java.io.File[] subFiles = f.listFiles()这行代码获取了当前文件夹 `f`
    // 中的所有子文件和子文件夹，并将它们存储在一个数组
    // for (java.io.File i : subFiles)遍历了`subFiles`数组中的所有子文件和子文件夹。
    // if (i.isFile())检查当前文件 `i` 是否是一个文件。
    // folderItem = new File(i.getName(), " ", (int) i.length());`: 如果 `i`
    // 是一个文件，那么创建一个新的 `File` 对象，并使用文件的名称、空格字符串以及文件的长度来初始化该对象。然后将这个文件对象添加到 `folder`
    // 文件夹中。
    // if (i.isDirectory())检查当前文件 `i` 是否是一个文件夹。
    // folderItem = new Folder(i.getName());`: 如果 `i` 是一个文件夹，那么创建一个新的 `Folder`
    // 对象，并使用文件夹的名称来初始化该对象。然后将这个文件夹对象添加到 `folder` 文件夹中
    // constructFolderItems(i, (Folder) folderItem);`:这个递归调用用于构建当前文件夹的子文件夹结构。

    /**
     * Recursive printout all folder items under one folder
     * only by using class java.io.File
     *
     * @param f      a java.io.File's object
     * @param indent a String object for printing indentation
     */
    public static void printFolderItems(java.io.File f, String indent) {
        for (java.io.File i : f.listFiles()) {
            System.out.println(indent + i.getName());
            if (i.isDirectory()) {
                String indentTemp = indent + "--";
                printFolderItems(i, indentTemp);
            }
        }
        // 该方法的作用是打印当前目录的所有文件或文件夹，并运用函数嵌套实现层级划分（打印文件夹中的文件夹）
    }

    /**
     * Recursive printout all folder items under one folder by using
     * <code>File<code>, <code>Folder<code> and <code>FolderItem<code>
     *
     * @param f      a Folder object
     * @param indent a String object for printing indentation
     */
    public static void printFolderItems(Folder f, String indent) {
        // 通过输入参数的类型不同，实现方法的重写
        for (FolderItem item : f.getFolderItems()) {
            System.out.println(indent + item.getName());
            if (item instanceof Folder) {
                // 判断item是否是Folder的实例
                String indentTemp = indent + "--";
                printFolderItems((Folder) item, indentTemp);
            }
        }
    }// 用于递归打印文件夹结构的方法。indent是传入的缩进字符串

    /**
     * 输入字符串，转化为数字指令
     *
     * @throws MyException
     */
    /**
     *
     */
    /**
     * 输入字符串，转化为数字指令
     */
    public static int read() {
        int choice = 0;
        System.out.print("mkdir:创建目录\n" + "rmdir:删除目录\n" + "quit:停止\n");
        System.out.println("->");
        input = reader.next();
        reader.nextLine();
        if (input.equals("mkdir")) choice = 1;
        else if (input.equals("rmdir")) choice = 2;
        else choice = 0;
        return choice;
    }

    public static boolean a;

    public static boolean run() {
        int choice = read();
        switch (choice) {
            case 1:
                System.out.println("请输入你要创建目录的名称：");
                String dirname = reader.next();
                makedir(dirname);
                return true;
            case 2:
                System.out.println("请输入要删除的文件的名称");
                String rmname;
                rmname = reader.next();
                rmdir(rmname);
                return true;
            case 0:
                return false;
        }
        return false;
    }

    public static String makedir(String name) {
        //在相对路径下创建 newTestFile 文件夹
        java.io.File newDir = new java.io.File(name);
        System.out.println(newDir.mkdir());
        System.out.println("创建成功");
        String filePath = newDir.getAbsolutePath();

        return filePath;
    }
    //删除目录

    public static void rmdir(String fileName) {
        java.io.File file = new java.io.File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("文件删除成功: " + file.getAbsolutePath());
            } else {
                System.out.println("文件删除失败");
            }
        } else {
            System.out.println("文件不存在");
        }
    }


}