package Sorting;

class Student{
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
	}}
	
public class BubbleSortObjects {
	public static void main(String[] args) {
		//SORTING OBJECTS
		Student[] arr1= {
				new Student(12,"Zeus"),
				new Student(13,"Aurelia"),
				new Student(16,"Darius"),
				new Student(18,"Levi"),
				new Student(11,"Olivia")
		};
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1.length-i-1;j++) {
				if(arr1[j].getMarks()>arr1[j+1].getMarks()) {
					Student temp= arr1[j];
					arr1[j]=arr1[j+1];
					arr1[j+1]=temp;
					
				}
			}
		}
	}	
}

