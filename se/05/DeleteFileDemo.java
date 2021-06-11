package day04;

import java.io.File;

/**
 * 删除一个文件：
 * File提供了delete（），删除文件file
 * @author Thinkpad
 *
 */
public class DeleteFileDemo {
	public static void main(String[] args) {
		File file =new File("./demo.txt");
		if(!file.exists()){
			System.out.println("无法删除，文件存在");
		}else{
			file.delete();
			System.out.println("删除完毕！");
		}
	}
}