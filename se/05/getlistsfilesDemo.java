package day04;

import java.io.File;

/*
 * 获取一个目录中所有子项，在file中提供了listFile（）方法，返回File数组，
 * 可返回当前目录中所有子项；
 * 当前目录下可以用"./"或者"."
 * 
 * 
 * boolean isFile()判断当前file是否表示为文件
 * boolean isDirectory()判读当前File是否是目录
 * 
 * 
 * 
 */
public class getlistsfilesDemo {
	public static void main(String[] args) {
		//在当前目录下获取所有的子项
		File file=new File("./");
		File[] files=file.listFiles();
		System.out.println(files.length);
		
		for(int i=0;i<files.length;i++){
			if(files[i].isFile()){
				System.out.println("文件名："+files[i].getName());
			}
			
			if(files[i].isDirectory()){
				System.out.println("目录名："+files[i].getName());
			}
		}
		
	}
}
