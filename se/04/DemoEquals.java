package day03;
/**
 * ���������е�equals����
 * equals(Other obj)��
 * ���Աؿ���
 * equals��==������
 * 1.==�ڻ������������ڱȽϱ�����ֵ����������������ͣ��Ƚϵ����������ñ����Ƿ�ָ��ͬһ����
 * 2.equals��дObject��equals��������д��������ڱȽ϶���������Ƿ�һ����
 * @author 24742
 *
 */
public class DemoEquals {
             public static void main(String[] args) {
				/*Point p =new Point();
				int a=9;
				int b=10;
				System.out.println(a==b);//false
				String str="abc";
				String s=str;
				System.out.println(s==str);//true
				
				
			   Point p1=new Point();
			   Point p2=p1;
			   System.out.println(p2==p1);//true
			   
			   
			   Point p3=new Point(5,6);
			   Point p4=new Point(5,6);
			   System.out.println(p3==p4);//false*/
				
            	 Point p3=new Point(5,6);
  			     Point p4=new Point(5,6);
  			    System.out.println(p3.equals(p4));//true
  			   
  			    
  			    
  			    
  			  Point p5=new Point(5,6);
			   Point p6=new Point(5,6);
			   System.out.println(p5.equals(null));//true
			   
			   
			   
				
				
				
				
			}
}
