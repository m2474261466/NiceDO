package day04;

import java.io.File;

/*
 * 删除目录
 * 删除目录有一个前提，也就是该目录必须是一个空白目录才可以删除
 */
public class DeleteMkdirDemo {
	public static void main(String[] args) {
		File file=new File("demo/dd.txt");//删除文件
		File file2=new File("demo");//删除目录
		if(file.exists()){
			file.delete();
			file2.delete();
			System.out.println("删除完毕");
		}else{
			System.out.println("目录不存在");
		}
	}
}
