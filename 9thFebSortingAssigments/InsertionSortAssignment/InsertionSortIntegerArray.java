package Sorting;
import java.util.*;
public class InsertionSortIntegerArray {
	public static void main(String[] args) {
		int[] arr= {5,2,3,1,9,8,6,4};
		int n= arr.length;
		for(int i=1;i<n;i++) {
			int key=arr[i];
			int j=i-1;
			
			while(j>=0 && arr[j]>key){
				  arr[j + 1] = arr[j];
	                j = j - 1;		
		}
			 arr[j + 1] = key;
	}
	System.out.println(Arrays.toString(arr));	
	}
}



   
