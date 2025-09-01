package arrayReverse;

public class Node4{
	int data;
	Node4 next;
	Node4(int x){
		this.data =x;
	}
	Node4(Node4 next , int x){
		this.data =x;
		this.next =next;
	}
	
	public static Node4 addNode(Node4 start , int x) {
		
		if(start==null || x<start.data) {
			start = new Node4(start , x); //start null hai to arg me jakr next elemeny hojayega jo null hai	
			return start;
		}
		Node4 current = start;
		while(current.next != null) {
			if(x<current.next.data) {
				break; 
				//agr x chota hai next element ke data se to yeh loop break wrna last tk continue
			}
			current = current.next;
		}
		current.next = new Node4(current.next,x);// current to point krdega new Node ki taraf aur current.next bnjayega new Node ka next element
		return start;
	}
	
	public static Node4 copyList(Node4 start) {
		if(start==null) return null;
	
		Node4 previous = start;
		Node4 head = new Node4(previous.data);
		Node4 tail = head;
	
//		copyNode = previous; // 1 = 1
		while(previous.next != null) {
		  previous = previous.next;
		  Node4 newNode = new Node4(previous.data);
		  //abhi yeh null this isko hum ne link krdia next element se
		  tail.next = newNode;
		  //ab isko new element ka bhi next bnado
		  tail= tail.next;
		  
          
        }
		
	return head;
	}
	
	
	public static void print(Node4 start) {
		for (Node4 current = start ; current != null ; current=current.next) {

			System.out.print(current.data+" -> ");
	}
	}
		
		public static Node4 delete(Node4 start, int x) {
		 	
			if(start == null || start.data > x) {
				return start;
			}
			
			if(start.data == x) {
				return start.next;
			}
		
			for (Node4 current = start ; current != null ; current=current.next) {
				if(current.next.data > x) {
					break;
				}
				if(current.next.data == x) {
					current.next = current.next.next;
					break;
				}
			}
			return start;

	}
		
	public static Node4 deleteLast(Node4 start) {
		if(start == null) return null;
		if(start.next == null) {
			start = null;
			return start;
		}
		Node4 p = start;
	
		while(p.next.next != null) {
			p = p.next;
		}
		p.next = null;
		return start;
	}
	public static void main(String[] args) {
		Node4 start = null;
		start = start.addNode(start, 5);
		start = start.addNode(start, 1);
		start = start.addNode(start, 3);
		start = start.addNode(start, 4);
		start = start.addNode(start, 6);
		print(start);
		start = start.deleteLast(start);
		
		print(start);
		
		Node4 copyNode = copyList(start);
		print(copyNode);
	}
}
