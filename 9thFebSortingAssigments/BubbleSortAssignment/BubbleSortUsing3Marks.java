package Sorting;
import java.util.*;

public class BubbleSortUsing3Marks {

    public static void main(String[] args) {

        Student1[] arr2 = {
            new Student1(88, 99, 100, "Geto"),
            new Student1(36, 67, 32, "Gojo"),
            new Student1(90, 32, 45, "Choso"),
            new Student1(23, 14, 45, "Toji"),
            new Student1(12, 14, 45, "Mahito")
        };

        // BUBBLE SORT USING 3 MARKS
        int n = arr2.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {

                if (
                    arr2[j].getJavaMarks() > arr2[j + 1].getJavaMarks()
                    ||
                    (arr2[j].getJavaMarks() == arr2[j + 1].getJavaMarks()
                        && arr2[j].getcMarks() > arr2[j + 1].getcMarks())
                    ||
                    (arr2[j].getJavaMarks() == arr2[j + 1].getJavaMarks()
                        && arr2[j].getcMarks() == arr2[j + 1].getcMarks()
                        && arr2[j].getFsMarks() > arr2[j + 1].getFsMarks())
                ) {
                    
                    Student1 temp = arr2[j];
                    arr2[j] = arr2[j + 1];
                    arr2[j + 1] = temp;
                }
            }
        }

     
        for (Student1 s : arr2) {
            System.out.println(s);
        }
    }
}


 class Student1{
	
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


	

