import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

/**
 Given a sorted matrix where rows and the columns are sorted.
 Write an algorithm to search an element in the matrix in O(n).
 */

public class SearchSortedMatrix {

    private boolean searchSortedMatrix(int[][] matrix, int n, int key){
        int r=0, c = n-1;
        while (r<=n-1 && c>=0){
            if (matrix[r][c] < key)
                r++;
            else if (matrix[r][c] > key)
                c--;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        SearchSortedMatrix obj = new SearchSortedMatrix();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix order:");
        int n = sc.nextInt();
        int input[][] = new int[n][n];
        System.out.println("Enter the elements");
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                input[i][j] = sc.nextInt();
        }
        System.out.println("Enter search element:");
        int ele = sc.nextInt();

        System.out.println(obj.searchSortedMatrix(input, n, ele));
    }
}
