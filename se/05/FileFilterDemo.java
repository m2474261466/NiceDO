package day04;

import java.io.File;
import java.io.FileFilter;

/*
 *FileFilter是一个接口，用于路径下文件名或者目录的过滤器 
 */
public class FileFilterDemo {
	public static void main(String[] args) {
		File file=new File("D:/ykt/ykt/yktt/workspace/ykt2020SE");
		File[] files=file.listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				System.out.println("正在过滤："+pathname.getName());
				
				//过滤File后缀是"txt"的文件，若获取到，返回true，否则返回false
				boolean b=pathname.getName().endsWith("ject");
				return b;
			}
		});
		
		
		for(int i=0;i<files.length;i++){
			System.out.println("过滤后的文件是："+files[i].getName());
		}
	}
}
