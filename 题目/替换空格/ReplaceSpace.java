package TestCode;
//�滻�ո�
public class ReplaceSpace {
	 public static String replaceSpace (String s) {
//       ��ʽһ
//       String st=s.replace(" ","%20");
//       return st;
       
//       ��ʽ��
      StringBuffer sb=new StringBuffer();
      
      if (s == null || "".equals(s)){
          return s;
      }
      String[] ss=s.split("");
      for(String sst:ss){
          if(" ".equals(sst)){
              sb.append("%20");
          }else{
              sb.append(sst);
          }
         
      }
      return   sb.toString();
       
  }
}
