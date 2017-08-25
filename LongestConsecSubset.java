import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 Given a set of numbers, find the longest subset of consecutive numbers.

 Example:
 Input:
 1 3 8 14 4 10 2 11
 Output:
 1 2 3 4
 */

public class LongestConsecSubset {

    private ArrayList<Integer> getLongestSubset(int[] nums, int n){
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        ArrayList<Integer>  temp = new ArrayList<>();
        int max =0;
        for (int ind =0 ; ind< nums.length; ind++){
            hashSet.add(nums[ind]);
        }

        for (Integer ele : hashSet){
            if (!hashSet.contains(ele-1)){
               temp.clear();
                while (hashSet.contains(ele)){
                    temp.add(ele);
                    ele++;
                }
                if (temp.size() >= max){
                    max = temp.size();
                    subset.addAll(temp);                            //Outputs subsets of equal lengths
                    //subset = (ArrayList<Integer>)temp.clone();
                }
            }
        }
        return subset;
    }

    public static void main(String[] args){
        LongestConsecSubset obj = new LongestConsecSubset();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the no.:");
        int n = scanner.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter the array elem:");
        for (int i=0;i<n;i++)
            nums[i] = scanner.nextInt();

        System.out.println("Longest subset of consecutive no.");
        ArrayList<Integer> res  = obj.getLongestSubset(nums, n);
        for (Integer el : res){
            System.out.print(el + " ");
        }
    }
}
