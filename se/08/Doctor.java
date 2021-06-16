package day07;

import java.io.Serializable;

/**
 * transient属性：
 * 把不需要序列化的属性忽略掉，这样可以达到对象文件“减肥”的目的
 * @author 24742
 *
 */
public class Doctor implements Serializable {
   private  String name;
   private  int age;
   private transient String  nick;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getNick() {
	return nick;
}
public void setNick(String nick) {
	this.nick = nick;
}
@Override
public String toString() {
	return "Doctor [name=" + name + ", age=" + age + "]";
}
   
}
