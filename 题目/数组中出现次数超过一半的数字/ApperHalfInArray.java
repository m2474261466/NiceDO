package TestCode;
//�����г��ִ�������һ������� 
public class ApperHalfInArray {
	public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0)return 0;
      int morgen=0;
      int vote=0;
      for(int i=0;i<array.length;i++){
          if(vote==0){
              morgen=array[i];
              vote++;
          }else{
              if(array[i]==morgen){
                  vote++;
              }else{
                  vote--;
              }
          }
      }
      int tmp=0;
      for(int i=0;i<array.length;i++){
          if(array[i]==morgen){
              tmp++;
          }
          if(tmp>array.length/2){
              return morgen;
          }
      }
      return 0;
  }
}
