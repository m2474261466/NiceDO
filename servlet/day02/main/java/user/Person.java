package user;

public class Person {
	 
			String userName;
	       Student Student;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Student getStudent() {
			return Student;
		}
		public void setStudent(Student student) {
			Student = student;
		}
		@Override
		public String toString() {
			return "Person [userName=" + userName + ", Student=" + Student + "]";
		}
          

           
}
