package day02;
/**
 * ������ʽ��飺
 * ʵ�ʿ����У�������Ҫ���ַ������ݽ���һЩ���ӵ�ƥ�䣬���ң��滻�Ȳ���
 * ��ͨ��������ʽ�����Է����ʵ���ַ����ĸ��Ӳ�����
 * ʲô��������ʽ��
 * 1������������һ���ַ���
 *2�����������ڼ���Ŀ���ַ����еĹ���
 *3.�����ǹ涨�ַ����Ƿ����
 *4.������Ҫ������ִ�У�Java�ṩ����ؽ���������API
 *5.�����ı�����Դ󲿷ֶ�֧������API
 *matches(������ʽ)��������һ���ַ�����������ʽ����ƥ�䣬���ƥ��ɹ��ͷ���true�����򷵻�false��
 * @author 24742
 *
 */
public class DemoReg {
     public static void main(String[] args) {
    String regex1="[a-z]";//��ĸСдa����ĸСдz�е�����һ���ַ�
    //�ж�������ʽ�ķ�����matches()
    String s="bc";
    System.out.println(s.matches(regex1));//false
    String regex2="[^a-z]";
    String regex3="[a-z&&[^bc]]";
    String regex4="[a-zA-Z0-9]";
    System.out.println("c".matches(regex2));//false
    String d="s";
    System.out.println(d.matches(regex3));//false
    String regex5="\\d";// [0-9]      \Ϊת���ַ���ֱ��\d�ᱨ����Ϊ����һ��dĿ¼
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
