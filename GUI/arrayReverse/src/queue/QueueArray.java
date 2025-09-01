package queue;


public class QueueArray {
    private Object[] elements;
    private int back, front;
    private int size;
    private int cap;

    public QueueArray(int cap) {
        this.cap = cap;
        this.elements = new Object[cap];
        back = front = size = 0;
    }

    public void add(Object x) {
        if (size == elements.length) {
            resize();
        }
        elements[back] = x;
        back++;
        size++;
    }

    public Object remove() {
        if (size == 0) throw new IllegalArgumentException("Abe khali hai");
        Object x = elements[front];
        front++;
        size--;
        if (size == 0) {
            front = back = 0; // reset when empty
        }
        return x;
    }

    private void resize() {
        Object[] a = new Object[2 * elements.length];
        System.arraycopy(elements, front, a, 0, size);
        elements = a;
        front = 0;
        back = size;
        cap = elements.length;
    }
    public Object removeFifth() {
		if(size==0)throw new IllegalArgumentException("Empty");
		if(size<=4)throw new IllegalArgumentException("no fifith element");
		Object x = elements[4]; 
		for(int i = 4 ; i < size-1 ;i++) {
			elements[i]=elements[i+1];
		}
		elements[size]=null;
		//inside head.next we have ref of head
		size--;
		return x;
	}
    public Object removeNth(int n) {
		if(size==0)throw new IllegalArgumentException("Empty");
		if(size<=n)throw new IllegalArgumentException("no fifith element");
		Object x = elements[n]; 
		for(int i = n ; i < size-1 ;i++) {
			elements[i]=elements[i+1];
		}
		elements[size]=null;
		//inside head.next we have ref of head
		size--;
		return x;
	}

    public static void main(String[] args) {
        QueueArray q = new QueueArray(2);
        System.out.println("Initial cap: " + q.cap);

        q.add(1);
        q.add(2);
        q.add(3);  // triggers resize
        q.add(6);

        System.out.println("Removed: " + q.remove());
        q.add(5);

        System.out.println("Final cap: " + q.cap);
    }
}
