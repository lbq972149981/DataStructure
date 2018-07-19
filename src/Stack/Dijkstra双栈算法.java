package Stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 地杰斯特拉双栈算法，计算表达式
 */
public class Dijkstra双栈算法 {
   @Test
   public void test(){
      Stack<Integer> elem = new Stack<>();
      Stack<Character> opt = new Stack<>();
      String str = "((1+(2+3))*2)";
      char[] ch = str.toCharArray();
      for(int i=0;i<ch.length;i++){
         if(ch[i]=='+'){
            opt.push(ch[i]);
         }else if(ch[i]=='-'){
            opt.push(ch[i]);
         }else if(ch[i]=='*'){
            opt.push(ch[i]);
         }else if(ch[i]=='/'){
            opt.push(ch[i]);
         }else if(ch[i]=='('){
         }else if(ch[i]==')'){
            char c = opt.pop();
            Integer v1 = elem.pop();
            if(c=='+'){
               v1 = v1 + elem.pop();
            }else if(c=='-'){
               v1 = elem.pop() - v1;
            }else if(c=='*'){
               v1 = v1 * elem.pop();
            }else if(c=='/'){
               v1 = elem.pop() / v1;
            }
            elem.push(v1);
         }else {
            elem.push(Integer.parseInt(ch[i]+""));
         }
      }
      System.out.println(elem.peek());
   }
   /*public double result(String str){
      Stack<Double> elem = new Stack<>();
      Stack<Character> opt = new Stack<>();
      char[] ch = str.toCharArray();
      for(int i=0;i<ch.length;i++){
         if(ch[i]=='+'){
            opt.push(ch[i]);
         }else if(ch[i]=='-'){
            opt.push(ch[i]);
         }else if(ch[i]=='*'){
            opt.push(ch[i]);
         }else if(ch[i]=='/'){
            opt.push(ch[i]);
         }else if(ch[i]=='('){
         }else if(ch[i]==')'){
            char c = opt.pop();
         }
      }
      return 0;
   }*/
}
