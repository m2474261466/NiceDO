package kunge2020Servlet_day02;


import java.util.List;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class Test2 {
 /*public static void main(String[] args) {
  User u=new User(1,"文雪","123","230@qq.com","15209243");
  userDao udi=new UserDaoImpl();
  int n=udi.register(u);
  if(n>0){
   System.out.println("注册成功");
  }else{
   System.out.println("注册失败");
  }
 }*/
 
 @Test
 public   void TestRegister(){
  User u=new User(0, "文雪","123456","2301471987@qq.com","1520924387");
  UserDao dao=new UserDaoImpl();
  int n=dao.registerUser(u);
  if(n>0){
   System.out.println("注册成功");
  }
 }
 @Test
 public   void   TestAllUser(){
  UserDao   dao=new UserDaoImpl();
  List<User>list=dao.findAllUserData();
  System.out.println("数据当中的数据为：");
  for(User user:list){
   System.out.println(user);
  }
  System.out.println("集合的长度为："+list.size());
  
  
 }
 

}