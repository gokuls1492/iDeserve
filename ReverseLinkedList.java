import java.util.Scanner;

/**
 ideserve - LinkedList

 Given a linked list having n nodes. Reverse the list using recursive & iterative approach.
 */
public class ReverseLinkedList {

    public Node reverseListIterative(Node head){
        Node cur = head, prev = null, temp = head;
        while (cur != null){
            temp = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    public Node reverseListRecursive(Node head, Node cur){
        if (cur == null)
            return cur;
        else if (cur.getNext() == null){
            head = cur;
            return head;
        }
        head = reverseListRecursive(head, cur.getNext());
        cur.getNext().setNext(cur);
        cur.setNext(null);
        return head;
    }

    public void printList(Node head){
        Node temp  = head;
        while (temp != null){
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
    }

    public Node createList(int n){
        Node head = null , temp = null;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n node values");
        for (int i=1; i<=n; i++){
            Node node = new Node(input.nextInt());
            if (head == null){
                head = node;
                temp = head;
            }else {
                temp.setNext(node);
                temp = node;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        Node head = reverseLinkedList.createList(n);

        System.out.println("Recursive");
        head = reverseLinkedList.reverseListRecursive(head, head);
        reverseLinkedList.printList(head);

        System.out.println("\n" + "Iterative");
        head = reverseLinkedList.reverseListIterative(head);
        reverseLinkedList.printList(head);

    }
}
