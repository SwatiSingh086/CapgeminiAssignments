package Sorting;

public class InsertionSortUsing3Numbers {
	public static void main(String[] args) {
		
		 Student1[] arr = {
		            new Student1(88, 99, 100, "Geto"),
		            new Student1(36, 67, 32, "Gojo"),
		            new Student1(90, 32, 45, "Choso"),
		            new Student1(23, 14, 45, "Toji"),
		            new Student1(88, 14, 45, "Mahito")
		        };
		 
		for(int i=1;i<arr.length;i++) {
			Student1 key=arr[i];
			int j=i-1;
			while(j>=0 && (
			        arr[j].getJavaMarks() < key.getJavaMarks() ||

			        (arr[j].getJavaMarks() == key.getJavaMarks() &&
			         arr[j].getFsMarks() < key.getFsMarks()) ||

			        (arr[j].getJavaMarks() == key.getJavaMarks() &&
			         arr[j].getFsMarks() == key.getFsMarks() &&
			         arr[j].getcMarks() < key.getcMarks())
			    ) ) {
				
				arr[j+1]=arr[j];
				j--; 
			}
			arr[j+1]=key;
		}
		
		for(Student1 s: arr) {
			System.out.println(s);
		}
	}

}
