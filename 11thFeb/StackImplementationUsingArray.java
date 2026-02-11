package Stacks;

import java.util.EmptyStackException;

public class StackImplementationUsingArray {

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
