package Sorting;
import java.util.*;

public class SelectionSortIntegerArray {
	public static void main(String[] args) {
		int[] arr= {3,4,9,8,2,1,4,5};
		//SELECTION SORT FOR INTEGER ARRAY
		int n= arr.length;
		for(int i=0;i<n-1;i++) {
			int miniInd= i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[miniInd]) {
					miniInd=j;
				}
			}
			int temp= arr[i];
			arr[i]=arr[miniInd];
			arr[miniInd]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	

}
