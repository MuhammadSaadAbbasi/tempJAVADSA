package queue;

public class Queue1 {
	Node head = new Node(null);
	int size =0 ;
	private static class Node{
		Object obj;
		
		Node prev = this;
		Node next = this;
		Node(Object obj){
			this.obj =obj;
		}
		Node(Object obj,Node prev ,Node next){
			this.obj =obj;
			this.next =next;
			this.prev =prev;
			
		}
	}
	public void add(Object obj) {
		head.prev.next= new Node(obj,head.prev,head);
		head.prev = head.prev.next;
		size++;
	}
	public Object remove() {
		if(size==0)throw new IllegalArgumentException("Empty");
		Object kachra = head.next.obj;
		head.next =head.next.next;
		head.next.prev = head;
		size--;
		//inside head.next we have ref of head
		return kachra;
	}
	int size() {
		return size;
	}
	public Object removeFifth() {
		if(size==0)throw new IllegalArgumentException("Empty");
		if(size<=4)throw new IllegalArgumentException("no fifith element");
		Node start=null;
		int i =0;
		for(start = head.next; start!= head; start= start.next ) {
			System.out.println("Visiting: " + start.obj);
			i++;
			if(i==5) {
				break;
			}
			
		}
		Object kachra = start.obj;
		start.prev.next = start.next;
		start.next.prev =start.prev;
		System.out.println(start.prev.obj);
		//inside head.next we have ref of head
		size--;
		return kachra;
	}
	public Object removeN(int n) {
		if(size==0)throw new IllegalArgumentException("Empty");
		if(size<=n)throw new IllegalArgumentException("no nth element");
		Node start=null;
		int i =0;
		for(start = head.next; start!= head; start= start.next ) {
			i++;
			if(i==n) {
				break;
			}
			
		}
		Object kachra = start.obj;
		start.prev.next = start.next;
		start.next.prev =start.prev;
		//inside head.next we have ref of head
		size--;
		return kachra;
	}

	public Queue1 clone(Queue1 cloned) {
		Node start=null ;
		for(start= this.head.next ; start!= head; start= start.next ) {
			cloned.add(start.obj);
		}
		return cloned;
		}
		
	public Queue1 reverse(Queue1 reversed) {
		Node start=null ;
		for(start= this.head.prev ; start!= head; start= start.prev ) {
			reversed.add(start.obj);
		}
		return reversed;
		}
	public Queue1[] OddEven() {
		if(size==0)throw new IllegalArgumentException("Empty");
		Queue1[] collection = new Queue1[2];
		collection[0] = new Queue1();
		collection[1] = new Queue1();
		Node start=null ;
		int i =1;
		for(start= this.head.next ; start!= head; start= start.next ) {
			if(i%2==0) {
				collection[0].add(start.obj);
			}
			else collection[1].add(start.obj);
			
			i++;
		}
		
		return collection;
		}
		boolean compare(Queue1 x) {
			if(x.size==this.size)return true;
			return false;
		}
		Object[] arr() {
	    	Object[] arrQ = new Object[size];
	    	Node start=this.head.next;
	    	for(int i =0 ;i<size ;i++) {
	    		arrQ[i]=start.obj;
	    		start=start.next;
	    	}
	    	return arrQ;
	    }
	int times() {
	    int i = 0;
//	    for (Node start = head; start != head.prev.next; start = start.next) {
//	        System.out.println("Visiting: " + start.obj); // debug
//	        i++;
//	    }
	    
	    System.out.println("Visiting: " + head.obj);
	    System.out.println("Visiting: " + head.next.obj);
	    System.out.println("Visiting: " +  head.next.next.obj);
	    System.out.println("Visiting: " + head.next.next.next.obj);
	    System.out.println("Visiting: " + head.next.next.next.next.obj);
	    System.out.println("Visiting: " +  head.next.next.next.next.next.obj);
	    System.out.println("Visiting: " +  head.next.next.next.next.next.next.obj);
	    System.out.println("Visiting: " +  head.next.next.next.next.next.next.next.obj);
	    System.out.println("Visiting: " +  head.next.next.next.next.next.next.next.next.obj);

	    return i;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node start = this.head.next;
		while(start!=head) {
			sb.append("["+start.obj+"]---->");
			start=start.next;
		}
		return sb.toString();
		
	}


	public static void main(String[] args) {
		Queue1 q = new Queue1();

        // Add some elements
        q.add("Apple");
        q.add("Banana");
        q.add("Cherry");
        q.add("orange");
        q.add("sasassd");
        
//        System.out.println("Removed: " + q.removeFifth());
//        System.out.println(q.times());
         Queue1 q1=new Queue1();
         q.reverse(q1);
         Queue1 q2=new Queue1();
         q.clone(q2);
         
         System.out.println(q);
         System.out.println(q1);
         System.out.println(q2);
         System.out.println(q2.compare(q));
         Queue1[] c = q.OddEven();
         System.out.println(c[0]);
         System.out.println(c[1]);
         Object[] x = q.arr();
         for(Object i :x) {
        	 System.out.println(i);
         }
         System.out.println("Removeed" + q.removeN(3));
//        System.out.println("Queue size after adding: " + q.size());

        // Remove elements one by one
//        System.out.println("Removed: " + q.remove()); // Apple
//        System.out.println("Removed: " + q.remove()); // Banana
//
//        System.out.println("Queue size now: " + q.size());

        // Add again
//        q.add("Dates");
//        System.out.println("Removed: " + q.remove()); // Cherry
//        System.out.println("Removed: " + q.remove()); // Dates

        // Try removing from empty queue (will throw exception)
//        try {
//            q.remove();
//        } catch (IllegalArgumentException e) {
//            System.out.println("Exception: " + e.getMessage());
//        }
	}
}
