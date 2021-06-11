package day04;

import java.io.File;
import java.io.IOException;
/*
 * 创建目录
 */
public class CreateMkdirDemo {
	public static void main(String[] args) throws IOException {
		File file=new File("./demo");
		if(!file.exists()){
			file.mkdir();//创建目录
			System.out.println("创建成功");
		}else{
			 System.out.println("已创建");
		}
		
		File file2=new File("demo/dd.txt");
		if(!file2.exists()){
			file2.createNewFile();//创建文件
			System.out.println("创建成功");
		}else{
			System.out.println("已经创建");
		}
	}
}
