package kunge2020Servlet_day02;


import java.util.List;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class Test2 {
 /*public static void main(String[] args) {
  User u=new User(1,"��ѩ","123","230@qq.com","15209243");
  userDao udi=new UserDaoImpl();
  int n=udi.register(u);
  if(n>0){
   System.out.println("ע��ɹ�");
  }else{
   System.out.println("ע��ʧ��");
  }
 }*/
 
 @Test
 public   void TestRegister(){
  User u=new User(0, "��ѩ","123456","2301471987@qq.com","1520924387");
  UserDao dao=new UserDaoImpl();
  int n=dao.registerUser(u);
  if(n>0){
   System.out.println("ע��ɹ�");
  }
 }
 @Test
 public   void   TestAllUser(){
  UserDao   dao=new UserDaoImpl();
  List<User>list=dao.findAllUserData();
  System.out.println("���ݵ��е�����Ϊ��");
  for(User user:list){
   System.out.println(user);
  }
  System.out.println("���ϵĳ���Ϊ��"+list.size());
  
  
 }
 

}