package ArrayLists;

import java.util.Arrays;

public class ArrayListImplementation {
	
	public static void main(String[] args) {
		MyArrayList list= new MyArrayList();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		list.print();
		System.out.println(list.get(3));
		list.remove(0);
		list.print();
		list.sort();
		System.out.println(list.search(2));
		list.print();
	}
}
//do this with generics
class MyArrayList{
	private int[] data;
	private int size;
	
	public MyArrayList() {
		data= new int[4];
		size=0;
	}
	
	public void add(int value) {
		if(size==data.length) {
			resize();
		}
		data[size]=value;
		size++;
	}
	
	private void resize() {
		int[] newData= new int[data.length*2];
		for(int i=0;i<data.length;i++) {
			newData[i]=data[i]; //copying
		}
		data=newData;
	}
	
	public void print() {
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println("");
	}
	
	public int get(int index) {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException();
		}
		return data[index];
	}
	
	public void remove(int index) {
		if(index<0||index>=size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			for(int i=index;i<size;i++) {
				data[i]=data[i+1];
			}
			size--;
		}
	}
	
	public int search(int value) {
		
		for(int i=0;i<size;i++) {
			if(data[i]==value) {
				return i;
			}
		}
		return -1;
		
	}
	
	public void sort() {

		for(int i=1;i<size;i++) {
			int key=data[i];
			int j=i-1;
			while(j>=0 && data[j]>key){
				  data[j + 1] = data[j];
	                j = j - 1;		
		}
			 data[j + 1] = key;
	}
	}
	

	@Override
	public String toString() {
		return "MyArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
	}
	
	
}