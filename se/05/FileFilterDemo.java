package day04;

import java.io.File;
import java.io.FileFilter;

/*
 *FileFilter��һ���ӿڣ�����·�����ļ�������Ŀ¼�Ĺ����� 
 */
public class FileFilterDemo {
	public static void main(String[] args) {
		File file=new File("D:/ykt/ykt/yktt/workspace/ykt2020SE");
		File[] files=file.listFiles(new FileFilter() {
			
			public boolean accept(File pathname) {
				System.out.println("���ڹ��ˣ�"+pathname.getName());
				
				//����File��׺��"txt"���ļ�������ȡ��������true�����򷵻�false
				boolean b=pathname.getName().endsWith("ject");
				return b;
			}
		});
		
		
		for(int i=0;i<files.length;i++){
			System.out.println("���˺���ļ��ǣ�"+files[i].getName());
		}
	}
}
