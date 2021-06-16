package day07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TransientDemo {
             public static void main(String[] args) throws IOException {
				Doctor doctor=new Doctor();
				doctor.setAge(22);
				doctor.setName("lious");
				doctor.setNick("¹þËË");
				FileOutputStream os=new FileOutputStream("doctor.txt");
				ObjectOutputStream oso=new ObjectOutputStream(os);
				oso.writeObject(doctor);
				System.out.println("Ð´ÈëÍê±Ï£¡");
				oso.close();
			}
}
