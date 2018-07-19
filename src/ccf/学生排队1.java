package ccf;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class 学生排队1 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      List<Integer> student = new LinkedList<>();
      int N = sc.nextInt();
      int count = sc.nextInt();
      for(int i=1;i<=N;i++){
         student.add(i);
      }
      for(int i=0;i<count;i++){
         int StuNum = sc.nextInt();
         int Pos = sc.nextInt();
         int index = 0;
         for(int k=0;k<student.size();k++){
            if(student.get(k)==StuNum){
               index = k;
               break;
            }
         }
         int t = student.get(index);
         if(Pos>0){
            for(int j=index;j<index+Pos;j++){
               student.set(j,student.get(j+1));
            }
            student.set(index+Pos,t);
         }else {
            Pos = Math.abs(Pos);
            for(int j=index;j>index-Pos;j--){
               student.set(j,student.get(j-1));
            }
            student.set(index-Pos,t);
         }
      }
      for(int i=0;i<student.size();i++){
         if(i!=student.size()-1){
            System.out.print(student.get(i)+" ");
         }else {
            System.out.println(student.get(i));
         }
      }
   }
}
  /*
      8
      3
      3 2
      8 -3
      3 -2
      1 2 4 3 5 8 6 7
       */