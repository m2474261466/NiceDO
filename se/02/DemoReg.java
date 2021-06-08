package day02;
/**
 * 正则表达式简介：
 * 实际开发中，经常需要对字符串数据进行一些复杂的匹配，查找，替换等操作
 * ，通过正则表达式，可以方便的实现字符串的复杂操作、
 * 什么是正则表达式：
 * 1，正则本来就是一个字符串
 *2。正则是用于检索目标字符串中的规则
 *3.正则是规定字符串是否合理
 *4.正则需要解析器执行，Java提供了相关解析器处理API
 *5.常见的编程语言大部分都支持正则API
 *matches(正则表达式)方法：将一个字符串与正则表达式进行匹配，如果匹配成功就返回true，否则返回false；
 * @author 24742
 *
 */
public class DemoReg {
     public static void main(String[] args) {
    String regex1="[a-z]";//字母小写a到字母小写z中的任意一个字符
    //判断正则表达式的方法是matches()
    String s="bc";
    System.out.println(s.matches(regex1));//false
    String regex2="[^a-z]";
    String regex3="[a-z&&[^bc]]";
    String regex4="[a-zA-Z0-9]";
    System.out.println("c".matches(regex2));//false
    String d="s";
    System.out.println(d.matches(regex3));//false
    String regex5="\\d";// [0-9]      \为转义字符，直接\d会报错，认为这是一个d目录
    String regex6="\\D";//[^0-9]
    String regex7="\\s";//[\t]
    String regex8="\\S";//[^\t]
    String regex9="\\w";//[a-zA-Z0-9_]
    String regex10="\\W";//[^a-zA-Z0-9_]
    String regex11=".";
    String regex12="\\.";
    System.out.println("8".matches(regex5));//true
    System.out.println("2".matches(regex6));//false
    System.out.println(" ".matches(regex7));//true
    System.out.println("".matches(regex8));//false
    System.out.println("_".matches(regex9));//true
    System.out.println("-".matches(regex10));//true
    System.out.println("a".matches(regex11));//true
    System.out.println("a".matches(regex12));//false
    
    
    
	}
 
}
