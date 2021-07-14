package web;

import java.io.Serializable;

public class Employe  implements Serializable{
          private  String ename;
          private int age;
          private double salay;
          private int empon;
          private  Address address;
          
         
		public Employe(String ename, int age, double salay, int empon, Address address) {
			super();
			this.ename = ename;
			this.age = age;
			this.salay = salay;
			this.empon = empon;
			this.address = address;
		}
		
		public Employe() {
			super();
			// TODO Auto-generated constructor stub
		}

		public String getEname() {
			return ename;
		}
		public void setEname(String ename) {
			this.ename = ename;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public double getSalay() {
			return salay;
		}
		public void setSalay(double salay) {
			this.salay = salay;
		}
		public int getEmpon() {
			return empon;
		}
		public void setEmpon(int empon) {
			this.empon = empon;
		}
		public Address getaddress() {
			return address;
		}
		public void setaddress(Address address) {
			this.address = address;
		}
          
          
          
}
