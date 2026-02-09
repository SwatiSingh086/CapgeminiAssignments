package Sorting;
import java.util.*;
public class SelectionSortUsing3Numbers {
	public static void main(String[] args) {

        Student1[] arr = {
            new Student1(90, 99, 100, "Geto"),
            new Student1(36, 67, 32, "Gojo"),
            new Student1(90, 99, 45, "Choso"),
            new Student1(23, 14, 45, "Toji"),
            new Student1(12, 14, 45, "Mahito")
        };

		
		
		for(int i=0;i<arr.length;i++) {
			int min= i;
			for(int j=i;j<arr.length;j++) {
				if(
						arr[j].getJavaMarks() > arr[min].getJavaMarks() ||

				        (arr[j].getJavaMarks() == arr[min].getJavaMarks() &&
				         arr[j].getFsMarks() > arr[min].getFsMarks()) ||

				        (arr[j].getJavaMarks() == arr[min].getJavaMarks() &&
				         arr[j].getFsMarks() == arr[min].getFsMarks() &&
				         arr[j].getcMarks() > arr[min].getcMarks())
				  ) {
					min=j;
				}
			}
			Student1 temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
		for(Student1 s: arr) {
			System.out.println(s);
		}
		
	}

}

/* class Student1{

int javaMarks;
int cMarks;
int fsMarks;
String name;
@Override
public String toString() {
	return "Student1 [name=" + name + ", javaMarks=" + javaMarks + ", cMarks=" + cMarks + ", fsMarks=" + fsMarks
			+ "]";
}

public Student1(int javaMarks, int cMarks, int fsMarks, String name) {
	super();
	this.javaMarks = javaMarks;
	this.cMarks = cMarks;
	this.fsMarks = fsMarks;
	this.name = name;
}

public String getName() {
	 return name;
}
public void setName(String name) {
	 this.name = name;
}
public int getJavaMarks() {
	 return javaMarks;
}
public void setJavaMarks(int javaMarks) {
	 this.javaMarks = javaMarks;
}
public int getcMarks() {
	 return cMarks;
}
public void setcMarks(int cMarks) {
	 this.cMarks = cMarks;
}
public int getFsMarks() {
	 return fsMarks;
}
public void setFsMarks(int fsMarks) {
	 this.fsMarks = fsMarks;
}
}

*/


