package TestCode;
//ì³²¨ÄÇÆõÊıÁĞ
public class Fibonacci_sequence {
	 public  int Fibonacci(int n) {
	        int first=0;
	        int second=1;
	        int sum=1;
	        if(n==0){
	            return first;
	        }
	        if(n==1){
	            return second;
	        }
	        for(int i=2;i<=n;i++){
	            sum=first+second;
	            first=second;
	            second=sum;
	          }
	         return second;
	        }
}
