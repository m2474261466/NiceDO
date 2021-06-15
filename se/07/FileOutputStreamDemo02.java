package day06;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 2:追加操作,若文件有数据则全部保留,从该文件末尾追加内容
 * FileOutputStream(String path,boolean append)
 * FileOutputStream(File file,boolean append)
 * append默认为false，当设置为true则在文件数据尾部追加
 * @author 24742
 *
 */
public class FileOutputStreamDemo02 {
      public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("fos.txt",true);
		//String str="超哥赶紧找个小妹子来解解闷";
		String  str="坤哥也想找个妹子解解闷";
		byte[] bs=str.getBytes("UTF-8");
		fos.write(bs);
		System.out.println("写入完毕！");
		fos.close();
	}
}
