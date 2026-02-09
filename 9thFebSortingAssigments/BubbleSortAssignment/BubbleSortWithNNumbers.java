package Sorting;
import java.util.*;


public class BubbleSortWithNNumbers {
	
	  public static void bubbleSort(Student2[] arr, int n) {
	        if (n == 1) return;

	        for (int i = 0; i < n - 1; i++) {
	            if (ifSwap(arr[i], arr[i + 1])) {
	                Student2 temp = arr[i];
	                arr[i] = arr[i + 1];
	                arr[i + 1] = temp;
	            }
	        }

	        bubbleSort(arr, n - 1);
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
		Student2[] arr2= {
			new Student2("Aurelia",new int[]{99,88,98,97}),
			new Student2("Heather",new int[]{97,90,92,91}),
			new Student2("Irene",new int[]{80,82,75,98}),
			new Student2("Lilith",new int[]{100,99,98,97}),
			new Student2("Amara",new int[]{80,70,72,80})
		};
		 bubbleSort(arr2, arr2.length);

	        for (Student2 s : arr2) {
	            System.out.println(s);
	        }
	}
	
}

class Student2{
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
	
	
}

