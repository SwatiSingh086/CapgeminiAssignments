package Activity1;

public class Task3 {

    public static void main(String[] args) {

        SinglyLinkedList list=new SinglyLinkedList();

        list.insertAtBeginning(18);
        list.insertAtBeginning(8);
        list.insertAtEnd(30);
        list.insertAtEnd(80);

        list.traverse();

        list.search(80);
        list.search(100);
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data=data;
        this.next=null;
    }
}

class SinglyLinkedList {
	Node head=null;

    public void insertAtBeginning(int data) {
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode=new Node(data);
        if (head==null) {
            head=newNode;
            return;
        }
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newNode;
    }

    public void traverse() {
        if (head==null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp=head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void search(int key) {
        Node temp=head;
        int position=1;

        while (temp!=null) {
            if (temp.data==key) {
                System.out.println(position);
                return;
            }
            temp=temp.next;
            position++;
        }
        System.out.println("not found in the list");
    }
    
    public void reverse() {
        Node prev=null;
        Node current=head;
        Node next=null;

        while(current!=null) {
            next=current.next;   
            current.next=prev;   
            prev=current;       
            current=next;       
        }
        head=prev; 
    }

}

