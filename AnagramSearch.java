import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 Given two strings 'pattern' and 'text', find whether any anagram of string pattern is a substring of text.

 Example:
 Input:
 text = ideserve
 pattern = veer
 Output:
 true
 */
public class AnagramSearch {
    static HashMap<Character, Integer> patternHash = new HashMap<>();
    static HashMap<Character, Integer> textHash = new HashMap<>();

    public static HashMap<Character, Integer> getPatternHash(String pattr){
        for (char ch: pattr.toCharArray()) {
            if (!patternHash.containsKey(ch)) {
                patternHash.put(ch, 1);
            } else {
                int temp = patternHash.get(ch);
                patternHash.put(ch, ++temp);
            }
        }
        return patternHash;
    }

    public static HashMap<Character, Integer> getTextHash(int k, String text, int len){
        String subText = text.substring(k, k+ len);
        textHash.clear();
        for (char ch: subText.toCharArray()) {
            if (!textHash.containsKey(ch)) {
                textHash.put(ch, 1);
            } else {
                int temp = textHash.get(ch);
                textHash.put(ch, ++temp);
            }
        }
        return textHash;
    }
    public static boolean getAnagramPatternSearch(String text, String pattern){
        HashMap<Character, Integer> pattrHashValue = getPatternHash(pattern);
        int len = pattern.length();
        for (int i=0 ; i <=text.length() - pattern.length(); i++){
            if (getTextHash(i, text, len).equals(pattrHashValue)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Enter pattern: ");
        String pattern = sc.nextLine();
        System.out.println("Output : " + getAnagramPatternSearch(text, pattern));
    }
}
