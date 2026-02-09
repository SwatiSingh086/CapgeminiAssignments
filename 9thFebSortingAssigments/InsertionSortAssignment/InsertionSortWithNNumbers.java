package Sorting;
import java.util.*;

public class InsertionSortWithNNumbers {
	 public static void insertionSort(Student2[] arr, int n) {
		   for(int i=1;i<n;i++) {
			   Student2 key= arr[i];
			   int j= i-1;
			   while(j>=0 && ifSwap(arr[j],key)) {
				   arr[j+1]=arr[j];
				   j--;
			   }
			   arr[j+1]=key;
		   }
	   }

	    private static boolean ifSwap(Student2 s1, Student2 s2) {
	        int[] m1 = s1.getMarks();
	        int[] m2 = s2.getMarks();

	        int len = Math.min(m1.length, m2.length);

	        for (int i = 0; i < len; i++) {
	            if (m1[i] < m2[i]) return true;
	            if (m1[i] > m2[i]) return false;
	        }
	        return false;
	    }
	    public static void main(String[] args) {
	    	Student2[] arr= {
					new Student2("Zeus",new int[] {90,95,99,100}),
					new Student2("Aurelia",new int[] {90,88,90,97}),
					new Student2("Ryuga",new int[] {92,97,90,80}),
					new Student2("Heather",new int[] {89,70,90,88}),
					new Student2("Liam",new int[] {99,90,70})
			};
			int n=arr.length;
			insertionSort(arr,n);
	
			for(Student2 s: arr) {
				System.out.println(s);
			}
	    }
}

/*class Student2{
String name;
int marks[];
public Student2(String name, int[] marks) {
	super();
	this.name = name;
	this.marks = marks;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int[] getMarks() {
	return marks;
}
public void setMarks(int[] marks) {
	this.marks = marks;
}
@Override
public String toString() {
	return "Student2 [name=" + name + ", marks=" + Arrays.toString(marks) + "]";
}	
}*/
