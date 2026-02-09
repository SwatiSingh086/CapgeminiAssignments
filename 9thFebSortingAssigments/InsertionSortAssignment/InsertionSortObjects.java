package Sorting;
import java.util.*;

public class InsertionSortObjects {
	public static void main(String[] args) {
	Student[] arr= {
			new Student(87,"Liam"),
			new Student(99,"Darius"),
			new Student(98,"Zeus"),
			new Student(95,"Ryuga"),
			new Student(89,"Levi")
	};
	
	int n=arr.length;
	for(int i=1;i<n;i++) {
		Student key=arr[i];
		int j=i-1;
		while(j>=0 && arr[j].getMarks()<key.getMarks()) {
			arr[j+1]=arr[j];
			j=j-1;
		}
		arr[j+1]=key;
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
