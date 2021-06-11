package day04;

import java.io.File;

/*
 * 删除多个目录，"用递归删除"
 */
public class DeleteMkdirsDemo {
	public static void main(String[] args){
		//删除多个目录
		/*
		 * 分析：
		 * 1.前提是目录下没有子项即可删除
		 * 2.判断此目录下面的所有子项，若子项是文件则直接删除，若是目录
		 * 则继续判断该目录下是否存在子项，直到该目录下没有任何子项即可删除
		 */
		File file=new File("./a");
		filesdelate(file);
	}

	private static void filesdelate(File file) {
		File[] files=file.listFiles();//该file的所有子项
		for(int i=0;i<files.length;i++){//遍历该目录下所有的子项
			if(files[i].isFile()){//如果该file是文件的话
				files[i].delete();//删除该文件
				System.out.println("删除的文件是"+files[i].getName());
			}
			
			if(files[i].isDirectory()){//如果该file是目录的话
				filesdelate(files[i]);//调用自己的方法filedelete（file）
				
			}
		}
		//如果该file下没有子项，则直接删除
		file.delete();
		System.out.println("删除目录："+file.getName());
	}
}
