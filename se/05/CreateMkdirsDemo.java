package day04;

import java.io.File;

/*
 * 创建多个目录
 * File提供了mkdirs（）
 */
public class CreateMkdirsDemo {
	public static void main(String[] args) {
		File file=new File("a/b/c/d/e/f");
		if(!file.exists()){
			file.mkdirs();//创建多个目录
			System.out.println("创建成功");
		}else{
			System.out.println("该目录已经创建");
		}
	}
}
