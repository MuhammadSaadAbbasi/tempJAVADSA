package arrayReverse;


public class Node2 {
	private int data;
	private Node2 next;
	Node2(int data){
	this.data =data;
	}
	public static void main(String [] args) {
		Node2 start = new Node2(11);
		Node2 p = start;
		
		
//		p = new Node2(15);
//		p = p.next;
//		
//		p = new Node2(20);
//		p = p.next;
//		
//		p = new Node2(25);
//		p = p.next;
//		Repeating like structure
		
		for (int i = 0 ; i < 9 ; i++) {
			
			p.next = new Node2(11 * (i+2));
			p = p.next;
		}
		
		for (p = start ; p != null ; p=p.next) {

				System.out.println(p.data);
		}
	}
 
}
