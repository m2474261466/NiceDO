package TestCode;
//ÌøÌ¨½×
public class GuaGuaStep_up {
	 public int jumpFloor(int target) {
         if (target <= 0) {
           return 0;
       }
       if (target == 1) {
           return 1;
       }
       if (target == 2) {
           return 2;
       }
       int first = 1, second = 2, third = 0;
       for (int i = 3; i <= target; i++) {
           third = first + second;
           first = second;
           second = third;
       }
       return third;
   }
}
