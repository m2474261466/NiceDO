package day01;

public class person {
	  //1.����  ��̬   �� �ǲ���һ���������� ������������ ������������  �����������з���
		 String name;
		//�������� 
		private int age;
		private double salary;
		private boolean isMarried;
		//2.���췽�� �����кö�� ��������
		public person(String name,int age ,double salary,boolean isMarried) {
			this.age = age;
			this.name=name;
			this.salary = salary;
			this.isMarried= isMarried;
		}
		public person(String name,int age) {
			
			this.name = name;
			this.age = age;
		}
		//3.��ͨ���� ��̬
		public void sleep(String name) {
			System.out.println(name+"is sleeping");
		}
		
		
		public void sleep(String name,int age) {
			System.out.println(name+":"+age+"is sleeping");
		}
		
		
		
		
		public String toString() {
			
			return "����:"+this.name+"����:"+this.age+"нˮ:"+this.salary+"���:"+this.isMarried;
		}
		
}
