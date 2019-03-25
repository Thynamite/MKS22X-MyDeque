import java.util.ArrayList;
import java.util.Scanner;

public class Calculator{

    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      ArrayList<String> list = new ArrayList<String>();
      MyDeque<Double> stack = new MyDeque<Double>();
      Scanner string = new Scanner(s);

      while(string.hasNext()) {
        list.add(string.next());
      }
      /*
      for (int x = 0; x < list.size(); x++) {
        System.out.println(list.get(x));
      }
      */

      for (int i = 0; i < list.size(); i ++) {
        if (checkOp(list.get(i))) {

        }
        else {
          stack.addFirst((Double)list.get(i))
        }
      }
      return 0;
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
