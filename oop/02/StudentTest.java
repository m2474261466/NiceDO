package day01;
/**
 *  ѧ���ľ��������
 * @author Lenovo
 *
 */
public class StudentTest {
	public static void main(String[] args) {
	//  ��(Student)   ��������(student)  ָ��( = )   ������һ���µĶ���(new Student())
		Student       student               =          new Student();//ʹ���޲ι��췽����������
		Student       student02             =          new Student(23,"����2",'��',9527);//ʹ���вι��췽����������
		/*
		 * ��ȡ���������Ե�ֵ:�������������.���������/��������
		 */
		System.out.println(student02.name+","+student02.num);
		//student.sleep();
		/*
		 * �������������������"."ȥ���ʶ�������Ժͷ���
		 */
		/*student.age=18;
		student.gender='��';
		student.name="����";		
		student.num=1;
		student.sleep();
		
		Student student02 = new Student();
		student02.name="����";
		student02.gender='��';
		student02.age=18;
		student02.num=2;
		student02.study();*/
		
		
	}
}
