package arrayReverse;
import java.util.Queue;
import java.util.LinkedList;

import java.util.Random;


public class Node6 {
	private int data;
	Node6 next;
	public Node6(int data) {
		this.data = data;
	}
	public Node6(int data,Node6 next) {
		this.data = data;
		this.next=next;
//		2nd element = old 1st start
	}
	public Node6 addNode(Node6 start,int x) {
		if(start==null|| x<start.data) {
			start = new Node6(x,start);
			return start;
		}
		Node6 current = start;
		while(current.next!=null) {
			if(x<current.next.data) {
				break;
			}
			current= current.next;
	}
		
		current.next = new Node6(x,current.next);
		return start;
	}
	public void print() {
		Node6 current = this;
		while(current!=null) {
			System.out.print(current.data+" ");
		current = current.next;
		}
		System.out.print("\n");
	}
	public Node6 delete(Node6 start, int x) {
		Node6 current = start;
		if(current.data==x) current =current.next;
		while(current.next!=null) {
			if(current.next.data == x) {
				current.next=current.next.next ;
			break;
			}
		current = current.next;
		
		}
		return start;
	}
	public Node6 deleteLast(Node6 start) {
		Node6 current = start;
		if(current.next == null)return current.next;
		while(current.next.next!=null) {
			current = current.next;
			}
		current.next = null;
		return start;
	}
	public Node6 concate(Node6 n1,Node6 n2) {
		Node6 n1End = n1;
		while(n1End.next!=null) {
			n1End = n1End.next;
			}
			n1End.next=n2;
		return n1;
	}
	public static Node6 shuffle(Node6 start) {
		if(start==null)return start;
		Node6 p = start;
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
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

		}
		p = start;
	 	for(i =0 ; i < arr.length ; i++) {
	 		
			p.data = arr[i]; 
			p = p.next;
		}
		
		
		return start;
	}
	public Node6[] bifurcate(Node6 start) {
		Node6[] nodes =new Node6[2];
		int count  = 0 ;
		Node6 p = start;
		while(p!=null) {
			count++;
			p =p.next;
		}
		int i = count/2;
		count =0 ;
		Node6 f = null;
		Node6 s = null;
		for(p = start ; p!=null; p = p.next){
			if(count<i) {
				f=addNode(f,p.data);
			}
			else {
					s=addNode(s,p.data);
				
			}
			count++;
		}
		nodes[0]=f;
		nodes[1]=s;
		return nodes;
	}
	public Node6 copy() {
		Node6 copyNode = null;
		for(Node6 p = this ; p!=null; p = p.next){
			copyNode = addNode(copyNode,p.data);
		}
		return copyNode;
	}
	public Node6[] nfurcate(Node6 start , int divide) {
		
		
		int count  = 0 ;
		Node6 p = start;
		while(p!=null) {
			count++;
			p =p.next;
		}
		int arrayNum = count/divide;
		Node6[] nodes =new Node6[divide];
		count =0 ;
		Node6 temp = null;
		int i = 0;
		for(p = start ; p!=null; p = p.next){
			if(i<nodes.length) {
				nodes[i]=addNode(nodes[i],p.data);
				count++;
				if(count==arrayNum) {
					count = 0;
					i++;
					 temp = p.next;
				}
			}

				}
		 
		    for (p = temp;  p != null; p = p.next) {
		        nodes[nodes.length-1] = addNode(nodes[nodes.length-1], p.data);
		        
		    }		
					
		return nodes;
	
	}
	public Node6[] EvenOdd(Node6 start) {
		
		
		Node6[] nodes =new Node6[2];
		
		for(Node6 p = start ; p!=null; p = p.next){
			if(p.data%2==0) {
				nodes[0]=addNode(nodes[0],p.data);
				}
			else {
				nodes[1]=addNode(nodes[1],p.data);
			}

				}
		 
		
		return nodes;
	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Queue<Integer> q = new LinkedList<>();

		Node6 n1 = new Node6(2);
		n1=n1.addNode(n1, 3);
		n1=n1.addNode(n1, 1);
		n1=n1.addNode(n1, 5);
		n1=n1.addNode(n1, 4);
//		n1.print();
//		n1=n1.delete(n1,2);
//		n1.print();
//		n1=n1.deleteLast(n1);
//		n1.print();
		Node6 n2 = new Node6(7);
		n2=n2.addNode(n2, 8);
		n2=n2.addNode(n2, 9);
		n2=n2.addNode(n2, 10);
		n2=n2.addNode(n2, 6);
		n1=n1.concate(n1,n2)  ;
		n1.print();
//		n1=n1.shuffle(n1);
//		n1.print();
		Node6[] nodes =new Node6[2];
		nodes = n1.bifurcate(n1);
		nodes[0].print();
		nodes[1].print();
		Node6 copied = n1.copy();
		copied.print();
		nodes = n1.nfurcate(n1,4);
		for(int i = 0 ; i <nodes.length;i++){
			nodes[i].print();
		}
		nodes = n1.EvenOdd(n1);
		nodes[0].print();
		nodes[1].print();
		
	}

}
