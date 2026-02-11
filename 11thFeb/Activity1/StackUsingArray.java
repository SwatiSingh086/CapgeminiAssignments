package Activity1;

import java.util.EmptyStackException;

public class StackUsingArray {
	public static void main(String[] args) {
		MyStack stack= new MyStack(5);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isFull());
		System.out.println(stack.size());
		
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
