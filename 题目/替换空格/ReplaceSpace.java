package TestCode;
//替换空格
public class ReplaceSpace {
	 public static String replaceSpace (String s) {
//       方式一
//       String st=s.replace(" ","%20");
//       return st;
       
//       方式二
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
