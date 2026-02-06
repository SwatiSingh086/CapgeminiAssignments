package Arrays;
import java.util.*;
public class RotateMatrix90 {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		int n= sc.nextInt();
		int[][] arr= new int[n][n];
		
		for(int i =0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]= sc.nextInt();	
			}
		}
		
		for (int i = 0; i < n; i++) {
		    for (int j = i; j < n; j++) {
		        int temp = arr[i][j];
		        arr[i][j] = arr[j][i];
		        arr[j][i] = temp;
		    }
		}

	
		for (int i = 0; i < n; i++) {
		    int left = 0;
		    int right = n - 1;
		    while (left < right) {
		        int temp = arr[i][left];
		        arr[i][left] = arr[i][right];
		        arr[i][right] = temp;
		        left++;
		        right--;
		    }
		}

	}

}
