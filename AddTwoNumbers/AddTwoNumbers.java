import java.lang.Math;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Node node = createList(512);
        printList(node);
    }

    public static void printList(Node head) {
        if (head.next != null) printListRecur(head.next);
        System.out.print(head.val);
        System.out.print("\n");
    }

    public static void printListRecur(Node node) {
        if (node.next != null) printListRecur(node.next);
        System.out.print(node.val);
    }

    /**
     * Creates a linked list from the given value
     * 
     * @param val the given value to be turned into a linked list.
     * @return the head of the created linked list
     */
    public static Node createList(int val) {
        Node head = null;
        // Turn val into a character array.
        char[] chars = ("" + val).toCharArray();
        // Read character array from left to right, creating the node with the read digit.
        for (int i = 0; i < chars.length; i++) {
            Node new_node = new Node(Character.getNumericValue(chars[i]), head);
            head = new_node;
        }
        if (head == null) return new Node(0);
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