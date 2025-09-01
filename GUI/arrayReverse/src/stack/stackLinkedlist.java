package stack;


public class stackLinkedlist implements stack{
	static class Node{
		Object val;
		Node next;
		Node(Object obj,Node top){
			this.val =obj;
			next =top;
		}
	}
	private int size;
	Node top;
//	public stackLinkedlist() {
//		// TODO Auto-generated constructor stub
//	}
	public void push (Object obj) {
		size++;
		top = new Node(obj,top);
		//object int me nhi ho rha 
		}
	public Object peek() {
		if(size==0)throw new IllegalArgumentException("Stack is Empty");
		return top.val ;
	}
	public Object pop() {
		if(size==0)throw new IllegalArgumentException("Stack is Empty");
		Object oldTop = top.val;
		top = top.next;
		size--;
		return oldTop ;
	}
	public int size() {
		return size;
	}
	public Object deleteLast() {
		if(size==0)throw new IllegalArgumentException("Stack is Empty");;
		if(top.next == null) {
			size--;
			return top.val;}
		Node start=null;
		for(start = top; start.next.next!=null;start = start.next) {
		}
		Object del = start.next.val;
		start.next = null;
		size--;
		return del;
		
	}
	public Object deleteSecLast() {
		if(size==1)throw new IllegalArgumentException("Stack have one element");;
		if(size == 2) {
			size--;
			top.next=null;
			return top.val;}
		Node start=null;
		for(start = top; start.next.next.next!=null;start = start.next) {}
		Object del = start.next.val;
		start.next = start.next.next;
		size--;
		return del;
		
	}
	public stackArray toArrayStack() {
	    Object[] temp = new Object[size];
	    int index = 0;

	    // store nodes in array
	    for (Node start = top; start != null; start = start.next) {
	        temp[index++] = start.val;
	    }

	    // now push into stack in reverse order
	    stackArray convert = new stackArray(size);
	    for (int i = size - 1; i >= 0; i--) {
	        convert.push(temp[i]);
	    }

	    return convert;
	}
	
	public void printStack() {
		
		for(Node start = top; start!=null;start = start.next) {
		System.out.print(start.val +" ");
		}
	}
	public static void main(String [] asgs) {
		stackLinkedlist st =new stackLinkedlist();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		st.push(5);
//		Object obj = st.peek();
//		
//		System.out.println(st.peek());
//		System.out.println(st.size());
//		System.out.println(st.pop());
//		System.out.println(st.size());
//		st.deleteLast();
//		st.deleteSecLast();
//		st.deleteSecLast();
//		st.deleteSecLast();
//		st.printStack();
//	
	   stackArray x= st.toArrayStack();  
	   x.printStack();
	}
	}
	

