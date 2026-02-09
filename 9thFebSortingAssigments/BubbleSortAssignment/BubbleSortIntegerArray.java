package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortIntegerArray {
	public static void main(String[] args) {
		int[] arr= {1,4,2,3,8,6,5};
		int n= arr.length;
		
		//SORTING INTEGER ARRAY
		for(int i=0;i<n;i++) {
			for(int j=1;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	Scanner sc= new Scanner(System.in);
}}
