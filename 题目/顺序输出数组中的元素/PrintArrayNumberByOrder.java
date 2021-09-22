package TestCode;

import java.util.ArrayList;

/**
 * 顺序输出数组中的元素
 * @author 小马的computer
 *
 */
public class PrintArrayNumberByOrder {
   public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> al=new ArrayList<>();
       if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return null;
           }
       int t = 0, b = matrix.length - 1,
           l = 0, r = matrix[0].length - 1;
       while (l <= r && t <= b) {
           // go right
           for (int i = l; i <= r; ++i) {
               al.add(matrix[t][i]);   
           }
           ++t;
           if (l > r || t > b) break;
           // go down
           for (int i = t; i <= b; ++i) {
             al.add( matrix[i][r]);
           }
           --r;
           if (l > r || t > b) break;
           // go left
           for (int i = r; i >= l; --i) {
              al.add(matrix[b][i]);
           }
           --b;
           if (l > r || t > b) break;
           // go up
           for (int i = b; i >= t; --i) {
              al.add(matrix[i][l]);
           }
           ++l;
       }
       return al;
   }
}
