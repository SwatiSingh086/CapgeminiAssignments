package Activity2;

public class SinglyLinkedListImplementation {
	public static void main(String[] args) {
		
		SinglyLinkedList list= new SinglyLinkedList();
	     list.insertAtPosition(10, 0);
	        list.insertAtPosition(20, 1);
	        list.insertAtPosition(30, 2);
	        list.insertAtPosition(25, 2);


	        list.deleteByValue(20);
	       
	        System.out.println("Count: " + list.countNodes());
	        System.out.println("Middle: " + list.findMiddle());

	        list.reverse();
	}

}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;
    
    void insertAtPosition(int data, int pos) {
        Node newNode = new Node(data);

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteByValue(int value) {
        if (head == null) return;

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    int countNodes() {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    int findMiddle() {
        if (head == null) return -1;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }    
}

