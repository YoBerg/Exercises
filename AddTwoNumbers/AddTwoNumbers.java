import java.lang.Math;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node node = new Node(3);
    }

    public static void printList(Node head) {
        if (head.next) printListRecur(head.next);
        System.out.print(head.val);
        System.out.print("\n");
    }

    public static void printListRecur(Node node) {
        if (node.next) printListRecur(node.next);
        System.out.print(head.val);
    }

    public static Node createList(int val) {
        Node head = null;
        // Turn val into string
        // Read string from left to right, creating the node with the read digit.
        return head;
    }

    /**
     * Generate a random integer from 1 to the given maximum.
     * 
     * @param max the maximum integer of the random number.
     * @return a random interger from 1 to the given maximum.
     */
    public static int randomInt(int max) {
        return (int) Math.floor(Math.random() * (max)) + 1;
    }
}