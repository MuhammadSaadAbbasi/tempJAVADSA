package arrayReverse;

class Node3 {
    int data;
    Node3 next;

    Node3(int x) {
        this.data = x;
        this.next = null;
    }

    Node3(int x, Node3 next) {
        this.data = x;
        this.next = next;
    }

    // Insert in sorted order
    public static Node3 NodeAdd(Node3 start, int x) {
        Node3 newNode = new Node3(x);

        // Case 1: Empty list or insert at beginning
        if (start == null || x < start.data) {
            newNode.next = start;
            return newNode;
        }

        // Traverse to find the right position
        Node3 current = start;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        // Insert newNode after current
        newNode.next = current.next;
        current.next = newNode;

        return start;
    }

    // Print list
    public static void printList(Node3 start) {
        Node3 temp = start;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node3 start = null;

        // Adding elements in unsorted order
        start = NodeAdd(start, 5);
        start = NodeAdd(start, 2);
        start = NodeAdd(start, 9);
        start = NodeAdd(start, 4);
        start = NodeAdd(start, 7);

        // Print sorted list
        printList(start);
    }
}
