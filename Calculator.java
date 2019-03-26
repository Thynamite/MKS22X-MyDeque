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
        if (checkOp(dummy)) {
          Double first = stack.removeFirst();
          Double second = stack.removeFirst();
          if (dummy.equals("-")) {
            Double ans = second - first;
            stack.addFirst(ans);
          }
          if (dummy.equals("/")) {
            Double ans = second / first;
            stack.addFirst(ans);
          }
          if (dummy.equals("%")) {
            Double ans = second % first;
            stack.addFirst(ans);
          }
          if (dummy.equals("*")) {
            Double ans = first * second;
            stack.addFirst(ans);
          }
          if (dummy.equals("+")) {
            Double ans = first + second;
            stack.addFirst(ans);
          }
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

    public static boolean checkOp(String token) {
      String[] operations = {"+", "-", "*", "/", "%"}; //maybe return a number for the non communative

      for (int x = 0; x < operations.length; x++) {
        if (token.equals(operations[x])) {
          return true;
        }
      }
      return false;
    }
    public static void main(String[] args) {
      eval("1 2 3 4 5 + * - -");
    }
}
