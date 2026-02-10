package Activity1;
import java.util.*;

public class TaskAArrayList {
	public static void main(String[] args) {
		
		ArrayList<Integer> marks= new ArrayList<>();
		marks.add(87);
		marks.add(99);
		marks.add(100);
		marks.add(90);
		marks.add(76);
		
		marks.add(2, 88);
		
		int lowest= Collections.min(marks);
		Iterator<Integer> itr = marks.iterator();
        while (itr.hasNext()) {
            if (itr.next() == lowest) {
                itr.remove();
            }
        }
        
        System.out.println(marks);
		
	}
}
