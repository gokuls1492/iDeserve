import java.util.Scanner;

/**
 Given a string with parentheses (round brackets) and letters, validate the parentheses:
 1. An opening parentheses '(' should have a closing matching parentheses ')'.
 2. Closing matching parentheses should not come before an opening parentheses.
 Note: Assume that the string has alphabets and numbers and round brackets only.

 For example:
 ((BCD)AE) - Valid
 )(PH)N(X) - Invalid
 */
public class BalancedParentheses {

    public static boolean validateParentheses(String exp){
        int count =0;
        for (int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if (ch == '(')
                count++;
            else if (ch == ')'){
                if (count == 0)
                    return false;
                else{
                    count--;
                }
            }
        }
        if (count!=0)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = scanner.nextLine();
        if (validateParentheses(str))
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }
}
