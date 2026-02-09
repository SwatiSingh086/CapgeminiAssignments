package Sorting;
import java.util.*;


public class SelectionSortObjects {
	public static void main(String[] args) {
		Student[] arr= {
				new Student(99,"Zeus"),
				new Student(90,"Levi"),
				new Student(100,"Darius"),
				new Student(95,"Malfoy"),
				new Student(97,"Ryuga"),
		};
		
		int n= arr.length;
		for(int i=0;i<n-1;i++) {
			int miniInd=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j].getMarks()<arr[miniInd].getMarks()) {
					miniInd=j;
				}
			}
			Student temp= arr[i];
			arr[i]=arr[miniInd];
			arr[miniInd]=temp;
		}
		for(Student s: arr) {
			System.out.println(s);
		}
		
	}

}

/*class Student{
	int marks;
	String name;
	public Student(int marks, String name) {
		super();
		
		this.marks = marks;
		this.name = name;}

	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [marks=" + marks + ", name=" + name + "]";
	}}*/