package TestCode;
/*
 * ���üӼ��˳����ӷ� 
 */
public class NoNeedToAddSubtractMultiplyAndDivide {
    public int Add(int num1,int num2) {
        while(num2 !=0){
            int c = (int)(num1 & num2) << 1;
            num1 ^= num2;
            num2 = c;
        }
        return num1;
    }
}
