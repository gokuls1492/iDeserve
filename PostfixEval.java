import java.util.Scanner;
import java.util.Stack;

/**
 Evaluate the value of a Postfix expression, also known as expression in Reverse Polish Notation.
 Given: An array of strings, every string being either an operand or an operator, in Reverse Polish Notation, find out the value of the expression.

 Example:
 Input:
 20    30    +
 Output:
 50

 Input:
 5    1    2    +    4    *    +    3    -
 Output:
 14
 */

public class PostfixEval {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        Stack<Integer> result = new Stack<Integer>();
        int exp = 0;
        for (int i=0; i< inputArray.length; i++){
            String oper = null;
            int x=0;
            if (inputArray[i] != null && (inputArray[i].matches("^\\d+"))){
                exp = Integer.parseInt(inputArray[i]);
                result.push(exp);
            }else {
                oper = inputArray[i];
                if (oper != null){
                    int b = result.pop();
                    int a = result.pop();
                    switch (oper){
                        case "+" : x = a + b;
                                 break;
                        case "*" : x = a * b;
                                 break;
                        case "-" : if(a>b) x = a - b;
                                   else x = b - a;
                                 break;
                        case  "/" : x = a / b;
                                  break;
                    }
                }
             result.push(x);
            }
        }
        System.out.println(result.pop());
    }
}
