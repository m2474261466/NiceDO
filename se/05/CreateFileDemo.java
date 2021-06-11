package day04;

import java.io.File;
import java.io.IOException;

/**
 * File的每一个实例时表示硬盘上的一个文件或者目录：
 * 使用File：
 * 1.访问其表示的文件或者目录的属性信息（大小，名字等）
 * 2.操作文件或者目录（创建，删除）
 * 3.访问一个目录中所有的子项但是不能访问文件数据
 * 
 * 在表示文件或者目录是指顶路径尽量不要使用绝对路径，因为不同的操作系统格式不一样
 * ，相对路径时最常用的，但是相对路径相对那里要看程序在那个运行环境运行，也就是运行环境
 * 决定着相对路径
 * 
 * 在eclipse中运行程序时，“当前目录“指定该类所处的项目用“./”表示
 * @author Thinkpad
 *
 */
public class CreateFileDemo {
	public static void main(String[] args) throws IOException {
		/*
		 * 在当前目录文件中新建一个文件demo.txt，
		 * file提供createNewFile（）方法来创建文件
		 */
		File file=new File("./demo.txt");
		/*
		 * file提供了boolean exites（）该方法用于判断当前File表示文件或者目录是否存在
		 * 存在返回true
		 */
		if(!file.exists()){
			file.createNewFile();
			System.out.println("创建成功！");
		}else{
			System.out.println("该文件已经创建！");
		}
	}
}
