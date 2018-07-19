package ccf;

import java.util.Arrays;
import java.util.Scanner;

public class 图像旋转 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int H = sc.nextInt();
      int L = sc.nextInt();
      int[][] a = new int[H][L];
      for(int i = 0;i<H;i++){
         for(int j=0;j<L;j++){
            a[i][j] = sc.nextInt();
         }
      }
      int[][] b = new int[L][H];
      for(int i = 0;i<H;i++){
         for(int j=0;j<L;j++){
            b[L-j-1][i]= a[i][j];
         }
      }
      for(int i=0;i<L;i++){
         for(int j=0;j<H;j++){
            if(j<H-1)
            System.out.print(b[i][j]+" ");
            else
               System.out.println(b[i][j]);
         }
      }
   }
}
