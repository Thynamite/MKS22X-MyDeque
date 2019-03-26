import java.util.ArrayList;
import java.util.Scanner;

public class Calculator{

    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      //ArrayList<String> list = new ArrayList<String>();
      MyDeque<Double> stack = new MyDeque<Double>();
      Scanner string = new Scanner(s);

      while(string.hasNext()) {
        String dummy = string.next();
        //System.out.println(dummy);
        int index = checkOp(dummy);
        if (index != -1) {
          Double first = stack.removeFirst();
          Double second = stack.removeFirst();
          Double ans = 0.0; //jsut to make it initialize, only would go into stack if a different operation is used other than given
          if (index == 0) {
            ans = first + second;
          }
          if (index == 1) {
            ans = second - first;
          }
          if (index == 2) {
            ans = first * second;
          }
          if (index == 3) {
            ans = second / first;
          }
          if (index == 4) {
            ans = second % first;
          }
          stack.addFirst(ans);
        }
        else {
          stack.addFirst(Double.parseDouble(dummy));
        }

      }
      /*
      for (int x = 0; x < list.size(); x++) {
        System.out.println(list.get(x));
      }
      */
      return stack.getFirst();
    }

    public static int checkOp(String token) {
      String[] operations = {"+", "-", "*", "/", "%"}; //maybe return a number for the non communative

      for (int x = 0; x < operations.length; x++) {
        if (token.equals(operations[x])) {
          return x;
        }
      }
      return -1;
    }
    /*
    public static void main(String[] args) {

      System.out.println(eval("1 2 3 4 5 + * - -")); //-24
      System.out.println(eval("10 2.0 +"));          //12.0
      System.out.println(eval("11 3 - 4 + 2.5 *"));           //30.0
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));       //893.0
      System.out.println(eval("1 2 3 4 5 + * - -"));            //26.0
    }
    */
}
