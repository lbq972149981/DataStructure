package ccf;

import java.util.Scanner;

public class ISBN号码 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String str = sc.next();
      String newstr = str.substring(0,str.length()-1);
      int sum = 0;
      int j = 1;
      for(int i=0;i<str.toCharArray().length-2;i++){
         char c = str.toCharArray()[i];
         if(c!='-'){
            sum+=Integer.parseInt(c+"")*j;
            j++;
         }
      }
      char shibie = str.charAt(str.length()-1);
      boolean flag = shibie == 'X'? true:false;
      if(flag){
         if(sum%11==10){
            System.out.println("Right");
         }else {
            System.out.println(newstr+sum%11);
         }
      }else {
         if(sum%11==Integer.parseInt(shibie+"")){
            System.out.println("Right");
         }else if(sum%11==10){
            System.out.println(newstr+'X');
         }
         else {
            System.out.println(newstr+sum%11);
         }
      }
   }
}
