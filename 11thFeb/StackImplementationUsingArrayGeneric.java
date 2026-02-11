package Stacks;
import java.util.*;


public class StackImplementationUsingArrayGeneric {
	public static void main(String[] args) {
		
		GenericStack<String> stack= new GenericStack<>(5);
		stack.push("Aura");
		stack.push("Zeus");
		stack.push("Dari");
		stack.push("Liam");
		stack.push("yoyo");
		
		
		
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
	}
	
	
}
//explore comparable
class GenericStack<T>{
	private T[] arr;
	private int top;
	private int size;
	
	public GenericStack(int size) {
		this.size=size;
		arr= (T[]) new Object[size];
		top=-1;
	}
	
	public void push(T value) {
		if(isFull()) {
			throw new StackOverflowError();
		}
		else {
			arr[++top]=value;
		}
	}
	
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return arr[top--];
		}
	}
	
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		else {
			return arr[top];
		}
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public boolean isFull() {
		return top==size-1;
	}
	
	public int size() {
		return top+1;
	}
	
	
	
}
