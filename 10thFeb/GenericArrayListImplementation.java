package ArrayLists;
import java.util.*;

public class GenericArrayListImplementation{
	public static void main(String[] args) {
		MyGenericArrayList<Integer> list = new MyGenericArrayList<>();
		list.add(1);
		list.add(2);
		list.add(9);
		list.add(8);
		list.add(5);
		list.add(7);
		list.remove(2);
		list.remove(3);
		System.out.println(list.get(0));
		list.sort();
		list.print();
	
		
	}
}

class MyGenericArrayList<T> {

    private Object[] data;
    private int size;

    public MyGenericArrayList() {
        data = new Object[4];
        size = 0;
    }

    public void add(T value) {
        if (size == data.length) {
            resize();
        }
        data[size++] = value;
    }

    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) data[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;
    }

    public int search(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    
    
    private int compare(Object a, Object b) {

	    // Case 1: String 
	    if (a instanceof String && b instanceof String) {
	        String s1=(String) a;
	        String s2=(String) b;

	        int len=Math.min(s1.length(), s2.length());
	        for (int i=0; i<len; i++) {
	            if (s1.charAt(i)!=s2.charAt(i)) {
	                return s1.charAt(i)-s2.charAt(i);
	            }
	        }
	        return s1.length()-s2.length();
	    }

	    // Case 2: Numbers
	    if (a instanceof Number && b instanceof Number) {
	        double n1 = ((Number)a).doubleValue();
	        double n2 = ((Number)b).doubleValue();
	        return (int) (n1-n2);
	    }
	    
	    // Case 3: Character
	    if (a instanceof Character && b instanceof Character) {
	        char c1 = (Character) a;
	        char c2 = (Character) b;

	        return c1 - c2;
	    }
	    
	    //Case 4: Classes
	    try {
	        var method=a.getClass().getMethod(
	                "compare",
	                a.getClass(),
	                b.getClass()
	        );
	        return (int) method.invoke(null, a, b);

	    } catch (NoSuchMethodException e) {
	        throw new RuntimeException(
	                "Class does not define compare(T,T)"
	        );
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

		
	public void sort() {
	    for (int i=1; i<size; i++) {
	        Object key=data[i];
	        int j=i-1;
	        while (j>=0 && compare(data[j],key)>0) {
	            data[j+1]=data[j];
	            j--;
	        }
	        data[j+1]=key;
	    }
	}

}
