package queue;

public class Queue {
	private Node head = new Node(null);
	private int size;
	private static class Node{
		Object obj;
		Node prev = this;
		Node next=this;
		Node(Object obj){
			this.obj=obj;
		}
		Node(Object obj,Node prev,Node next){
			this.obj=obj;
			this.prev =prev;
			this.next=next;
		}
	}
//	public Queue() {
//		// TODO Auto-generated constructor stub
//	}
	public void add(Object obj) {
		head.prev.next = new Node(obj, head.prev,head);
		head.prev =head.prev.next;
		++size;
	}
	public Object remove() {
		if(size==0)throw new IllegalArgumentException("Empty");
		Object temp = head.next.obj;
		head.next = head.next.next;
		head.next.prev = head;
		--size;
		return  temp;
		
	}
	public int size() {
        return size;
    }

	public static void main(String[] args) {
		Queue q = new Queue();

        // Add some elements
        q.add("Apple");
        q.add("Banana");
        q.add("Cherry");

        System.out.println("Queue size after adding: " + q.size());

        // Remove elements one by one
        System.out.println("Removed: " + q.remove()); // Apple
        System.out.println("Removed: " + q.remove()); // Banana

        System.out.println("Queue size now: " + q.size());

        // Add again
        q.add("Dates");
        System.out.println("Removed: " + q.remove()); // Cherry
        System.out.println("Removed: " + q.remove()); // Dates

        // Try removing from empty queue (will throw exception)
        try {
            q.remove();
        } catch (IllegalArgumentException e) {
            System.out.println("Exception: " + e.getMessage());
        }
	}

}
