package stack;

import stack.stackLinkedlist.Node;

public class stackArray implements stack{
	private int size;
    private Object[] arr;   
    private int capacity; 
	public stackArray(int capacity) {
	  arr = new Object[capacity];
	  this.capacity= capacity;
	  size= 0;
	}
	private void resize() {
		Object[] a = new Object[2*capacity];
		System.arraycopy(arr, 0, a, 0, size);
		arr = a;
	}
	public void push(Object val) {
		if(size == capacity) {
			resize();
		}
		arr[size++]=val;
		
	}
	public Object peek() {
		if(size == -1)throw new IllegalArgumentException("It is empty");
		return arr[size-1];
	}
	public Object pop() {
		if(size == 0)throw new IllegalArgumentException("It is empty");
		Object old = arr[--size];
		arr[size]=null;
		return old;
	}
	public int size() {
		return size;
	}
	void deleteLAst() {
		if(size == -1)throw new IllegalArgumentException("It is empty");
		for(int i =1 ; i < size ; i++) {
			arr[i-1]= arr[i];
		}
		arr[size--] = null;
		
	}
	void secDeleteLAst() {
		if(size == -1)throw new IllegalArgumentException("It is empty");
		if(size == 0)throw new IllegalArgumentException("1 element");
		for(int i = 2 ; i < size ; i++) {
			arr[i-1]= arr[i];
		}
		arr[size--] = null;
		
	}
	public stackLinkedlist toLinkedStack(){
		stackLinkedlist convert = new stackLinkedlist();
//		Object[] arrayStack = new Object[size];
		
		for(int i = size-1 ; i <= 0 ; i++) {
			convert.push(arr[i]);
		
		}
//		arrayStack = reverseStack(arrayStack);
		return convert;
	}
	public void printStack() {
	    for (int i = size; i >= 0; i--) {
	        System.out.print(arr[i] + " ");
	    }
	    System.out.println();
	}
	  public static void main(String[] args) {
	        stackArray st = new stackArray(10);
	        st.push(1);
	        st.push(2);
	        st.push(3);
	        st.push(4);
	        st.push(5);

	        System.out.println("Peek: " + st.peek());
	        System.out.println("Size: " + st.size());


	  }
	  }
