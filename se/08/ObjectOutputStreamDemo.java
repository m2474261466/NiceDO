package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象流：
 * 对象流是一种高级流，可以方便我们将java中任何对象进行读写操作。
 * java.io.ObjectOutputStream
 * 对象输出流，可以将对象转换为一组字节写出
 * 
 * 
 * java.io.ObjectInputStream
 * 对象输入流，可以读取一组字节将还原对象，还原为对象的条件是
 * 读取这组字节应该是对象输出流将一个对象转换的字节
 * 
 * 
 * @author 24742
 *
 */
public class ObjectOutputStreamDemo {
           public static void main(String[] args) throws IOException {
        	   Student stu=new Student();
        	   stu.setAge(18);
        	   stu.setName("吵啊");
        	   stu.setGender('男');
        	   //字节输出流
        	   FileOutputStream fos=new FileOutputStream("stu.txt");
        	   //对象输出流
        	   ObjectOutputStream oos=new ObjectOutputStream(fos);
        	   /*
        	    * OutputStream提供了writeObject(Object obj)
        	    * oos将对象转换为字节后将这组字节交给fos写入文件等于写入到
        	    * 硬盘，这个过程称之为“数据持久化”；
        	    * oos将给定的对象stu转为一组字节，这个过程称之位“对象序列化”；
        	    */
        	   //序列化
        	   oos.writeObject(stu);
        	   System.out.println("写入完毕");
        	   oos.close();
        	 
        	  
        	   
        	   
        	   
		}   
 
}
