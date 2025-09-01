
package arrayReverse;
import java.util.*;


public class Node5 {
	int data;
//	static int size =0 ;
	Node5 next;
	Node5(int x){
		this.data =x;
	}
	Node5(Node5 next , int x){
		this.data =x;
		this.next =next;
	}
	
	public static Node5 addNode(Node5 start , int x) {
		
		if(start==null || x<start.data) {
			start = new Node5(start , x); //start null hai to arg me jakr next elemeny hojayega jo null hai	
			return start;
		}
		Node5 current = start;
		while(current.next != null) {
			if(x<current.next.data) {
				break; 
				//agr x chota hai next element ke data se to yeh loop break wrna last tk continue
			}
			current = current.next;
		}
		current.next = new Node5(current.next,x);// current to point krdega new Node ki taraf aur current.next bnjayega new Node ka next element
		return start;
	}
	public static Node5 concat(Node5 start , Node5 start1) {
		
		if(start==null)return start;
		if(start1==null)return start1;
		
		Node5 p = start;
		Node5 q = start1;
		while(p.next != null) {
			p = p.next;
		}
		p.next = q;
		
		
		return start;
	}
	
	public static void print(Node5 start) {
		for (Node5 current = start ; current != null ; current=current.next) {

			System.out.print(current.data+" -> ");
	}
		
	}
	public static Node5 replace(Node5 start , int x, int y) {
	 	Node5 p =start;
	 	while(p != null) {
			if(p.data == x) {
				p.data = y ;
				break;
			}
			p = p.next;
		}
		return start;
	}

	public static Node5 shuffle(Node5 start) {
		if(start==null)return start;
		Node5 p = start;
		int count = 0;
		
		while(p!=null) {
			count++;
			p =p.next;
		}
		
		int [] arr = new int[count];
		int  i=0;	
		for (p = start ; p != null ; p=p.next) {
			
			arr[i] = p.data;
			i++;
		}
		
		Random rand = new Random();
		for(i=count-1 ; i >0  ; i--) {
			int j = rand.nextInt(i+1);
		    arr[i]=arr[i] ^ arr[j];
		    arr[j]=arr[i] ^ arr[j];
		    arr[i]=arr[i] ^ arr[j];
		}
		p = start;
	 	for(i =0 ; i < arr.length ; i++) {
	 		
			p.data = arr[i]; 
			p = p.next;
		}
		
		
		return start;
	}

	public static Node5 reverse(Node5 start) {
		if(start==null)return start;
		Node5 p = start;
		int count = 0;
		
		while(p!=null) {
			count++;
			p =p.next;
		}
		
		int [] arr = new int[count];
		int  i=0;	
		for (p = start ; p != null ; p=p.next) {
			
			arr[i] = p.data;
			i++;
		}
		p=start;
		for( i = count-1 ; i >= 0 ; i--) {
			p.data = arr[i];
			p=p.next;
			
		}
	   
			
		
		return start;
	}
	
	public static Node5[] split(Node5 start) {
		
        if(start==null)return null;
        Node5 [] nodeArray = new Node5[2];
		Node5 p = start;
		int count = 0;
		
		while(p!=null) {
			count++;
			p =p.next;
		}
		int f = count/2;
		Node5 first = null;
		Node5 second = null;
		int i = 0;
		for (p = start ; p != null ; p=p.next) {
			if(i<f) {
				first = addNode(first, p.data);
			}
			else if(i >= f) {
				second = addNode(second, p.data);
			}
			i++;
		}
			
		nodeArray[0]=first;
		nodeArray[1]=second;
		return nodeArray;
	}
	
	public static Node5[] nFircute(Node5 start,int times) {
		int size=0;
		if(start==null)return null;
		
		Node5 p = start;
		while(p !=null) {
			size++;
			p =p.next;
		}
		
		int arraySize = size/times;
		int remain = size%times;
		Node5[] splittedNodes =  new Node5[times];
		
		int i = 0;
		int j;
		
		for(j=1,p = start ; p != null ; p=p.next ,j++) {
			
			if(i>=splittedNodes.length)break;
			splittedNodes[i] = 	addNode(splittedNodes[i], p.data);
			
			
			if (j==arraySize) {
				i++;
				j=0;
			}
			
			}
	    for ( i = 0; i < remain; i++) {
	        if (p == null) break;
	        splittedNodes[i] = addNode(splittedNodes[i], p.data);
	        p = p.next;
	    }


		return splittedNodes;
		
	}

	public static Node5 customNode(Node5 start){
		for(int i = 1; i <= 100;i++) {
			start = addNode(start,i);
		}
		return start;
	}
	
	
	public static void main(String [] args) {
		Node5 start = null;
//		start = addNode(start, 5);
//		start = addNode(start, 1);
//		start = addNode(start, 3);
//		start = addNode(start, 4);
//		start = addNode(start, 6);
//	
//		Node5 start1 = null;
//		start1 = addNode(start1, 7);
//		start1 = addNode(start1, 9);
//		start1 = addNode(start1, 8);
//		start1 = addNode(start1, 10);
//		start1 = addNode(start1, 11);
//	
//		Node5 concateNode = concat(start, start1);
//		print(concateNode);
//		
//		start= replace(start, 3, 2);
//		System.out.println("\n");
//		print(start);
//		
//		System.out.println("\n");
//		start=start.shuffle(start);
//		print(start);
//		
//		start= reverse(start);
//		print(start);
//	
//		Node5 [] splittedNode =split(start);
//		System.out.println("\n");
//		print(splittedNode[0]);
//		System.out.println("\n");
//		print(splittedNode[1]);
//	}
//	
//
		start = customNode(start);
		print(start);
		Node5[] nodeArray = nFircute(start,15);
		for(int i = 0 ; i < nodeArray.length;i++) {
			System.out.println("\n");
			print(nodeArray[i]);
		}
		}
	}
