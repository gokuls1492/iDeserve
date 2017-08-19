import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 iDeserve - String

 Find the first non repeating character in string.
 Example:
 Input : ADBCGHIEFKJLADTVDERFSWVGHQWCNOPENSMSJWIERTFB
 Output: K
 */

public class FirstNonRepChar {
    public char getFirstNonRep(String str){
        char[] ch = str.toCharArray();
        int count = 0;
        char res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i=0; i< ch.length; i++){
            if (!hashMap.containsKey(ch[i])){
                hashMap.put(ch[i], 1);
            }else {
                count = hashMap.get(ch[i]);
                hashMap.put(ch[i], ++count);
            }
        }

        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()){
            if (entry.getValue() == 1){
                res = entry.getKey();
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args){
        FirstNonRepChar obj = new FirstNonRepChar();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string:");
        String input = sc.nextLine();
        System.out.println("First non-rep character:");
        System.out.println(obj.getFirstNonRep(input));
    }
}
