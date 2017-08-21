import java.util.Scanner;

/**

 Given a string, find all the permutations of the string.
 For example:
 Input String: abc
 Output: {bca, acb, abc, cba, bac, cab}

 */

public class PermString {
    public static String swap(String input, int i, int j){
        char temp;
        char[] chArray = input.toCharArray();
        temp = chArray[i];
        chArray[i] = chArray[j];
        chArray[j] = temp;
        return String.valueOf(chArray);
    }
    public static void permString(String input, int l, int r){
        if (l==r){
            System.out.println(input);
            return;
        }
            for (int i = l; i <= r; i++) {
                input = swap(input, l, i);
                permString(input, l + 1, r);
                input = swap(input, l, i);
            }
        }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = sc.nextLine();
        permString(input,0,input.length()-1);
    }
}
