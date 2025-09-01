package arrayReverse;



public class Node {
	private int data;
	private Node next;
	Node(int data){
	this.data =data;
	}
	public static void main(String [] args) {
		Node start = new Node(5);
		start.next = new Node(10);
		start.next.next = new Node(15);
		start.next.next.next = new Node(20);
	    System.out.println(start.data +" "+start.next.data +" "+start.next.next.data +" " + start.next.next.next.data);
	}
 
}
