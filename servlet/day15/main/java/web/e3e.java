package web;

import java.util.List;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class e3e {
     public static void main(String[] args) {
		UserDao dao=new UserDaoImpl();
		int n=dao.selectUserAll();
		System.out.println(n);
		
	}
}
