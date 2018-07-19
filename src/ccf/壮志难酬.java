package ccf;

import java.util.Arrays;
import java.util.Scanner;

public class 壮志难酬 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      while(T-->0){
         String n = sc.next();
         int count = sc.nextInt();
         int index = 0;
         for(int i=0;i<n.length();i++){
            if(n.charAt(i)=='.'){
               index = i+1;
               break;
            }
         }
         if(index+count>n.length()){
            System.out.println(0);
         }else {
            System.out.println(n.charAt(index+count-1)+"");
         }
      }
   }
}
