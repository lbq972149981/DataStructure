package ccf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 游戏 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int k = sc.nextInt();
         List<Integer> child = new LinkedList<>();
         for (int i = 1; i <= n; i++) {
            child.add(i);
         }
         int count = 1;
         while (child.size() > 1) {
            for (int i = 0; i < child.size(); i++) {
               int lastnumber = count%10;
               if (count % k == 0 || lastnumber == k) {
                  child.remove(child.get(i));
                  if(child.size()==1){
                     break;
                  }
                  i--;
               }
               count++;
            }
         }
         System.out.println(child.get(0));
      }
}
