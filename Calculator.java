public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> stack = new MyDeque<Double>();
      String scan = "";
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ' && scan.length() != 0) {stack.addFirst(Double.parseDouble(scan)); scan = "";}
        else if (s.charAt(i) == '+') stack.addFirst(stack.removeFirst() + stack.removeFirst());
        else if (s.charAt(i) == '-') {
          if (i + 1 >= s.length() || (i + 1 < s.length() && s.charAt(i+1) == ' ')) {
            double sec = stack.removeFirst();
            stack.addFirst(stack.removeFirst() - sec);
          }
          else scan += s.charAt(i);
        }
        else if (s.charAt(i) == '*') stack.addFirst(stack.removeFirst() * stack.removeFirst());
        else if (s.charAt(i) == '/') {double sec = stack.removeFirst(); stack.addFirst(stack.removeFirst() / sec);}
        else if (s.charAt(i) == '%') {double sec = stack.removeFirst(); stack.addFirst(stack.removeFirst() % sec);}
        else if (s.charAt(i) != ' ') scan += s.charAt(i);
      }
     return stack.removeFirst();
    }
    // public static void main(String[] args) {
    //   System.out.println(eval("2 4 71 8.5 + - * 5 +"));
    //   System.out.println(eval("10 2.0 +"));
    //   System.out.println(eval("11 3 - 4 + 2.5 *"));
    //   System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    //   System.out.println(eval("1 2 3 4 5 + * - -"));
    // }
}
