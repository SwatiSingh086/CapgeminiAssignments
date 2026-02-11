package Activity2;
import java.util.*;

public class ReverseIntegerArray {
	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		MyStack stack= new MyStack(arr.length);
		for(int i: arr) {
			stack.push(i);
		}
		for(int i=0;i<arr.length;i++) {
			arr[i]=stack.pop();
		}
		System.out.println(Arrays.toString(arr));
	}
}

class MyStack{
	private int[] arr;
	private int size;
	private int top;
	
	public MyStack(int size) {
		this.size=size;
		arr= new int[size];
		top=-1;
	}
	
	
	public void push(int value) {
		if(isFull()) {
			throw new StackOverflowError();
		}
		else {
			arr[++top]=value;
			
		}
	}
	
	public int pop() {
		if(top==-1) {
			throw new EmptyStackException();
		}
		else {
			return arr[top--];
		}
	}
	
	public boolean isEmpty() {
		if(top==-1)
			return true;
		else
			return false;
	}
	
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return arr[top];
		}
	}
	
	public boolean isFull() {
		if(top==size-1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int size() {
		return top+1;
	}
	
	
	
	
}
