package Arrays;
import java.util.*;
public class Tranpose {
public static void main(String[] args) {
	

	        Scanner sc = new Scanner(System.in);

	        int r = sc.nextInt();
	        int c = sc.nextInt();
	      
	        int[][] arr = new int[r][c];

	      
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	                arr[i][j] = sc.nextInt();
	            }
	        }

	        int[][] trans = new int[c][r];
	       
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	                trans[j][i] = arr[i][j];
	            }
	        }
	        
	        for (int i = 0; i < c; i++) {
	            for (int j = 0; j < r; j++) {
	                System.out.print(trans[i][j] + " ");
	            }
	            System.out.println();
	        }
	    
}
}
