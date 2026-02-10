package Activity2;
import java.util.*;

public class TaskAArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<>();
		//add 10 numbers
		list.add(1);
		list.add(3);
		list.add(6);
		list.add(7);
		list.add(2);
		list.add(5);
		list.add(9);
		list.add(10);
		list.add(4);
		list.add(8);
		
		//remove all even numbers
		Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0) {
                itr.remove();
            }
        }
        //max and min
        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        
        //sort in descending order
        list.sort((a,b)->Integer.compare(b, a));
        System.out.println(list);
        
        
        
	}

}
