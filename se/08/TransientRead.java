package day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TransientRead {
	  public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileInputStream sd=new FileInputStream("doctor.txt");
		ObjectInputStream os1=new ObjectInputStream(sd);
		Object obj=(Doctor)os1.readObject();
		System.out.println(obj);
		os1.close();
	}

}
